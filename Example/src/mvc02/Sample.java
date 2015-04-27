package mvc02;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private HashMap<String,Object> commandMap=new HashMap<String,Object>();
	
	public Sample() {
		super();
	}
	
	public void init(){
		ListAction list=new ListAction();
		WriteAction write=new WriteAction();
		
		commandMap.put("list", list);
		commandMap.put("write", write);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		proRequest(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		proRequest(req,resp);
	}
	
	protected void proRequest(HttpServletRequest request,HttpServletResponse response)
			throws ServletException , IOException{
		String cmd=request.getParameter("cmd");
		String view=null;
		
		if(cmd.equals("list")){
			ListAction list=(ListAction)commandMap.get(cmd);
			view=list.proRequest(request, response);
		}else if(cmd.equals("write")){
			WriteAction write=(WriteAction)commandMap.get(cmd);
			view=write.prorequest(request, response);
		}
		
		System.out.println("view : " + view);
		
		//두가지 방법 다 가능
//		ServletContext context=this.getServletContext();
//		RequestDispatcher dis=context.getRequestDispatcher(view);
//		dis.forward(request, response);	
		request.getRequestDispatcher(view).forward(request, response);
	}
}
