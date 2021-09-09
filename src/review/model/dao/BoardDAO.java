package review.model.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.dto.BoardDTO;
import review.model.entity.RBoard;
import review.model.entity.RCategory;
import review.model.entity.RUser;
import review.model.util.DBUtil;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}

	//게시글 작성
	public boolean addBoard(BoardDTO board) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		
		try {
			RBoard rBoard = new RBoard();
			rBoard.setUserId(em.find(RUser.class, board.getUserId()));
			rBoard.setCategory(em.find(RCategory.class, board.getCategoryName()));
			rBoard.setContent(board.getContent());
			rBoard.setTitle(board.getTitle());
			
			System.out.println(rBoard);
			em.persist(rBoard);
			em.getTransaction().commit();
			
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	//모든 게시글 조회
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
}