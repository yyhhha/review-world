package review.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import review.model.dao.ReviewService;
import review.model.dao.ReviewServiceYh;
import review.model.dto.UserDTO;

@WebServlet("/review")
public class ReviewFrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");

		try {
			if (command.equals("boardInsert")) {
				boardInsert(request, response);
			} else if (command.equals("boardlistAllAdmin")) {
				boardlistAllAdmin(request, response);
			} else if (command.equals("boardlistAllUser")) {
				boardlistAllUser(request, response);
			} else if (command.equals("memberlistAllAdmin")) { // ★몰래 넣어둠..멤버 list 테스트중..
				memberlistAll(request, response);
			} else if (command.equals("userLogin")) {
				userLogin(request, response);
			} else if (command.equals("commentlistAllAdmin")) {// ★댓글 목록 list
				commentlistAll(request, response);
			} else if (command.equals("삭제")) {// 게시글 일괄 삭제
				deleteBoardAll(request, response);

			} else {

			}

		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	protected void boardInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String major = request.getParameter("major");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
//		if(id != null && id.length() !=0 && name != null) {
//		
//			ActivistDTO activist = new ActivistDTO(id, name, pw, major);
//			try{
//				boolean result = probonoService.addActivist(activist);
//				if(result){
//					request.setAttribute("activist", activist);
//					request.setAttribute("successMsg", "가입 완료");
//					url = "activist/activistDetail.jsp";
//				}else{
//					request.setAttribute("errorMsg", "다시 시도하세요");
//				}
//			}catch(Exception s){
//				request.setAttribute("errorMsg", s.getMessage());
//			}
//			request.getRequestDispatcher(url).forward(request, response);
//		}
	}

	// 모든 게시글 조회 리스트
	public void boardlistAllAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("boardlistAllAdmin", ReviewService.getBoardlistAll());
			url = "/admin/adminBoardlist.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//유저 모든 게시글 조회
	public void boardlistAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("boardlistAllUser", ReviewService.getBoardlistAll());
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println(request.getAttribute("boardlistAllUser"));
			url = "/user/userboardlist.jsp";
		}catch(Exception s){
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
			request.setAttribute("commentlistAllAdmin", ReviewService.getCommentlistAll());
			url = "/admin/adminCommentlist.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 특정 게시글 일괄 삭제
	private void deleteBoardAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		String[] boardIds = request.getParameterValues("del-id");

//		System.out.println(request.getParameterValues("del-id"));
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		for (int i = 0; i < boardIds.length; i++) {
			System.out.println(boardIds[i]);
		}
		try {
			boolean result = ReviewService.deleteBoardAll(boardIds);
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


	// 유저 가입 메소드
	protected void userInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "showError.jsp";

		String id = request.getParameter("uid");
		String nickName = request.getParameter("nickname");
		String pw = request.getParameter("psw");
		String email = request.getParameter("email");

		// 해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		if (id != null && id.length() != 0 && nickName != null) {

//					private String userId;
//					private String userPw;
//					private String nickName;
//					private RUserType userType;
//					private String userEmail;

			UserDTO user = new UserDTO(id, pw, nickName, null, email);
////					try{
////						boolean result = probonoService.addActivist(activist);
////						if(result){
////							request.setAttribute("activist", activist);
////							request.setAttribute("successMsg", "가입 완료");
////							url = "activist/activistDetail.jsp";
////						}else{
////							request.setAttribute("errorMsg", "다시 시도하세요");
////						}
////					}catch(Exception s){
//						request.setAttribute("errorMsg", s.getMessage());
//					}
//					request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = "showErrorR.jsp";
		UserDTO a;
		try {
			a = ReviewService.getUserForLogin(request.getParameter("uname"), request.getParameter("psw"));
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
					url = "user/userboardlist.jsp";
				} else {
					System.out.println("typeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
					url = "showError.jsp";
				}
			} else {
				session.setAttribute("errorMsg", "존재하지 않는 유저입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
//		System.out.println(url);
//		response.sendRedirect(url);
		}finally {
		System.out.println(url);
		response.sendRedirect(url);

		}
	}
}
