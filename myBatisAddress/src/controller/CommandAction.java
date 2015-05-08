package controller;

import javax.servlet.http.HttpServletRequest;

public interface CommandAction {
	public String proRequest(HttpServletRequest request) throws Throwable;
}
