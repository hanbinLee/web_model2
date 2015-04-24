package mvc01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction {
	public String proRequeest(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("message", "글목록");
		
		return "/mvc/list.jsp";
	}
}
