package controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String,Object> commandMap=new HashMap<String,Object>();
    
	public FrontController() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException{
		String configFile=config.getInitParameter("configFile");
		//System.out.println("ConfigFile : " + configFile);
		
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		Properties pro=null;
		
		try{
			String path=config.getServletContext().getRealPath(configFile);
			fis=new FileInputStream(path);
			bis=new BufferedInputStream(fis);
			
			pro=new Properties();
			pro.load(bis);
		}catch(Exception e){
			System.out.println("ConfigFile Error");
			e.printStackTrace();
		}finally{
			try{
				if(bis!=null)bis.close();
				if(fis!=null)fis.close();
			}catch(IOException e){
				e.printStackTrace();
				System.out.println("IO Close Error");
			}
		}
		
		Iterator<Object> keyIter=pro.keySet().iterator();
		while(keyIter.hasNext()){
			String command=(String)keyIter.next();
			String className=pro.getProperty(command);
			//System.out.println("command : " + command + "\t className : " + className );
			
			try{
				Class<?> handlerClass=Class.forName(className);
				Object handlerInstance=handlerClass.newInstance();
				commandMap.put(command, handlerInstance);
			}catch(Exception e){
				System.out.println("HandlerInstance Error");
				e.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request, response);
	}
	
	protected void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
		String cmd2=cmd.substring(request.getContextPath().length());
		//System.out.println("cmd : "  + cmd);
		//System.out.println("cmd2 : " + cmd2);
		
		String view="";
		try{
			CommandAction com = (CommandAction) commandMap.get(cmd2);
			view=com.proRequest(request);
			
			//System.out.println("view : " + view);
		}catch(Throwable e){
			System.out.println("proRequestError");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}
