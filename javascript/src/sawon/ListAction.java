package sawon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class ListAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String departmentName = request.getParameter("departmentName");
		//System.out.println(departmentName);
		
		List<Sawon> list = SawonDao.getInstance().getList(departmentName);
		
		//System.out.println(list.size());
		request.setAttribute("sawonList", list);
		return "/07_sawon/listOk.jsp";
	}
	
}
