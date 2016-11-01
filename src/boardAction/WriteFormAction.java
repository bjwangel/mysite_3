package boardAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysiteVo.UserVo;
import web.Action;
import webUtil.WebUtil;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if(session==null){
			WebUtil.redirect(request, response, "/mysite3/board");
			return;
		}
		
		UserVo authUser=(UserVo)session.getAttribute("authUser");
		if(authUser==null){
			WebUtil.forward(request, response, "/WEB-INF/views/board/write.jsp");
			return;
		}

		WebUtil.forward(request, response, "/WEB-INF/views/board/write.jsp");
	}
}
