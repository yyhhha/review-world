package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.dao.ReviewServiceZyan;
import review.model.dto.BoardDTO;

@WebServlet("/reviewz")
public class ReviewFrontControllerZyan extends HttpServlet {
	
	private static ReviewServiceZyan reviewService = ReviewServiceZyan.getInstance();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
	try {
		if(command.equals("boardInsert")) {//모든 probono project 정보 검색
			boardInsert(request, response);
		} else if(command.equals("boardlistAll")) {
			boardlistAll(request,response);
		} else if(command.equals("boardUpdate")) {
			boardUpdate(request,response);
		} else if(command.equals("boardDelete")) {
			boardDelete(request,response);
		} else if(command.equals("boradDetail")) {
			boradDetail(request,response);
		}
			
	}catch(Exception s){
		request.setAttribute("errorMsg", s.getMessage());
		request.getRequestDispatcher("showError.jsp").forward(request, response);
		s.printStackTrace();
	}
}
	//게시글 상세보기
	public void boradDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getAttribute("userId");
		request.getAttribute("boardId");
		
		session.getParameter
	}
	
	//게시글 추가
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

	//게시글 삭제
	public void boardDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			if(reviewService.deleteBoard(request.getParameter("boardId"))) {
				url = "/admin/adminBoardlist.jsp";
			}else {
				request.setAttribute("errorMsg", "저장 실패");
			}
			boardlistAll(request, response);
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//모든 게시글 조회
	public void boardlistAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("boardlistAll", reviewService.getBoardlistAll());
			url = "/admin/adminBoardlist.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//게시글 수정 
	public void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		int boradId = request.getParameter("boardId"); 
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		try { 
			if(reviewService.updateBoard(boradId, title, content)) {
				request.setAttribute("board", reviewService.getBoard(boradId));
				url = "board/boardetail.jsp";
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}