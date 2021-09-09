package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import review.model.dao.ReviewServiceYh;
import review.model.dto.UserDTO;

@WebServlet("/reviewy")
public class ReviewFrontControllerYh extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");

		try {
			if (command.equals("boardInsert")) {// 모든 probono project 정보 검색
//				boardInsert(request, response);
			} else if (command.equals("boardlistAll")) {
//				boardlistAll(request, response);
			} else if (command.equals("userInsert")) {
				userInsert(request, response);
			} else if (command.equals("FindByEmail")) {
				FindByEmail(request, response);
			} else if (command.equals("userLogin")) {
				userLogin(request, response);
			} else if (command.equals("deleteUser")) {
				deleteUser(request, response);
			} else {

			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			// showErrorYh 수정
			request.getRequestDispatcher("showErrorYH.jsp").forward(request, response);
//			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showErrorYH.jsp";

		String id = request.getParameter("uid");
		String pw = request.getParameter("psw");

		if (id != null && id.length() != 0 && pw != null) {
			try {
				boolean result = ReviewServiceYh.deleteUser(id, pw);
				if (result) {
					request.setAttribute("successMsg", "삭제 완료");
					url = "login.jsp";

				} else {
					request.setAttribute("errorMsg", "삭제 실패");

				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	// 유저 가입 메소드
	protected void userInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showErrorYH.jsp";
//		String url = "showError.jsp";

		String id = request.getParameter("uid");
		String nickName = request.getParameter("nickname");
		String pw = request.getParameter("psw");
		String email = request.getParameter("email");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		if (id != null && id.length() != 0 && nickName != null) {
			UserDTO user = new UserDTO(id, pw, nickName, null, email);
			HttpSession session = request.getSession();
			try {
				boolean result = ReviewServiceYh.addUser(user);
				if (result) {
//							request.setAttribute("user", user);
//							request.setAttribute("successMsg", "가입 완료");
					url = "user/userDetail.jsp";

					session.setAttribute("id", id);
					session.setAttribute("nickName", nickName);
					session.setAttribute("pw", pw);
					session.setAttribute("email", email);
					session.setAttribute("successMsg", "가입 완료");
				} else {
//							request.setAttribute("errorMsg", "다시 시도하세요");
					session.setAttribute("errorMsg", "다시 시도하세요");

				}
			} catch (Exception s) {
//				request.setAttribute("errorMsg", s.getMessage());
				session.setAttribute("errorMsg", s.getMessage());
			}
//					request.getRequestDispatcher(url).forward(request, response);
			response.sendRedirect(url);
		}
	}

	private void FindByEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showErrorYH.jsp";
//		String url = "showError.jsp";

		String email = request.getParameter("USER_EMAIL");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		if (email != null && email.length() != 0) {
			HttpSession session = request.getSession();
			try {
				UserDTO user = ReviewServiceYh.getUser(email);
				if (user != null) {
					url = "user/userDetail.jsp";

					String id = user.getUserId();
					String nickName = user.getNickName();
					String pw = user.getUserPw();

					session.setAttribute("id", id);
					session.setAttribute("nickName", nickName);
					session.setAttribute("pw", pw);
					session.setAttribute("email", email);
					session.setAttribute("successMsg", "회원 정보");
				} else {
//							request.setAttribute("errorMsg", "다시 시도하세요");
					session.setAttribute("errorMsg", "다시 시도하세요");

				}
			} catch (Exception s) {
//				request.setAttribute("errorMsg", s.getMessage());
				session.setAttribute("errorMsg", s.getMessage());
			}
//					request.getRequestDispatcher(url).forward(request, response);
			response.sendRedirect(url);

		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = "showErrorR.jsp";
		UserDTO a;
		try {
			a = ReviewServiceYh.getUserForLogin(request.getParameter("uname"), request.getParameter("psw"));
			HttpSession session = request.getSession();

			if (a != null) {
				session.setAttribute("user", a);
				if (a.getUserType().equals("관리자")) {
					// admin 페이지
					System.out.println("관리자ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
					url = "adminMain.html";
				} else if (a.getUserType().equals("일반")) {
					// 일반회원 페이지
					System.out.println("일반 사용자 ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
					url = "adminMain.html";
				} else {
					System.out.println("typeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
					url = "showError.jsp";
				}
			} else {
				session.setAttribute("errorMsg", "존재하지 않는 유저입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
}
