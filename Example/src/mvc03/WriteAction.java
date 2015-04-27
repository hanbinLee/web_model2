package mvc03;

import javax.servlet.http.HttpServletRequest;

public class WriteAction implements CommandAction{
	
	public String proRequest(HttpServletRequest request){
		request.setAttribute("message", "글쓰기");
		
		return "/mvc/write.jsp";
	}
}
