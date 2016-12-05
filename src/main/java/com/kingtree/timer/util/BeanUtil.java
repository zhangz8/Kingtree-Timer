package com.kingtree.timer.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.BeanUtils;

public class BeanUtil {
	public static boolean copyFields(Object tar, Object src) {
		if ((null == tar) || (null == src))
			return false;

		Class tarClazz = tar.getClass();
		Class srcClazz = src.getClass();
		Field[] tarFields = tarClazz.getDeclaredFields();

		for (Field field : tarFields) {
			String fieldname = field.getName();
			String name = capitaliz(fieldname);
			try {
				srcClazz.getDeclaredField(fieldname);
				Class tarFieldType = field.getType();
				String getMethodName = "get" + name;
				String setMethodName = "set" + name;
				Method merhod = srcClazz.getDeclaredMethod(getMethodName, new Class[0]);
				Object val = merhod.invoke(src, new Object[0]);

				Class clazz = null;
				if ((val instanceof Date))
					clazz = Date.class;
				else if ((val instanceof Double))
					clazz = Double.class;
				else if ((val instanceof Long))
					clazz = Long.class;
				else if ((val instanceof Integer))
					clazz = Integer.class;
				else if ((val instanceof String))
					clazz = String.class;
				else if ((val instanceof BigDecimal)) {
					clazz = BigDecimal.class;
				}
				if ((null != clazz) && (clazz == tarFieldType) && (null != val)) {
					Method setmerhod = tarClazz.getDeclaredMethod(setMethodName, new Class[] { clazz });
					setmerhod.invoke(tar, new Object[] { val });
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean copyFields(Object tar, Map src) {
		if ((null == tar) || (null == src))
			return false;

		Class tarClazz = tar.getClass();
		Field[] tarFields = tarClazz.getDeclaredFields();

		for (Field field : tarFields) {
			String fieldname = field.getName();
			String name = capitaliz(fieldname);
			try {
				Class tarFieldType = field.getType();
				String setMethodName = "set" + name;

				if ((!src.containsKey(fieldname)) || (null != src.get(fieldname))) {
					Object val = src.get(fieldname);
					String str = String.valueOf(val);
					if (tarFieldType == Date.class)
						val = DateFormatUtil.toDate(str, "yyyy-MM-dd HH:mm");
					else if (tarFieldType == Double.class)
						val = Double.valueOf(NumberUtil.toDouble(str));
					else if (tarFieldType == Long.class)
						val = Long.valueOf(NumberUtil.toLong(str));
					else if (tarFieldType == Integer.class)
						val = Integer.valueOf(NumberUtil.toInt(str));
					else if (tarFieldType == BigDecimal.class) {
						val = Double.valueOf(NumberUtil.toDouble(str));
					}
					Method setmerhod = tarClazz.getDeclaredMethod(setMethodName, new Class[] { tarFieldType });
					setmerhod.invoke(tar, new Object[] { val });
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static Object createObject(String objstr) {
		Object o = null;
		if (null == objstr)
			return o;
		try {
			o = Class.forName(objstr).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}

	public static void copyProperties(Object tar, Object src) throws IllegalAccessException {
		BeanUtils.copyProperties(tar, src);
	}

	private static String capitaliz(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static void main(String[] args) {
	}
}