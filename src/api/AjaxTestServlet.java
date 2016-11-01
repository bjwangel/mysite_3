package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteVo.UserVo;
import net.sf.json.JSONArray;

@WebServlet({ "/ajax", "/Ajax" })
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		
		List<UserVo> list=new ArrayList<UserVo>();
		/*
		 {
		  "name":"변준우",
		  "message":"hello"
		 }
		*/
		UserVo vo1=new UserVo();
		vo1.setNo(10L);
		vo1.setName("변준우");
		vo1.setEmail("bjwangel@naver.com");
		vo1.setGender("male");
		list.add(vo1);
		
		UserVo vo2=new UserVo();
		vo2.setNo(11L);
		vo2.setName("둘리");
		vo2.setEmail("bjwangel22@naver.com");
		vo2.setGender("female");
		list.add(vo2);
		
		JSONArray jsonObject=JSONArray.fromObject(list);
		PrintWriter out= response.getWriter();
		out.print(jsonObject.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
