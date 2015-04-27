package mvc03;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SampleCtn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String,Object> commandMap=new HashMap<String,Object>();
	
    public SampleCtn() {
        super();
        
    }
    
    public void init(){
    	ListAction list=new ListAction();
    	WriteAction write=new WriteAction();
    	
    	commandMap.put("list", list);
    	commandMap.put("write",write);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}
	
	protected void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		String view="";
		
		try{
			CommandAction action=(CommandAction)commandMap.get(cmd);
			view=action.proRequest(request);
		}catch(Throwable e){
			e.printStackTrace();
			System.out.println("클래스 못찾음");
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}
	
}
