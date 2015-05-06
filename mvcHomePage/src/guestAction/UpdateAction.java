package guestAction;

import guestModel.GuestDao;
import guestModel.GuestDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class UpdateAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		int num=Integer.parseInt(request.getParameter("num"));
		
		//System.out.println("pageNumber : " + pageNumber + "\t" + "num : " + num);
		
		GuestDto guest=GuestDao.getInstance().select(num);
		request.setAttribute("guest", guest);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/guest/update.jsp";
	}	
}
