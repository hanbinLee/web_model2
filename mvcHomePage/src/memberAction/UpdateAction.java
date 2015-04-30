package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import memberModel.MemberDto;
import controller.CommandAction;

public class UpdateAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String id=request.getParameter("id");
		
//		HttpSession session=request.getSession();
//		String id=(String) session.getAttribute("id");
		
		MemberDto member=MemberDao.getInstance().findMemberInfo(id);
		
		request.setAttribute("member", member);
		
		return "/member/update.jsp";
	}
	
}
