package com.my.demo.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	
	/**
	 * javaBean 转 Map
	 * @param object
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> beanToMap(Object object) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		Class cls = object.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(object));
		}
		return map;
	}
	
	/**
	 * 需要转换的map
	 * @param map
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Object mapToBean(Map<String, Object> map, Class cls)throws Exception {
		Object object = cls.newInstance();
		for (String key : map.keySet()) {
			Field temFiels = cls.getDeclaredField(key);
			temFiels.setAccessible(true);
			temFiels.set(object, map.get(key));
		}
		return object;
	}


	public static void main(String[] args) throws Exception {
		QueryBQSParam queryBQSParam=new QueryBQSParam();
		queryBQSParam.setIdCardNo("123");
		queryBQSParam.setTrueName("789");
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("list1");
		list.add("list2");
		queryBQSParam.setList(list);
		queryBQSParam.setInteger(12);
		Map map=new HashMap();
		map.put("11","22");
		queryBQSParam.setMap(map);
		Map<String, Object> objectMap = beanToMap(queryBQSParam);
		Set<String> strings = objectMap.keySet();
		for (String key:strings){
			System.out.println(key+"="+objectMap.get(key));
		}
	}
 

}
