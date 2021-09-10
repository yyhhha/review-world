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
	
	
	private AdminDAO() {}
	
	private static AdminDAO instance = new AdminDAO();
	
	public static AdminDAO getInstance() {
		return instance;
	}
	

	public List<BoardDTO> getBoardlistAll() throws SQLException {
		EntityManager manager = DBUtil.getEntityManager();
		List<RBoard> list = null;
		List<BoardDTO> resultList = new ArrayList<>();
		
		try {

			list = manager.createNativeQuery("SELECT * FROM R_Board", RBoard.class).getResultList();
			RUser user = null;
			RCategory category = null;

			for (RBoard board : list) {
				user = board.getUserId();
				category = board.getCategory();

				if (user == null) {
					resultList.add(new BoardDTO(board.getBoardId(), board.getTitle(), board.getContent(),
							board.getBoardDate(), board.getViews(), board.getLikes(), category.getCategoryName(), "익명",
							"익명", board.getCategory().getCategoryId()));
				} else {
					resultList.add(new BoardDTO(board.getBoardId(), board.getTitle(), board.getContent(),
							board.getBoardDate(), board.getViews(), board.getLikes(), category.getCategoryName(),
							user.getNickName(), board.getUserId().getUserId(), board.getCategory().getCategoryId()));
				}
			}
			System.out.println(resultList.size());
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			manager.close();
			manager = null;
		}
		return resultList;
	}
	
	// 모든 회원 목록
	@SuppressWarnings("unchecked")
	public List<UserDTO> getMemberlistAll() throws SQLException {
		EntityManager manager = DBUtil.getEntityManager();
		List<RUser> list = null;
		List<UserDTO> memberList = new ArrayList<>();
		try {
			list = manager.createQuery("SELECT r FROM RUser r").getResultList();

			for (RUser user : list) {
				memberList.add(new UserDTO(user.getUserId(), user.getUserPw(), user.getNickName(),
						user.getUserType().getUserType(), user.getUserEmail()));
			}

		} catch (Exception e) {
		} finally {
//			manager.close();
		}
		return memberList;
	}

	// 글id로 해당 글에 대한 모든 값 반환
	public BoardDTO getBoard(int boardId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		BoardDTO board = null;

		try {
			RBoard b = em.find(RBoard.class, boardId);
			board = new BoardDTO(b.getBoardId(), b.getTitle(), b.getContent(), b.getBoardDate(), b.getViews(),
					b.getLikes(), b.getCategory().getCategoryName(), b.getUserId().getNickName(),
					b.getUserId().getUserId(), b.getCategory().getCategoryId());
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return board;
	}

	public boolean updateCategory(String boardId, String categoryId) {
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
	
	
	public boolean deleteBoardAll(String[] boardIds) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		try {
			String temp = "";
			for (int i = 0; i < boardIds.length; i++) {
				if (i == boardIds.length - 1) {
					temp += boardIds[i];
				} else {
					temp += boardIds[i] + ",";
				}
			}
			System.out.println(temp);
			em.createNativeQuery("DELETE FROM R_BOARD WHERE BOARD_ID in (" + temp + ")", RBoard.class).executeUpdate();
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
		}

		return result;
	}

	public boolean deleteMemberAll(String[] memberIds) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		try {
			String temp = "";
			for (int i = 0; i < memberIds.length; i++) {
				if (i == memberIds.length - 1) {
					temp += "'"+memberIds[i]+ "'";
				} else {
					temp += "'"+memberIds[i] + " ',";
				}
			}
			System.out.println(temp);
			em.createNativeQuery("DELETE FROM R_USER WHERE USER_ID in (" + temp + ")", RBoard.class).executeUpdate();
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
			em = null;
		}

		return result;
	}
}
