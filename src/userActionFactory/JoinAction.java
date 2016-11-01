package userActionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteDao.UserDao;
import mysiteVo.UserVo;
import web.Action;
import webUtil.WebUtil;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String passWord = request.getParameter("password");
		String gender = request.getParameter("gender");

		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassWord(passWord);
		vo.setGender(gender);

		UserDao dao = new UserDao();
		dao.insert(vo);

		WebUtil.redirect(request, response, "/mysite3/user?a=joinsuccess");

	}

}
