package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import domain.*;
import persistence.*;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubrequest.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String cmdReq;
		cmdReq = request.getParameter("cmd");
		if (cmdReq == null)
			return;

		JSONArray arrayJson = new JSONArray();

		if (cmdReq.equals("user_list")) {
			try {
				UserDAO userDAO = new UserDAO();
				List<UserVO> userList = userDAO.getUsersList();
				for (UserVO vo : userList) {
					JSONObject json = new JSONObject();
					json.put("id", vo.getId());
					json.put("passwd", vo.getPasswd());
					json.put("username", vo.getUsername());
					arrayJson.put(json);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
		}
		if (cmdReq.equals("forum_list")) {
			try {
				ForumDAO forumDAO = new ForumDAO();
				List<ForumVO> forumList = forumDAO.getForumsList();
				for (ForumVO vo : forumList) {
					JSONObject json = new JSONObject();
					json.put("creator", vo.getCreator());
					json.put("category", vo.getCategory());
					json.put("user_id", vo.getUser_id());
					json.put("content", vo.getContent());
					json.put("upload_date", vo.getUpload_date());
					arrayJson.put(json);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
		}
		if (cmdReq.equals("user_read")) {
			try {
				UserDAO userDAO = new UserDAO();
				String id = request.getParameter("id");
				if (id == null) {
					out.print("id를 입력해주세요");
					return;
				}
				UserVO user = userDAO.read(id);
				JSONObject json = new JSONObject();
				json.put("id", user.getId());
				json.put("passwd", user.getPasswd());
				json.put("username", user.getUsername());
				arrayJson.put(json);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
		}
		if (cmdReq.equals("forum_read")) {
			try {
				ForumDAO forumDAO = new ForumDAO();
				String creator = request.getParameter("creator");
				if (creator == null) {
					out.print("creator를 입력해주세요");
					return;
				}
				ForumVO user = forumDAO.read(creator);
				JSONObject json = new JSONObject();
				json.put("creator", user.getCreator());
				json.put("category", user.getCategory());
				json.put("user_id", user.getUser_id());
				json.put("content", user.getContent());
				json.put("upload_date", user.getUpload_date());
				arrayJson.put(json);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(arrayJson);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
