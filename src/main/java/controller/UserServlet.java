package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.ForumVO;
import domain.UserVO;
import persistence.ForumDAO;
import persistence.UserDAO;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		HttpSession session = request.getSession();
		
		if (cmdReq.equals("signup")) {
			response.sendRedirect("signUp.html");
		} else if (cmdReq.equals("login")) {
			response.sendRedirect("login.jsp");
		}  else if (cmdReq.equals("logout")) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else if(cmdReq.equals("user_delete")) {
			//회원탈퇴
			String userId = (String)session.getAttribute("user_id");
			UserDAO dao = new UserDAO();
			dao.delete(userId);
			//로그아웃
			session.invalidate();
			request.setAttribute("check", 2);
			
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("User doPost()");
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		
		if (cmdReq.equals("login")) {
			UserVO userVO = new UserVO();

			userVO.setId(request.getParameter("id"));
			userVO.setPasswd(request.getParameter("passwd"));

			UserDAO userDAO = new UserDAO();
			
			UserVO user = userDAO.find(userVO.getId(), userVO.getPasswd());
			if(user != null) {
				//유저 정보 유지
				HttpSession session = request.getSession();
				session.setAttribute("user_id", user.getId());
				session.setAttribute("user_username", user.getUsername());
				
				//전체 list 불러오기
				ForumDAO forumDAO = new ForumDAO();
				ArrayList<ForumVO> postList = forumDAO.getForumsList();
				request.setAttribute("postList", postList);
				
				//전체 게시판 불러오기
				request.setAttribute("category", "total");
				
				// 로그인 성공시
				RequestDispatcher view = request.getRequestDispatcher("totalForum.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("check", 1);
				// 로그인 실패시
				RequestDispatcher view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
			}
		} else if (cmdReq.equals("signupResult")) {
			UserVO userVO = new UserVO();

			userVO.setId(request.getParameter("id"));
			userVO.setPasswd(request.getParameter("passwd"));
			userVO.setUsername(request.getParameter("username"));
			
			UserDAO userDAO = new UserDAO();

			if (userDAO.add(userVO)) {
				request.setAttribute("check", 1);
				request.setAttribute("user", userVO);
			} else {
//				System.out.println(userDAO.add(userVO));
				request.setAttribute("check", 0);
			}

			RequestDispatcher view = request.getRequestDispatcher("signUp_result.jsp");
			view.forward(request, response);
		}
	}

}
