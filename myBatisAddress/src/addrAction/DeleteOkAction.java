package addrAction;

import javax.servlet.http.HttpServletRequest;

import addrModel.AddrDao;
import controller.CommandAction;

public class DeleteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		//System.out.println("name : " + name);
		int value=AddrDao.getInstance().delete(name);
		
		request.setAttribute("result", new Integer(value));

		return "/addr/deleteOk.jsp";
	}	
}
