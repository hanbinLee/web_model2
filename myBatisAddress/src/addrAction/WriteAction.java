package addrAction;

import javax.servlet.http.HttpServletRequest;

import controller.CommandAction;

public class WriteAction implements CommandAction{

	public String proRequest(HttpServletRequest request) throws Throwable {
	
		return "/addr/write.jsp";
	}
	
}
