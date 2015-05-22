package replyAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import replyModel.ReplyDao;
import replyModel.ReplyDto;
import controller.CommandAction;

public class ReplySelectAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// bunho를 가지고 옴
		int bunho=Integer.parseInt(request.getParameter("bunho"));
		
		//bunho에 해당하는 기존 댓글을 가져옴
		ReplyDto reply=ReplyDao.getInstance().select(bunho);
		//System.out.println(reply);
		
		String src=reply.getBunho()+","+reply.getLine_reply();
		
		response.setContentType("application/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(src);
		
		return null;
	}

}
