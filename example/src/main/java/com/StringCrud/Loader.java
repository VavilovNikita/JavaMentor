package com.StringCrud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.StringCrud.models.Person;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Loader {

    private static final String FILE_NAME = "people.properties";
    ObjectMapper objectMapper = new ObjectMapper();


    public void saveToFile(Map<Integer, Person> map) {
        try (FileOutputStream fos = new FileOutputStream(getFileOrCreateIfNotExists())) {
            PrintWriter writer = new PrintWriter(fos);
            for (Map.Entry<Integer, Person> pair : map.entrySet()) {
                Integer key = pair.getKey();
                String value = objectMapper.writeValueAsString(map.get(key));
                String keyValue = key + ";" + value + "\n";
                writer.write(keyValue);
                writer.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error saving data to file: " + e.getMessage());
        }
    }

    public Map<Integer, Person> loadFromFile() {
        try (FileInputStream fis = new FileInputStream(getFileOrCreateIfNotExists())) {
            Map<Integer, Person> map = new HashMap<>();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            while (bufferedReader.ready()) {
                String[] s = bufferedReader.readLine().split(";");
                map.put(Integer.parseInt(s[0]),objectMapper.readValue(s[1], Person.class) );
            }
            bufferedReader.close();
            return map;
        } catch (Exception e) {
            throw new RuntimeException("Error reading data from file: " + e.getMessage());
        }
    }

    private File getFileOrCreateIfNotExists() throws IOException {
        String path = System.getProperty("user.home") + File.separator + FILE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}