package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestingAction implements CommandAction{
	public String proRequest(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		
		request.setAttribute("msg", "FrontController & Command Test");
		return "/07_sawon/view.jsp";
	}
	
}
