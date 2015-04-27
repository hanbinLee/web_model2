package mvc03;

import javax.servlet.http.HttpServletRequest;

public interface CommandAction {
	public String proRequest(HttpServletRequest request) 
			throws Throwable;
}
