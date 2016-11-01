package userActionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteDao.UserDao;
import mysiteVo.UserVo;
import net.sf.json.JSONObject;
import web.Action;

public class CheckEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		UserDao dao=new UserDao();
		UserVo vo= dao.get(email);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("result", "success");
		if(vo==null){
			map.put("data", "not exist");
		}else{
			map.put("data", "exist");
		}
		
		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject=JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
