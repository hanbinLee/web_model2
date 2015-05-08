package addrAction;

import javax.servlet.http.HttpServletRequest;

import addrModel.AddrDao;
import addrModel.AddrDto;
import controller.CommandAction;

public class SelectOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		
		AddrDto addr=AddrDao.getInstance().select(name);
		
		request.setAttribute("addr", addr);
		
		return "/addr/selectOk.jsp";
	}
	
}
