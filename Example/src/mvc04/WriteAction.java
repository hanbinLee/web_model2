package mvc04;

import javax.servlet.http.HttpServletRequest;

public class WriteAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request) throws Throwable {
		request.setAttribute("message", "글쓰기");
		
		return "/mvc/write.jsp";
	}
}
