package com.kingtree.timer.vo;

import java.io.Serializable;

public class JsonVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7042743470434173785L;

	private boolean isSuccess;
	private String redirectUrl;
	private String msg;
	private Object data;

	public JsonVO() {
	}

	public JsonVO(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public JsonVO(boolean isSuccess, String redirectUrl, String msg, Object data) {
		this.isSuccess = isSuccess;
		this.redirectUrl = redirectUrl;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
