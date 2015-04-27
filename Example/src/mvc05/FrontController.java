package mvc05;

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
    	String configFile=config.getInitParameter("configURI");
    	String path=config.getServletContext().getRealPath(configFile);
    	//System.out.println("configFile : " + configFile);
    	FileInputStream fis=null;
    	BufferedInputStream bis=null;
    	Properties pro=null;
    	
    	try{
    		fis=new FileInputStream(path);
    		bis=new BufferedInputStream(fis);
    		pro=new Properties();
    		pro.load(bis);       // =을 분리한다. 
    	}catch(Exception e){
    		e.printStackTrace();
    		System.out.println("ConfigFile error");
    	}finally{
    		try{
    			if(bis!=null) bis.close();
    			if(fis!=null)fis.close();
    		}catch(Exception e){
    			e.printStackTrace();
    			System.out.println("close error");
    		}
    	}
    	
    	Iterator<Object> keyIter=pro.keySet().iterator();
    	while(keyIter.hasNext()){
    		String command=(String) keyIter.next();
    		String className=pro.getProperty(command);
    	//	System.out.println(command + "\t" + className);
    		try {
				Class<?> classHandler=Class.forName(className);
				Object instance=(Command) classHandler.newInstance();
				commandMap.put(command, instance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proRequest(request, response);
	}
	
	protected void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//			String cmd=request.getParameter("cmd");
//			String view="";
//			
//			if(cmd!=null){
//				Command com=(Command)commandMap.get(cmd);
//				try {
//					view=com.proRequest(request, response);
//				} catch (Throwable e) {
//					e.printStackTrace();
//					System.out.println("proRequest error");
//				}
//				request.getRequestDispatcher(view).forward(request, response);
//			}
		
		
	}
}
