package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import persistence.UserDAO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet()");
		String cmdReq = "";
		cmdReq = request.getParameter("cmd");
		if (cmdReq.equals("signup")) {
			response.sendRedirect("signUp.html");
		} else if (cmdReq.equals("login") || cmdReq.equals("logout")) {
			request.setAttribute("check", 0);
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
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
				request.getSession().setAttribute("user_id", user.getId());
				request.getSession().setAttribute("user_username", user.getUsername());
				
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