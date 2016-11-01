package userActionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysiteVo.UserVo;
import web.Action;
import webUtil.WebUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		if(session==null){
			WebUtil.redirect(request, response, "/mysite3/main");
			return;
		}
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		if(authUser==null){
			WebUtil.redirect(request, response, "/mysite3/main");
			return;
		}
		//logout 처리
		session.removeAttribute("authUser");
		session.invalidate();     // 세션 끊음
		
		WebUtil.redirect(request, response, "/mysite3/main");
	}

}
