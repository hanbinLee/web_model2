package boardAction;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDao;
import boardModel.BoardDto;
import controller.CommandAction;

public class WriteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
		int sequenceNumber = Integer.parseInt(request.getParameter("sequenceNumber"));
		int sequenceLevel = Integer.parseInt(request.getParameter("sequenceLevel"));
		
//		System.out.println("boardNumber : " + boardNumber);
//		System.out.println("groupNumber : " + groupNumber);
//		System.out.println("sequenceNumber : " + sequenceNumber);
//		System.out.println("sequenceLevel : " + sequenceLevel);
		
		BoardDto board=new BoardDto();
		board.setBoardNumber(boardNumber);
		board.setGroupNumber(groupNumber);
		board.setSequenceLevel(sequenceLevel);
		board.setSequenceNumber(sequenceNumber);
		
		board.setWriter(request.getParameter("writer"));
		board.setSubject(request.getParameter("subject"));
		board.setEmail(request.getParameter("email"));
		board.setContent(request.getParameter("content"));
		board.setPassword(request.getParameter("password"));
		board.setWriteDate(new Date());
		board.setReadCount(0);
		board.setIp(request.getRemoteAddr());
		
		int check=BoardDao.getInstance().insert(board);
		
		request.setAttribute("check", check);
		//System.out.println("check : " + check);
		return "/board/writeOk.jsp";
	}
	
}
