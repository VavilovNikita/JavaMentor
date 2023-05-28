package main.java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static Map<Integer, String> properties = new HashMap<>();
	static String name = "C:\\workspace\\example\\src\\main\\java\\file.properties";//честно пытался не харкодить тут(нет)

	public static void save() throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(name);
		PrintWriter writer = new PrintWriter(fileOutputStream);
		for (Map.Entry<Integer, String> pair : properties.entrySet()) {
			Integer key = pair.getKey();
			String value = pair.getValue();
			String keyValue = key + ":" + value + "\n";
			writer.write(keyValue);
			writer.flush();
		}
		fileOutputStream.close();
	}

	public static Map<Integer, String> getProperties() {
		try {
			load();
		} catch (Exception e) {
			// TODO: handle exception
		}
			return properties;
	}

	public static void setProperties(Map<Integer, String> properties){
		Solution.properties = properties;
		try {
			save();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void load() throws Exception {
		FileInputStream fileInputStream = new FileInputStream(name);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		while (bufferedReader.ready()) {
			String[] s = bufferedReader.readLine().split(":");
			properties.put(Integer.parseInt(s[0]), s[1]);
		}
		bufferedReader.close();
	}
}
