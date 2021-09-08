package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Review")
public class ReviewFrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		if(command.equals("boardInsert")) {//모든 probono project 정보 검색
			boardInsert(request, response);
		}
	}
	
	protected void boardInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp"; 
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String major = request.getParameter("major");
		
		//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
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
}
