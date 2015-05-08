package fileBoardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileBoardModel.BoardDao;
import fileBoardModel.BoardDto;
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
		
		return "/fileBoard/read.jsp";
	}
 
}
