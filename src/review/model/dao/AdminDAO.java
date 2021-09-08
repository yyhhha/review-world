package review.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import review.model.dto.BoardDTO;
import review.model.dto.UserDTO;
import review.model.entity.RBoard;
import review.model.entity.RCategory;
import review.model.entity.RUser;
import review.model.util.DBUtil;

public class AdminDAO {

	// 모든 프로보노 프로젝트 검색
	@SuppressWarnings("unchecked")
	public static List<BoardDTO> getBoardlistAll() throws SQLException {
		EntityManager manager = DBUtil.getEntityManager();
		List<RBoard> list = null;
		List<BoardDTO> resultList = new ArrayList<>();
		try {
			list = manager.createQuery("SELECT r FROM RBoard r").getResultList();
			RCategory category = null;
			RUser user = null;

			for (RBoard board : list) {
				category = board.getCategory();
				user = board.getUserId();

				resultList.add(new BoardDTO(board.getBoardId(), board.getTitle(), board.getContent(),
						board.getBoardDate(), board.getViews(), board.getLikes(), category.getCategoryName(),
						user.getNickName(), board.getUserId().getUserId(),board.getCategory().getCategoryId()));
			}

		} catch (Exception e) {
		} finally {
//			manager.close();
		}
		return resultList;
	}

	//모든 회원 목록 
	@SuppressWarnings("unchecked")
	public static List<UserDTO> getMemberlistAll() throws SQLException{
		EntityManager manager = DBUtil.getEntityManager();
		List<RUser> list = null;
		List<UserDTO> memberList = new ArrayList<>();
		try {
			list = manager.createQuery("SELECT r FROM RUser r").getResultList();

			for (RUser user : list) {
				memberList.add(new UserDTO(user.getUserId(), user.getUserPw(),user.getNickName(), user.getUserType().getUserType(),
						user.getUserEmail()));
			}

		} catch (Exception e) {
		} finally {
//			manager.close();
		}
		return memberList;
	}
	
	
	//글id로 해당 글에 대한 모든 값 반환
		public static BoardDTO getBoard(String boardId) throws SQLException {
			EntityManager em = DBUtil.getEntityManager();
			em.getTransaction().begin();
			BoardDTO board = null;

			try {
				RBoard b = em.find(RBoard.class, boardId);
				board = new BoardDTO(b.getBoardId(),b.getTitle(),b.getContent(),b.getBoardDate(),b.getViews(),b.getLikes(),b.getCategory().getCategoryName(),b.getUserId().getNickName(),b.getUserId().getUserId(),b.getCategory().getCategoryId());
			} catch (Exception e) {
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
			return board;
		}

		public static boolean updateCategory(String boardId, String categoryId) {
			EntityManager em = DBUtil.getEntityManager();
			em.getTransaction().begin();
			boolean result = false;

			try {
				em.find(RBoard.class, boardId).getCategory().setCategoryId(categoryId);
				em.getTransaction().commit();

				result = true;
			} catch (Exception e) {
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
			return result;
		}
}
