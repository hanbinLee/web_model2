package addrAction;

import javax.servlet.http.HttpServletRequest;

import controller.CommandAction;

public class DeleteAction implements CommandAction {
	public String proRequest(HttpServletRequest request) throws Throwable {
		return "/addr/delete.jsp";
	}
	
}
