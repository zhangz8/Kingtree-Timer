package com.kingtree.timer.util;

/**
 * Mysql分布工具类
 * 
 * @author youchuan
 *
 */
public class PageUtil {

	public static int getStart(int page, int pageSize) {
		if (page < 0 || pageSize <= 0) {
			return 0;
		}
		return page <= 0 ? 0 : page * pageSize;
	}

	public static int getEnd(int page, int pageSize) {
		if (page < 0 || pageSize <= 0) {
			return 0;
		}
		return page <= 0 ? pageSize : page * pageSize + pageSize;
	}
}
