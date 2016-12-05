package com.kingtree.timer.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberUtil extends NumberUtils {
	public static String formatCurrency(Double value) {
		String result = "0.00";
		if (value != null)
			result = new DecimalFormat(",##0.00").format(value);
		return result;
	}

	public static String formatCurrency(BigDecimal value) {
		String result = "0.00";
		if (value != null)
			result = new DecimalFormat(",##0.00").format(value);
		return result;
	}

	public static BigDecimal formatMonery(BigDecimal value) {
		BigDecimal result = new BigDecimal("0.00");
		if (value != null)
			result = new BigDecimal(new DecimalFormat(",##0.00").format(value));
		return result;
	}

	public static String formatInteger(Double value) {
		String result = "0";
		if (value != null)
			result = new DecimalFormat(",##0").format(value);
		return result;
	}

	public static void main(String[] args) {
		System.out.println("=================" + formatCurrency(Double.valueOf(12345.9D)));
		String strNull = null;
		String strBlank = "";
		String strChar = "a";
		String strFloat = "7.2";
		String strInt = "7";

		System.out.println("--- testing NumberUtil.toInt(String param, int defaultValue)...");
		System.out.println("    NumberUtil.stringToInt(null,-1):" + toInt(strNull, -1));
		System.out.println("    NumberUtil.toInt(\"\",-1):" + toInt(strBlank, -1));
		System.out.println("    NumberUtil.toInt(\"a\",-1):" + toInt(strChar, -1));
		System.out.println("    NumberUtil.toInt(\"7.2\",-1):" + toInt(strFloat, -1));
		System.out.println("    NumberUtil.toInt(\"7\",-1):" + toInt(strInt, -1));

		System.out.println("--- testing NumberUtil.toInt(String param)...");
		System.out.println("    NumberUtil.toInt(null):" + toInt(strNull));
		System.out.println("    NumberUtil.toInt(\"\"):" + toInt(strBlank));
		System.out.println("    NumberUtil.toInt(\"a\"):" + toInt(strChar));
		System.out.println("    NumberUtil.toInt(\"7.2\"):" + toInt(strFloat));
		System.out.println("    NumberUtil.toInt(\"7\"):" + toInt(strInt));
	}
}