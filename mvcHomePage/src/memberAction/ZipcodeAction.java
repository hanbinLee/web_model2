package memberAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import memberModel.ZipcodeDto;
import controller.CommandAction;

public class ZipcodeAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String city=request.getParameter("zipcode");
		
		if(city!=null){
			//System.out.println("city : " + city);
			ArrayList<ZipcodeDto> list=MemberDao.getInstance().searchZipcode(city);
			request.setAttribute("list", list);
			
			return "/member/zipcodeResult.jsp";
		}else{
			return "/member/zipcode.jsp";
		}	
	}
}
