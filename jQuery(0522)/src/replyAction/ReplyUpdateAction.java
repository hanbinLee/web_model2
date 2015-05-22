package replyAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import replyModel.ReplyDao;
import controller.CommandAction;

public class ReplyUpdateAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//bunho와 reply를 받아옴
		request.setCharacterEncoding("utf-8");
		int bunho=Integer.parseInt(request.getParameter("bunho"));
		String reply=request.getParameter("reply");
		//System.out.println(bunho+","+reply);
		
		int check=ReplyDao.getInstance().update(bunho, reply);
		//System.out.println(check);
		
		if(check>0){
			String src=bunho+","+reply;
			response.setContentType("application/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(src);
		}		
		
		return null;
	}

}
