package guestAction;

import guestModel.GuestDao;
import guestModel.GuestDto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class WriteAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//총 레코드수
		int count=GuestDao.getInstance().getCount();
		//System.out.println("count : " + count);
		
		//페이지당 게시물 수
		String pageNumber=request.getParameter("pageNumber");
		if(pageNumber==null) pageNumber="1";
		
		int currentPage=Integer.parseInt(pageNumber);
		
		//한페이지당 보여질 게시물 수
		int boardSize=3;
		
		//페이지 블록 만약 3이면 [1]..[3]  , [4]..[6]
 		int pageBlock=3;
		
		//시작페이지,끝페이지
		int startPage=(int)((currentPage-1)/pageBlock)+1;
	//	int startPage=currentPage;
 		int endPage=startPage+pageBlock-1;
		
		List<GuestDto> guestList=null;
		if(count>0){
			guestList=GuestDao.getInstance().getGuestList(currentPage*boardSize-2,currentPage*boardSize);
		}
		
		request.setAttribute("count", count); //총 레코드수
		request.setAttribute("guestList",guestList); //페이지당 게시물 수 
		request.setAttribute("currentPage", currentPage); //현재 페이지
		request.setAttribute("boardSize", boardSize); //페이지당 게시물 갯수
		request.setAttribute("startPage",startPage); 
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageBlock", pageBlock);
		
		//System.out.println("count : " + count);
		//System.out.println("startPage : " + startPage);
		//System.out.println("endPage : " + endPage);
		//System.out.println("List size:" + guestList.size());
		
		return "/guest/write.jsp";
	}	
}
