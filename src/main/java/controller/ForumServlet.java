package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

/**
 * Servlet implementation class ForumServlet
 */
@WebServlet("/ForumServlet")
public class ForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Forum doGet()");
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		if (cmdReq.equals("add")) {
			response.sendRedirect("register.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Forum doPost()");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String cmdReq = "";
		String message = "";

		cmdReq = request.getParameter("cmd");

		if (cmdReq.equals("join")) {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");
			System.out.println(user_id);
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

			request.setAttribute("greetings", message);
			request.setAttribute("post", forumVO);

			RequestDispatcher view = request.getRequestDispatcher("register_result.jsp");
			view.forward(request, response);
		}
	}

}
