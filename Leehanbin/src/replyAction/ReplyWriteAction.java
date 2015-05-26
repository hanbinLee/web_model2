package replyAction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import replyModel.ReplyDao;
import replyModel.ReplyDto;
import controller.CommandAction;

public class ReplyWriteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		//System.out.println("board" + request.getParameter("boardNumber"));
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		String lineReply=request.getParameter("lineReply");		
		//System.out.println(boardNumber+", "+lineReply);
		
		ReplyDto reply=new ReplyDto();
		reply.setBoard_number(boardNumber);
		reply.setLine_reply(lineReply);
		
		int check=ReplyDao.getInstance().insert(reply);		//DB에 부모글번호와 댓글내용을 insert함
		//System.out.println("check: "+check);
		
		//DB에 들어간 댓글을 바로 댓글 리스트 위에 뿌려주자.
		//DB에 들어가면서!! 댓글의 글번호(자동증가번호)가 생긴다. (insert 후에 글번호가 결정됨.)
		//그런데 replyList.jsp에서 댓글 목록을 뿌려줄 때 댓글의 글번호도 함께 뿌려줘야 하잖아
		//글번호 중 max값을 가져와서 그 글번호의 레코드를 뿌리는 걸로
		//(자동증가번호가 가장 큰 레코드는 방금 insert한 레코드가 되겠지.) 
		if(check>0){
			int bunho=ReplyDao.getInstance().getBunho();//글번호가 가장 큰 댓글(즉, 방금 insert한 댓글)의 글번호를 반환한다.
			//System.out.println("bunho: "+bunho);
			String str=bunho+","+lineReply;				//후에 ,를 기준으로 0번지와 1번지로 나눌 것.
			
			//bunho와 lineReply를 replyList.jsp에 뿌리자 (writeFromServer로 받아서 replyList.jsp에 뿌릴거야)
			response.setContentType("application/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print(str);
		}
		
		return null;
	}

}
