package mvc02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction {
	public String prorequest(HttpServletRequest request,HttpServletResponse response){
		// request --> DB
		request.setAttribute("message", "글쓰기");
		
		return "/mvc/write.jsp";
	}
}
