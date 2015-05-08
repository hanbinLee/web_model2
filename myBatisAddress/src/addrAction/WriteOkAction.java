package addrAction;

import javax.servlet.http.HttpServletRequest;

import addrModel.AddrDao;
import addrModel.AddrDto;
import controller.CommandAction;

public class WriteOkAction implements CommandAction{
	
	public String proRequest(HttpServletRequest request) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		//System.out.println("name : " + name + " phone : " + phone + " email : " + email);
		AddrDto addr=new AddrDto();
		addr.setName(name);
		addr.setPhone(phone);
		addr.setEmail(email);
		
		int check=AddrDao.getInstance().insert(addr);
		//System.out.println("check");
		
		request.setAttribute("check", new Integer(check));
		
		return "/addr/writeOk.jsp";
	}
	
}
