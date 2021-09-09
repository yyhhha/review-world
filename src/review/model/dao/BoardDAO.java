package review.model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

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
		System.out.println("board"+board);
		System.out.println("DAOtest1");
		try {
			System.out.println("DAOtest2");
			RBoard rBoard = new RBoard();
			rBoard.setUserId(em.find(RUser.class, board.getUserId()));
			System.out.println("DAOtest3");
			rBoard.setCategory(em.find(RCategory.class, board.getCategoryName()));
			System.out.println("DAOtest4");
			rBoard.setContent(board.getContent());
			rBoard.setTitle(board.getTitle());
			
			System.out.println("rBoard"+rBoard.getBoardId()+rBoard.getUserId());
			em.persist(rBoard);
			System.out.println("persist");
			em.getTransaction().commit();
			System.out.println("commit");
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	//게시물 삭제
	public boolean deleteBoard(int boardId) {
		System.out.println("boardid"+boardId);
		System.out.println("DAO test");
		EntityManager em =DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		System.out.println("DAO test2");
		
		try {
			System.out.println("DAO try test");
			RBoard board = em.find(RBoard.class, boardId);
			System.out.println("test=============");
			em.remove(board);
//			em.remove(em.find(RBoard.class, boardId));
			em.getTransaction().commit();
			System.out.println("DAO try test2");
			result = true;
		} catch (Exception e) {
			System.out.println("DAO try test3");
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
		}
		
		return result;
	}	
	
	//게시글 수정
	public boolean updateBoard(String boardId, String title, String content) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;

		try {
			em.find(RBoard.class, boardId).setTitle(title);;
			em.find(RBoard.class, boardId).setContent(content);
			
			em.getTransaction().commit();

			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}
	
	//게시글 조회
	public BoardDTO getBoard(int boardId) throws SQLException{
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		BoardDTO board = null;

		try {
			RBoard rBoard = em.find(RBoard.class, boardId);
			String userId = rBoard.getCategory().getCategoryId();
			String categoryId = rBoard.getCategory().getCategoryId();
			String categoryName = rBoard.getCategory().getCategoryName();
			board = new BoardDTO();
			//boardId인 DTO를 새로 생성해서 return하기 위한 빌더 - categoryName과 nickName은 entity에 없기 때문에 못가져옴. 
			board.builder().userId(userId).title(rBoard.getTitle()).content(rBoard.getContent())
						   .boardDate(rBoard.getBoardDate()).views(rBoard.getViews()).likes(rBoard.getLikes())
						   .categoryName(categoryName).categoryId(categoryId).boardId(boardId)
						   .build();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
		return board;
	}
}