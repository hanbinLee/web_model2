package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class LogoutAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		return "/member/logout.jsp";
	}	
}
