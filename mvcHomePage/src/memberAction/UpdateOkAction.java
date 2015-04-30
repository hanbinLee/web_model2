package memberAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import memberModel.MemberDto;
import controller.CommandAction;

public class UpdateOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		MemberDto member=new MemberDto();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress(request.getParameter("address"));
		member.setInterest(request.getParameter("interest"));
		member.setJob(request.getParameter("job"));
		member.setMailing(request.getParameter("mailing"));
		
		int check=MemberDao.getInstance().update(member);
		
		request.setAttribute("check", check);
		return "/member/updateOk.jsp";
	}
	
}
