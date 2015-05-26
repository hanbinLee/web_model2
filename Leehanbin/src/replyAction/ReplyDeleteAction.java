package replyAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import replyModel.ReplyDao;
import controller.CommandAction;

public class ReplyDeleteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int bunho=Integer.parseInt(request.getParameter("bunho"));
		//System.out.println("bunho: "+bunho);
		
		int check=ReplyDao.getInstance().delete(bunho);
		//System.out.println("check: "+check);
		
		if(check>0){
			response.setContentType("application/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(check);
		}
		
		return null;
	}

}
