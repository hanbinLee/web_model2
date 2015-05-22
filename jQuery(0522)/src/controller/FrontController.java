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

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Object> commandMap=new HashMap<String, Object>();

    public FrontController() {
        super();
    }   

	@Override
	public void init(ServletConfig config){
		String configFile=config.getInitParameter("configFile");
		//System.out.println(configFile);
		
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
			System.out.println("FrontController configFile Error");
			e.printStackTrace();
		}finally{
			try{
				if(bis!=null) bis.close();
				if(fis!=null) fis.close();				
			}catch(IOException e){
				System.out.println("FrontController configFile Close Error");
				e.printStackTrace();
			}
		}
		
		Iterator<Object> keyIter=pro.keySet().iterator();
		while(keyIter.hasNext()){
			String command=(String)keyIter.next();
			String className=pro.getProperty(command);			
			//System.out.println(command+","+className);
			
			try {
				Class<?> handlerClass=Class.forName(className);
				Object handlerInstance=handlerClass.newInstance();
				
				commandMap.put(command, handlerInstance);
				
			} catch (Exception e) {
				System.out.println("FrontController commandMap Error");
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
		cmd=cmd.substring(request.getContextPath().length());
		//System.out.println("cmd: "+cmd);		
		
		String viewPage=null;
		try {
			CommandAction com=(CommandAction)commandMap.get(cmd);
			viewPage=com.proRequest(request, response);
						
		} catch (Throwable e) {
			System.out.println("FrontController proRequest Error");
			e.printStackTrace();
		}
		
		//System.out.println("viewPage: "+viewPage); 
	
		//template가 걸리지 않았을 땐 이렇게 다음 이동할 곳으로 forward해줌
		if(viewPage!=null){			//fileDownload 후에는 이동할 곳이 없어서 null이 반환되거든:)
			RequestDispatcher rd=request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}	
	}	
}
