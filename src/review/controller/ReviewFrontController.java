package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.model.dao.ReviewService;
import review.model.dto.BoardDTO;
import review.model.dto.UserDTO;

@WebServlet("/review")
public class ReviewFrontController extends HttpServlet {

	private static ReviewService reviewService = ReviewService.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");

		try {
			if (command.equals("boardInsert")) {
				boardInsert(request, response);
			} else if (command.equals("boardlistAllUser")) {
				boardlistAllUser(request, response);
			} else if (command.equals("boardUpdate")) {
//				boardUpdate(request,response);
			} else if (command.equals("boardDelete")) {
				boardDelete(request, response);
			} else if (command.equals("boradDetail")) {
				boradDetail(request, response);

				// 어드민---------------------------------
			} else if (command.equals("boardlistAllAdmin")) {
				boardlistAllAdmin(request, response);
			} else if (command.equals("memberlistAllAdmin")) { // ★몰래 넣어둠..멤버 list 테스트중..
				memberlistAll(request, response);
			} else if (command.equals("userLogin")) {
				userLogin(request, response);
			} else if (command.equals("commentlistAllAdmin")) {// ★댓글 목록 list
				commentlistAll(request, response);
			} else if (command.equals("삭제")) {// 게시글 일괄 삭제
				deleteBoardAll(request, response);
			} else if (command.equals("멤버삭제")) {// 멤버삭제 일괄 삭제
				deleteMemberAll(request, response);
				// 회원가입 관련-------------------------
			} else if (command.equals("FindByEmail")) {
				FindByEmail(request, response);
			} else if (command.equals("userLogin")) {
				userLogin(request, response);
			} else if (command.equals("deleteUser")) {
				deleteUser(request, response);
			} else if (command.equals("userInsert")) {
				userInsert(request, response);
			} else {

			}

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	public void boardInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		BoardDTO board = new BoardDTO();
		board.builder().userId(request.getParameter("id"))
					   .nickname(request.getParameter("nickName"))
					   .categoryName(request.getParameter("category"))
					   .title(request.getParameter("title"))
					   .content(request.getParameter("content"))
					   .build();
		//강사님은 컨트롤러에서 빌드 미사용. 괜찮으려나?
		
		try {
			boolean result = reviewService.addBorad(board);
			if (result) {
				request.setAttribute("board", board);
				//request.setAttribute("successMsg", "게시글 작성 완료");
				url = "board/boardetail.jsp";
			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	// 모든 게시글 조회 리스트
	public void boardlistAllAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("boardlistAllAdmin", reviewService.getBoardlistAll());
			url = "/admin/adminBoardlist.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 유저 모든 게시글 조회
	public void boardlistAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("boardlistAllUser", reviewService.getBoardlistAll());
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println(request.getAttribute("boardlistAllUser"));
			url = "/user/userboardlist.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ★모든 멤버 조회 리스트
	public void memberlistAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("memberlistAllAdmin", ReviewService.getMemberlistAll());
			url = "/admin/adminMemberlist.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ★모든 댓글 조회 리스트
	public void commentlistAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("commentlistAllAdmin", reviewService.getCommentlistAll());
			url = "/admin/adminCommentlist.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//선택한 멤버 삭제
	private void deleteMemberAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		String[] memberIds = request.getParameterValues("del-mem");

		for (int i = 0; i < memberIds.length; i++) {
			System.out.println(memberIds[i]);
		}
		try {
			boolean result = reviewService.deleteMemberAll(memberIds);
			System.out.println(result);
			if (result) {
				url = "/admin/adminMemberlist.jsp";
				memberlistAll(request, response);
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// 특정 게시글 일괄 삭제
	private void deleteBoardAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		String[] boardIds = request.getParameterValues("del-id");

		try {
			boolean result = reviewService.deleteBoardAll(boardIds);
			System.out.println(result);
			if (result) {
				url = "/admin/adminBoardlist.jsp";
				boardlistAllAdmin(request, response);
			} else {
				request.setAttribute("errorMsg", "삭제 실패");
			}

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "showErrorR.jsp";
		UserDTO a;
		try {
			a = reviewService.getUserForLogin(request.getParameter("uname"), request.getParameter("psw"));
			HttpSession session = request.getSession();

			if (a != null) {
				session.setAttribute("user", a);

				if (a.getUserType().equals("관리자")) {
					// admin 페이지
					url = "adminMain.html";
				} else if (a.getUserType().equals("일반")) {
					// 일반회원 페이지
					url = "user/userboardlist.jsp";
				} else {
					url = "showError.jsp";
				}
			} else {
				session.setAttribute("errorMsg", "존재하지 않는 유저입니다.");
				request.setAttribute("errorMsg", "존재하지 않는 유저입니다. 다시 시도하세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
		}finally {
		System.out.println(url);
		response.sendRedirect(url);
		}
	}	
		public void FindByEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showErrorYH.jsp";

			String email = request.getParameter("USER_EMAIL");

			// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
			if (email != null && email.length() != 0) {
				HttpSession session = request.getSession();
				try {
					UserDTO user = reviewService.getUser(email);
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
						session.setAttribute("errorMsg", "다시 시도하세요");

					}
				} catch (Exception s) {
					session.setAttribute("errorMsg", s.getMessage());
					request.setAttribute("errorMsg", s.getMessage());
					request.getRequestDispatcher(url).forward(request, response);
				}
				response.sendRedirect(url);

			}
		}

	

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showErrorYH.jsp";

		String id = request.getParameter("uid");
		String pw = request.getParameter("psw");

		if (id != null && id.length() != 0 && pw != null) {
			try {
				boolean result = reviewService.deleteUser(id, pw);
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
//			String url = "showError.jsp";

		String id = request.getParameter("uid");
		String nickName = request.getParameter("nickname");
		String pw = request.getParameter("psw");
		String email = request.getParameter("email");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		if (id != null && id.length() != 0 && nickName != null) {
			UserDTO user = new UserDTO(id, pw, nickName, null, email);
			HttpSession session = request.getSession();
			try {
				boolean result = reviewService.addUser(user);
				if (result) {
					url = "user/userDetail.jsp";

					session.setAttribute("id", id);
					session.setAttribute("nickName", nickName);
					session.setAttribute("pw", pw);
					session.setAttribute("email", email);
					session.setAttribute("successMsg", "가입 완료");
				} else {
					session.setAttribute("errorMsg", "Id혹은 닉네임이 중복입니다. 다시 시도해주세요");

				}
			} catch (Exception s) {
				session.setAttribute("errorMsg", s.getMessage());
			}
			response.sendRedirect(url);
		}
	}

	// 게시글 삭제
	public void boardDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if (reviewService.deleteBoard(request.getParameter("boardId"))) {
				url = "/admin/adminBoardlist.jsp";
			} else {
				request.setAttribute("errorMsg", "저장 실패");
			}
			boardlistAllUser(request, response);
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 게시글 상세보기
	public void boradDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getAttribute("userId");
			request.getAttribute("boardId");
			
//			session.getParameter
		}

}
