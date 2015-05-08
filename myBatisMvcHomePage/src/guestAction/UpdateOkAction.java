package guestAction;

import guestModel.GuestDao;
import guestModel.GuestDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class UpdateOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		GuestDto guest=new GuestDto();
		guest.setNum(Integer.parseInt(request.getParameter("num")));
		guest.setPassword(request.getParameter("password"));
		guest.setMessage(request.getParameter("message"));
		
		int check=GuestDao.getInstance().update(guest);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("check", check);
		//System.out.println("check : " + check);
		
		return "/guest/updateOk.jsp";
	} 
}
