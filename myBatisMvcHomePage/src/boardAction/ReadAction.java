package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDao;
import boardModel.BoardDto;
import controller.CommandAction;

public class ReadAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
//		System.out.println("boardNumber : " + boardNumber + "\t pageNumber : " + pageNumber);
		
		BoardDto board=BoardDao.getInstance().read(boardNumber);
//		System.out.println(board.getEmail());
		
		request.setAttribute("board", board);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/board/read.jsp";
	}
 
}
