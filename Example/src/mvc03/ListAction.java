package mvc03;

import javax.servlet.http.HttpServletRequest;

public class ListAction implements CommandAction {
	public String proRequest(HttpServletRequest request){
		request.setAttribute("message", "글목록");
		
		return "/mvc/list.jsp";
	}
}
