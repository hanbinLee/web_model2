package mvc04;

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

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String,Object> commandMap=new HashMap<String,Object>();
	
	public Controller() {
        super();
    }
	
	public void init(ServletConfig config){
		String configFile=config.getInitParameter("configFile");
	//	System.out.println("configFile : " + configFile);
		
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		Properties pro=new Properties(); // write=mvc04.WriteAction 에서 =표시만 분리해준다.
		
		try{
			fis=new FileInputStream(configFile);
			bis=new BufferedInputStream(fis);
			pro.load(bis);
			
			Iterator<Object> keyIter=pro.keySet().iterator();
			
			while(keyIter.hasNext()){
				String command=(String) keyIter.next();
				String className=pro.getProperty(command);
			//	System.out.println(command + "\t" + className);
				Class<?> handlerClass=Class.forName(className);
				Object handlerInstance=handlerClass.newInstance();
				commandMap.put(command,handlerInstance);
			}
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("configFile error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Class.ForName error");
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.println("handlerInstance error");
		} catch (IllegalAccessException e) {
			System.out.println("handlerInstance error");
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.proRequest(request, response);
	}
	
	protected void proRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String cmd=request.getParameter("cmd");
		String view="";
		
		try{
			if(cmd!=null){	
				CommandAction action=(CommandAction) commandMap.get(cmd);
				view=action.proRequest(request);
			}
		}catch(Throwable e){
			e.printStackTrace();
			System.out.println("클래스 못찾음");
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(view);
		dis.forward(request, response);
	}
}
