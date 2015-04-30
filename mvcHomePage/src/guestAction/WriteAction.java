package guestAction;

import guestModel.GuestDao;
import guestModel.GuestDto;

import java.util.ArrayList;

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
		int boardSize=10;
		
		//시작페이지,끝페이지
		int startPage=(currentPage-1)*boardSize+1;
		int endPage=currentPage*boardSize;
		
		ArrayList<GuestDto> guestList=null;
		if(count>0){
			guestList=GuestDao.getInstance().getGuestList(startPage,endPage);
		}
		
		System.out.println("size:" + guestList.size());
		return "/guest/write.jsp";
	}	
}
