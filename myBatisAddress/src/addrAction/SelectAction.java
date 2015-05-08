package addrAction;

import javax.servlet.http.HttpServletRequest;

import controller.CommandAction;

public class SelectAction implements CommandAction{
	@Override
	public String proRequest(HttpServletRequest request) throws Throwable {
		return "/addr/select.jsp";
	}
	
}
