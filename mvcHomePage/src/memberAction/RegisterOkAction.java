package memberAction;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberModel.MemberDao;
import memberModel.MemberDto;
import controller.CommandAction;

public class RegisterOkAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDto member=new MemberDto();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setJumin1(request.getParameter("jumin1"));
		member.setJumin2(request.getParameter("jumin2"));
		member.setEmail(request.getParameter("email"));
		
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress(request.getParameter("address"));
		member.setJob(request.getParameter("job"));
		member.setMailing(request.getParameter("mailing"));
		member.setInterest(request.getParameter("interest"));
		member.setMemberLevel("BA");
		member.setRegisterDate(new Date());
		
		int check=MemberDao.getInstance().insert(member);
		
		//System.out.println("check : " + check);
		request.setAttribute("check", check); //object만 들어가야하는데 autoBoxing이 되서 Integer 타입으로 변경
		return "/member/registerOk.jsp";
	}
	
}
