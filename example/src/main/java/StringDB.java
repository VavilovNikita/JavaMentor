package main.java;

import java.util.*;

abstract class StringDB {
	private int count = 0;
	protected Map<Integer, String> map;

	{
		try {
			map = Solution.getProperties();//получение строк из файла
			count = map.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean insert(String val) {
		if("".equals(val))
			return false;
		map.put(count++, val);
		return true;
	}

	protected boolean update(String val, int id) {
		if (!map.containsKey(id)) {
			return false;
		} else {
			map.put(id, val);
			return true;
		}
	}

	protected boolean remove(int id) {
		if (!map.containsKey(id)) {
			return false;
		} else {
			count--;
			for (int i = id; i < count; i++) {
				map.put(i, map.get(i + 1));
			}
		}
		return true;
	}

	protected String get(int id) {
		if (id >= 0) {
			return id + "-" + map.get(id);
		}
		String rasault = "";
		for (int i = 0; i < count; i++) {
			rasault += " " + i + "-" + map.get(i);
		}
		return rasault;
	}
}
