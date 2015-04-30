package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class DeleteAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		return "/member/delete.jsp";
	}	
}
