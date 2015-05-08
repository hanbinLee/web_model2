package fileBoardAction;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import fileBoardModel.BoardDao;
import fileBoardModel.BoardDto;

public class DeleteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		String password=request.getParameter("password");
		
		BoardDto readBoard=BoardDao.getInstance().fileRead(boardNumber);
		
		String readFilePath=readBoard.getPath();
		
		int check=BoardDao.getInstance().delete(boardNumber,password);
		
		if(check > 0 && readFilePath !=null){
			File file=new File(readFilePath);
			if(file.exists() && file.isFile()) file.delete();
		}
		
		//System.out.println("check: " + check);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("check", check);
		request.setAttribute("boardNumber", boardNumber);
		
		return "/fileBoard/deleteOk.jsp";
	}
	
}
