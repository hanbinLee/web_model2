package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable;
	
}
