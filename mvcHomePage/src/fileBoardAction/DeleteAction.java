package fileBoardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class DeleteAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("pageNumber", pageNumber);
	
		return "/fileBoard/delete.jsp";
	} 
}
