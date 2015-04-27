package mvc02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction {
	public String proRequest(HttpServletRequest request,HttpServletResponse response){
		// request --> DB
		request.setAttribute("message", "글목록");
		
		return "/mvc/list.jsp";
	}
}
