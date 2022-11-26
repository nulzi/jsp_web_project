package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ForumVO;
import persistence.ForumDAO;
import service.ForumFilter;
import service.PostOwner;

@WebServlet("/ForumServlet")
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		
		if (cmdReq.equals("add")) {
			response.sendRedirect("register.html");
		} else if (cmdReq.equals("category")) {
			String category = request.getParameter("category");

			ForumDAO dao = new ForumDAO();
			ArrayList<ForumVO> postList = new ArrayList<ForumVO>();
			postList = dao.getForumsList();

			// category 별 리스트 filter
			postList = ForumFilter.filterByCategory(postList, category);
			
			request.setAttribute("postList", postList);
			request.setAttribute("category", category);

			RequestDispatcher view = request.getRequestDispatcher("totalForum.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("post")) {
			ForumDAO dao = new ForumDAO();
			String creator = request.getParameter("creator");
			String user_id = (String)request.getSession().getAttribute("user_id");
			ForumVO post = dao.read(creator);
			
			//isOwner() 게시글의 주인인지 확인
			request.setAttribute("isOwner", PostOwner.isOwner(post, user_id));
			request.setAttribute("post", dao.read(creator));
			
			RequestDispatcher view = request.getRequestDispatcher("post.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			ForumDAO dao = new ForumDAO();
			String creator = request.getParameter("creator");
			request.setAttribute("post", dao.read(creator));
			
			RequestDispatcher view = request.getRequestDispatcher("post_update.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("delete")) {
			ForumDAO dao = new ForumDAO();
			String creator = request.getParameter("creator");
			
			if(dao.delete(creator)) {
				request.setAttribute("category", "전체");
				request.setAttribute("isSuccess", creator+" 게시글을 삭제했습니다.");
			}
			request.setAttribute("postList", dao.getForumsList());
			request.setAttribute("category", "전체");
			
			RequestDispatcher view = request.getRequestDispatcher("totalForum.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmdReq = "";
		String message = "";

		cmdReq = request.getParameter("cmd");

		if (cmdReq.equals("add")) {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");
			Date today = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String upload_date = dateFormat.format(today);

			ForumVO forumVO = new ForumVO();

			forumVO.setCreator(request.getParameter("creator"));
			forumVO.setCategory(request.getParameter("category"));
			forumVO.setUser_id(user_id);
			forumVO.setContent(request.getParameter("content"));
			forumVO.setUpload_date(upload_date);

			ForumDAO forumDAO = new ForumDAO();

			if (forumDAO.add(forumVO)) {
				request.setAttribute("check", 1);
				message = "게시글이 등록되었습니다.";
			} else {
				request.setAttribute("check", 0);
				message = "게시글 등록이 실패했습니다.";
			}

			request.setAttribute("isSuccess", message);
			request.setAttribute("post", forumVO);

			RequestDispatcher view = request.getRequestDispatcher("register_result.jsp");
			view.forward(request, response);
		} else if (cmdReq.equals("update")) {
			ForumVO post = new ForumVO();
			
			post.setCreator(request.getParameter("creator"));
			post.setCategory(request.getParameter("category"));
			post.setUser_id((String)request.getSession().getAttribute("user_id"));
			post.setContent(request.getParameter("content"));
			post.setUpload_date(request.getParameter("upload_date"));
			
			ForumDAO dao = new ForumDAO();
			
			if(dao.update(post)) {
				request.setAttribute("isSuccess", "수정에 성공했습니다.");
			} else {
				request.setAttribute("isSuccess", "수정에 실패했습니다.");
			}
			request.setAttribute("post", post);
			RequestDispatcher view = request.getRequestDispatcher("post.jsp");
			view.forward(request, response);
		}
	}

}
