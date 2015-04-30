package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import controller.CommandAction;

public class LoginOkAction implements CommandAction {
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		//System.out.println("id : " + id + " password : " + password);
		String memberLevel=MemberDao.getInstance().login(id,password);
		//System.out.println("memberLevel : " + memberLevel);
		
		if(memberLevel !=null){
			request.setAttribute("id", id);
			request.setAttribute("memberLevel", memberLevel);	
		}
		
		return "/member/loginOk.jsp";
	}	
}
