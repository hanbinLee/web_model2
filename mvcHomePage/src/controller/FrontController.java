package controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private HashMap<String,Object> commandMap=new HashMap<String,Object>();
	
	public FrontController() {
		super();
	}
	
	public void init(ServletConfig config){
		String configFile=config.getInitParameter("configFile");
		//System.out.println("configFile : " + configFile);
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
			System.out.println("init Error");
			e.printStackTrace();
		}finally{
			try{
				if(bis!=null) bis.close();
				if(fis!=null) fis.close();
			}catch(IOException e){
				System.out.println("init close Error");
				e.printStackTrace();
			}
		}
		
		Iterator<Object> keyIter=pro.keySet().iterator();
		
		while(keyIter.hasNext()){
			String command=(String) keyIter.next();
			String className=pro.getProperty(command);
			
			//System.out.println("command : " + command + " className : " + className);
			
			try{
				Class<?> handlerClass=Class.forName(className);
				Object handlerInstance=handlerClass.newInstance();
				commandMap.put(command, handlerInstance);
			}catch(Exception e){
				System.out.println("init2 Error");
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.proRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.proRequest(req, resp);
	}
	
	protected void proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd=request.getRequestURI();
		String cmdPath=cmd.substring(request.getContextPath().length());
		//System.out.println("cmd : " + cmd);
		//System.out.println("cmdPath : " + cmdPath);
		String viewPage="";
		
		try{
			CommandAction com=(CommandAction)commandMap.get(cmdPath);
			viewPage=com.proRequest(request, response);
		} catch (Throwable e) {
			System.out.println("proRequest Error");
			e.printStackTrace();
		}
		//System.out.println("viewPage : " + viewPage);
	//	if(viewPage !=null) request.getRequestDispatcher(viewPage).forward(request, response);
		//template 추가시
		if(viewPage !=null) {
			request.setAttribute("viewPage", viewPage);
			RequestDispatcher rd=request.getRequestDispatcher("/template/index.jsp");
			rd.forward(request, response);
		}
	}	
	
}
