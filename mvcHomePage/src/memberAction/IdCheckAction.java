package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import controller.CommandAction;

public class IdCheckAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String id=request.getParameter("id");
		//System.out.println("id" + id);
		
		int check=MemberDao.getInstance().checkId(id);
		//System.out.println("check : " + check);
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/member/idCheck.jsp";
	}
	
}
