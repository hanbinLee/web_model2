package mvc01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SampleController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}

	protected void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		
		String view=null;
		if(cmd.equals("list")){
			ListAction list=new ListAction();
			view=list.proRequeest(request, response);
				//request.getAttribute("message"); , 글목록
			
		}else if(cmd.equals("write")){
			WriteAction write=new WriteAction();
			view=write.proRequeest(request, response);
			  //request.getAttribute("message"); , 글쓰기
		}
		
		//System.out.println("view : "  + view);
		ServletContext context=this.getServletContext(); //현재 서블릿 페이지 정보를 가져온다.
		RequestDispatcher dis=context.getRequestDispatcher(view);
		dis.forward(request, response);
	}
	
}
