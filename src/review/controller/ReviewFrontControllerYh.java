package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.dao.ReviewService;
import review.model.dto.UserDTO;

@WebServlet("/review")
public class ReviewFrontControllerYh extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
	try {
		if(command.equals("boardInsert")) {//모든 probono project 정보 검색
			boardInsert(request, response);
		}else if(command.equals("boardlistAll")) {
			boardlistAll(request,response);
		}else {
			
		}
			
	}catch(Exception s){
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

	//모든 게시글 조회 리스트
		public void boardlistAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				request.setAttribute("boardlistAll", ReviewService.getBoardlistAll());
				url = "/admin/adminBoardlist.jsp";
			}catch(Exception s){
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
	
}
