package boardAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class WriteAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber=0;
		int groupNumber=1;
		int sequenceNumber=0;
		int sequenceLevel=0;
		
		if(request.getParameter("boardNumber") !=null){
			boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber=Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber=Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel=Integer.parseInt(request.getParameter("sequenceLevel"));
		}
		
		//System.out.println("boardNumber : " + boardNumber + "\t groupNumber : " + groupNumber );
		//System.out.println("sequenceNumber : " + sequenceNumber + "\t sequenceLevel : " + sequenceLevel);
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequenceLevel", sequenceLevel);
		
		return "/board/write.jsp";
	}
 
}
