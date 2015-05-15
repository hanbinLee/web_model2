package parsingXML;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import controller.CommandAction;

public class ProxyAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//프록시 서버 : 시스템에 방화벽을 가지고 있는 경우
		// 					외부와 통신을 위해 만들어 놓은 서버입니다.
		//					방화벽 안쪽에 있는 서버들의 외부 프록시 서버를 통해서 이루어 진다.
		//System.out.println("ok");
		
		String url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
		
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		
		int code = client.executeMethod(method);
		//System.out.println("code : " + code);
	
		if(code==HttpStatus.SC_OK) {  //code == 200
			String result = method.getResponseBodyAsString();
			response.setContentType("text/xml;charset=utf-8");
			//System.out.println(result);
			PrintWriter out = response.getWriter();
			out.print(result);
		}    		
		return null;
	}
	 
}
