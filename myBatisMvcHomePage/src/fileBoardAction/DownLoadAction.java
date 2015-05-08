package fileBoardAction;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import fileBoardModel.BoardDao;
import fileBoardModel.BoardDto;

public class DownLoadAction implements CommandAction{
	@Override
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		//System.out.println("boardNumber : " + boardNumber);
		
		BoardDto board=BoardDao.getInstance().fileRead(boardNumber);
		//System.out.println("board : " + board.getFileName());
		//System.out.println("path : " + board.getPath());
		
		String fileName=new String(board.getFileName().getBytes("UTF-8"),"ISO-8859-1");
		
		response.setHeader("Content-Disposition" , "attachment;filename="+fileName);
		response.setHeader("Content-Transfer-Encoding" , "binary");
		response.setContentType("application/octet-stream");
		response.setContentLength((int)board.getSize());
		
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		try{
			bis=new BufferedInputStream(new FileInputStream(board.getPath()));
			bos=new BufferedOutputStream(response.getOutputStream());
			
			byte[] by=new byte[(int)board.getSize()];
			int count=bis.read(by);
			
			for(int i=0;i<count;i++){
				bos.write(by[i]);
			}
			
			bos.flush();
		}catch(IOException e){
			System.out.println("downLoadAction Error");
			e.printStackTrace();
		}finally{
			if(bis!=null) bis.close();
			if(bos!=null)bos.close();
		}
		
		return null;
	}
 
}
