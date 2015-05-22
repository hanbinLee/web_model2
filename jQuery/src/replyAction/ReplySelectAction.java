package replyAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import replyModel.ReplyDao;
import replyModel.ReplyDto;
import controller.CommandAction;

public class ReplySelectAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int bunho = Integer.parseInt(request.getParameter("bunho"));
		System.out.println(bunho);
		
		ReplyDto reply = ReplyDao.getInstance().select(bunho);
		//System.out.println(reply.getBoard_number() + "," + reply.getBunho() + "," + reply.getLine_reply());
		
		response.setContentType("application/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(reply.getLine_reply()+"/"+reply.getBunho());
		
		return null;
	}
	
}
