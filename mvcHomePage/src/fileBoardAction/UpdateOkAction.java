package fileBoardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileBoardModel.BoardDao;
import fileBoardModel.BoardDto;
import controller.CommandAction;

public class UpdateOkAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String password=request.getParameter("password");
		
		BoardDto board=new BoardDto();
		
		board.setBoardNumber(boardNumber);
		board.setSubject(subject);
		board.setContent(content);
		board.setPassword(password);
		
		int check=BoardDao.getInstance().update(board);
		
		//System.out.println("check : " + check);
		
		request.setAttribute("check", check);
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/fileBoard/updateOk.jsp";
	}
 
}
