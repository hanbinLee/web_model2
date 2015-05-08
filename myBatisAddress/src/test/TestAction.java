package test;

import javax.servlet.http.HttpServletRequest;

import controller.CommandAction;

public class TestAction implements CommandAction{

	public String proRequest(HttpServletRequest request) throws Throwable {
		
		//DB
		request.setAttribute("msg", "mvc테스트 입니다." );
		return "/test/test.jsp";
	}
	
}
