package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDao;
import controller.CommandAction;

public class DeleteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		String password=request.getParameter("password");
		
		
		int check=BoardDao.getInstance().delete(boardNumber,password);
		
		System.out.println("check: " + check);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("check", check);
		request.setAttribute("boardNumber", boardNumber);
		
		return "/board/deleteOk.jsp";
	}
	
}
