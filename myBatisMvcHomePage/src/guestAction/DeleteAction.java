package guestAction;

import guestModel.GuestDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class DeleteAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int num=Integer.parseInt(request.getParameter("num"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		System.out.println(num + "\t" + pageNumber);
		
		int check=GuestDao.getInstance().delete(num);
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/guest/delete.jsp";
	}	
}
