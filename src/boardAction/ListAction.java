package boardAction;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteDao.BoardDao;
import mysiteVo.BoardVo;
import web.Action;
import webUtil.WebUtil;


					
public class ListAction implements Action {
	private static final int LIST_SIZE = 5;
	private static final int PAGE_SIZE = 5;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = WebUtil.checkIntParam( request.getParameter( "p" ), 1 );
		
		BoardDao dao = new BoardDao();

		int totalCount = dao.getTotalCount(); 
		int pageCount = (int)Math.ceil( totalCount / LIST_SIZE );
		if( page > pageCount ) {
			page = 1;
		}
		
		List<BoardVo> list = dao.getList( page, LIST_SIZE );


		
		request.setAttribute( "list", list );
		
		request.setAttribute( "totalCount", totalCount );
		request.setAttribute( "currentPage", page );
		request.setAttribute( "listSize", LIST_SIZE );
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}
}