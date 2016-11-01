package guestbookActionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysiteDao.GuestBookDao;
import mysiteVo.GuestBookVo;
import net.sf.json.JSONObject;
import web.Action;

public class AjaxListAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spage = request.getParameter("p");
		int page;
		if ("".equals(spage)) {
			page = 1;
		} else {
			page = Integer.parseInt(spage);
		}

		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList(page);

		System.out.println(list);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", list);

		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
