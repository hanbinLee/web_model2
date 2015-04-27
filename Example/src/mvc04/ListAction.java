package mvc04;

import javax.servlet.http.HttpServletRequest;

public class ListAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request) throws Throwable {
		request.setAttribute("message", "글목록");
		
		return "/mvc/list.jsp";
	}
}
