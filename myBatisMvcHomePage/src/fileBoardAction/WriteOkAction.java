package fileBoardAction;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import controller.CommandAction;
import fileBoardModel.BoardDao;
import fileBoardModel.BoardDto;

public class WriteOkAction implements CommandAction{
	public String proRequest(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		//객체 저장
		DiskFileItemFactory factory=new DiskFileItemFactory();
		
		//요청처리하는 객체
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setFileSizeMax(1024*1024*20);
		
		List<FileItem> list=upload.parseRequest(request);
		
		Iterator<FileItem> iter=list.iterator();
		BoardDto board=new BoardDto();
		HashMap<String,String> dataMap=new HashMap<String,String>();
		
		while(iter.hasNext()){
			FileItem item=iter.next();
			//text
			if(item.isFormField()){
//				if(item.getFieldName().equals("boardNumber")){
//					board.setBoardNumber(Integer.parseInt(item.getString("utf-8")));
//				}else if{} ....
				String name=item.getFieldName();
				String value=item.getString("UTF-8");
				dataMap.put(name, value);
			//	board.setDataMap(dataMap);
			//binary	
			}else{
				//실제경로 , 유일한 이름
				if(item.getFieldName().equals("file")){
					String fileName=item.getName();
					String dirFileName="";
					if(fileName==null || fileName.equals("")){
						board.setFileName("nofile");
						board.setPath("nofile");
						board.setSize(0);
						continue;
					}else{
						long currentTime=System.currentTimeMillis();
						dirFileName=Long.toString(currentTime) + "_" + fileName;
					}
					//System.out.println("dirFileName : " + dirFileName);
//					String dir="C:/Users/KOSTA_07_002/Documents/workspace/mvcHomePage/WebContent/pds";
					
					// 생성된 session 이 있으면 가져오고 , 없으면 새로운 세션을 만듦
					HttpSession session=request.getSession();
					String dir=session.getServletContext().getRealPath("/pds");
					
					File file=new File(dir,dirFileName);
					
					board.setFileName(fileName);
					board.setPath(file.getAbsolutePath()); //시간이 들어간 파일명 (dirFileName)
					board.setSize(item.getSize());
				}
			}
		}
		board.setDataMap(dataMap);
		board.setWriteDate(new Date());
		board.setReadCount(0);
		board.setIp(request.getRemoteHost());
		
		int check=BoardDao.getInstance().insert(board);
		
		request.setAttribute("check", check);
		
		return "/fileBoard/writeOk.jsp";
	}
	
}
