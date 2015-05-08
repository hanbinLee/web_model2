package boardAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardModel.BoardDao;
import boardModel.BoardDto;
import controller.CommandAction;

public class ListAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		String pageNumber=request.getParameter("pageNumber");
		
		if(pageNumber==null)	pageNumber="1";
		
		int currentPage=Integer.parseInt(pageNumber);
		
		int boardSize=4;
		
		int startRow=(currentPage-1)*boardSize + 1;
		int endRow=currentPage*boardSize;
		
		int count=BoardDao.getInstance().getCount();
		//System.out.println("getCount count : " + count);
		
		ArrayList<BoardDto> boardList=null;
		
		if(count>0){
			boardList=BoardDao.getInstance().getBoardList(startRow,endRow);
		}
		
		//System.out.println("list size : " + boardList.size());
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardList", boardList);
		
		return "/board/list.jsp";
	} 
}