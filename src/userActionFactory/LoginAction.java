package userActionFactory;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysiteDao.UserDao;
import mysiteVo.UserVo;
import web.Action;
import webUtil.WebUtil;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao=new UserDao();
		UserVo vo;
		try{
			vo=dao.get(email, password);
		
			if(vo==null){
				WebUtil.redirect(request, response, "/mysite3/user?a=loginform&result=fail");
				return;  // 주의 : redirect 를 한후 다음 코드가 실행되지 않도록 종료!
			}
			
			System.out.println("로그인 성공 -> 인증처리");
			HttpSession session=request.getSession(true);  // false or 빈 파라미터 -> j session id 와 연결된 session 객체가 없으면 null 리턴
						                                   // true  -> j session id 와 연결된 session 객체가 없으면 만들어 줌
			session.setAttribute("authUser", vo);   // 세션에 저장완료
			
			WebUtil.redirect(request, response, "/mysite3/main");
			
		}catch(SQLException e){
			System.out.println(e);
		}
		
		
		// 로그인 성공 -> 세션처리
	}

}
