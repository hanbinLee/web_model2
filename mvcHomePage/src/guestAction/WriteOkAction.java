package guestAction;

import guestModel.GuestDao;
import guestModel.GuestDto;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class WriteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		GuestDto guest=new GuestDto();
		guest.setName(request.getParameter("name"));
		guest.setPassword(request.getParameter("password"));
		guest.setMessage(request.getParameter("message"));
		guest.setWriteDate(new Date());
		
		int check=GuestDao.getInstance().insert(guest);
		
		request.setAttribute("check", check);
		//System.out.println("check : " + check);
		
		return "/guest/writeOk.jsp";
	}	
}
