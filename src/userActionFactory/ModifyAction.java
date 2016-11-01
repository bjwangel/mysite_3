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

public class ModifyAction implements Action {

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
			UserVo vo= new UserVo();
			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String gender= request.getParameter("gender");
			
			vo.setNo(authUser.getNo());
			vo.setName(name);
			vo.setPassWord(password);
			vo.setGender(gender);
			
			boolean result=dao.update(vo);
			
			if(result){
				authUser.setName(name);
			}
		WebUtil.redirect(request, response, ".user?a=modifyform&result=sucess");
		
		}
	}

}
