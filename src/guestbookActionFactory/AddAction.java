package guestbookActionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteDao.GuestBookDao;
import mysiteVo.GuestBookVo;
import web.Action;
import webUtil.WebUtil;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String content=request.getParameter("content");
		
		GuestBookVo vo=new GuestBookVo();
		vo.setName(name);
		vo.setContent(content);
		vo.setPassWord(password);
		
		GuestBookDao dao=new GuestBookDao();
		dao.insert(vo);
		
		WebUtil.redirect(request, response, "/mysite3/guestbook");

	}

}
