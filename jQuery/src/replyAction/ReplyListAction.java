package replyAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import replyModel.ReplyDao;
import replyModel.ReplyDto;
import controller.CommandAction;

public class ReplyListAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//부모의 글은 임의로 100이라 하자.
		int boardNumber=100;
		int test = 30;
		request.setAttribute("boardNumber", boardNumber);	
		request.setAttribute("test", test);
		//DB에 있는 기존 레코드들 가져와서 뿌려주기		
		List<ReplyDto> replyList=ReplyDao.getInstance().getList(boardNumber);
		//System.out.println(replyList.size());
		request.setAttribute("replyList", replyList);
		
		return "/12_reply/replyList.jsp";
	}

}
