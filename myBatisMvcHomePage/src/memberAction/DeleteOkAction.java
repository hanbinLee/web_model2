package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import controller.CommandAction;

public class DeleteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		//System.out.println("id : " + id + " password : " + password);
		
		int check=MemberDao.getInstance().delete(id,password);
		
		request.setAttribute("check", check);
		//System.out.println("check : " + check);
		return "/member/deleteOk.jsp";
	}	
}
