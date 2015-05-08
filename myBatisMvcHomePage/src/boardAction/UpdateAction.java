package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDao;
import boardModel.BoardDto;
import controller.CommandAction;

public class UpdateAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		//System.out.println("b : " + boardNumber + "\t p : " + pageNumber);
		BoardDto board=BoardDao.getInstance().getInfo(boardNumber);
		
		request.setAttribute("pageNumber",pageNumber);
		request.setAttribute("board", board);
		
		return "/board/update.jsp";
	}
}
