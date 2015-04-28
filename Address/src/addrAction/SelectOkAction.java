package addrAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import addrModel.AddrDao;
import addrModel.AddrDto;
import controller.CommandAction;

public class SelectOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		
		ArrayList<AddrDto> list=AddrDao.getInstance().select(name);
		
		request.setAttribute("addr", list);
		
		return "/addr/selectOk.jsp";
	}
	
}
