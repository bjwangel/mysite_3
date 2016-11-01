package guestbookActionFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteDao.GuestBookDao;
import mysiteVo.GuestBookVo;
import web.Action;
import webUtil.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookDao dao=new GuestBookDao();
		List<GuestBookVo> list= dao.getList();
		
		request.setAttribute("list", list);
		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
	}

}
