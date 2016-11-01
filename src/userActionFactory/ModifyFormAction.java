package userActionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysiteDao.UserDao;
import mysiteVo.UserVo;
import web.Action;
import webUtil.WebUtil;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		if(session==null){
			WebUtil.redirect(request, response, "/main");
			return;
		}
		
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		
		if(authUser != null){
			UserDao dao=new UserDao();
			UserVo userVo=dao.get(authUser.getNo());
			
			request.setAttribute("userVo", userVo);
			WebUtil.forward(request, response, "/WEB-INF/views/user/ModifyForm.jsp");
		}
	}
}
