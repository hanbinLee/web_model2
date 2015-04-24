package mvc01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction {
public String proRequeest(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("message", "글쓰기");
		
		return "/mvc/write.jsp";
	}
}
