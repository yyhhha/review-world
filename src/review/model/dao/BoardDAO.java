package review.model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import review.model.dto.BoardDTO;
import review.model.entity.RBoard;
import review.model.entity.RUser;
import review.model.util.DBUtil;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}

	//게시글 작성
	public boolean addBoard(String userId) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;
		
		RUser user = em.find(RUser.class, userId);
		
		RBoard board = new RBoard();
		board.setTitle("제목");
		board.setContent("안녕");
		board.setUserId(user);
		
		em.persist(board);
		em.getTransaction().commit();
		
		return true;
	}
	
}
//	EntityManager em = DBUtil.getEntityManager();
//	em.getTransaction().begin();
//	boolean result = false;
//
//	try {
//		em.persist(activist.toEntity());
//		em.getTransaction().commit();
//
//		result = true;
//
//	} catch (Exception e) {
//		em.getTransaction().rollback();
//	} finally {
//		em.close();
//	}
//	return result;
	
	
	


//
//public class ActivistDAO {
//
//
//
//}
//
//// 수정
//// 기부자 id로 주요 기부 내용 수정하기
//public boolean updateActivist(String activistId, String major) throws SQLException {
//	EntityManager em = DBUtil.getEntityManager();
//	em.getTransaction().begin();
//	boolean result = false;
//
//	try {
//		em.find(Activist.class, activistId).setMajor(major);
//
//		em.getTransaction().commit();
//
//		result = true;
//	} catch (Exception e) {
//		em.getTransaction().rollback();
//	} finally {
//		em.close();
//	}
//	return result;
//}
//
//// ??? 삭제
//// sql - delete from activist where activist_id=?
//public boolean deleteActivist(String activistId) throws SQLException {
//	EntityManager em = DBUtil.getEntityManager();
//	em.getTransaction().begin();
//	boolean result = false;
//
//	try {
//		em.remove(em.find(Activist.class, activistId));
//
//		em.getTransaction().commit();
//
//		result = true;
//	} catch (Exception e) {
//		em.getTransaction().rollback();
//		throw e;
//	} finally {
//		em.close();
//	}
//	return result;
//}
//
//// id로 해당 기부자의 모든 정보 반환
//public ActivistDTO getActivist(String activistId) throws SQLException {
//	EntityManager em = DBUtil.getEntityManager();
//	em.getTransaction().begin();
//	ActivistDTO activist = null;
//
//	try {
//		Activist a = em.find(Activist.class, activistId);
//		activist = new ActivistDTO(a.getId(), a.getName(), a.getPassword(), a.getMajor());
//	} catch (Exception e) {
//		em.getTransaction().rollback();
//	} finally {
//		em.close();
//	}
//	return activist;
//}
//
//// ???모든 기부자 검색해서 반환
//// sql - select * from activist
//@SuppressWarnings("unchecked")
//public ArrayList<ActivistDTO> getAllActivists() throws SQLException {
//	EntityManager em = DBUtil.getEntityManager();
//	List<Activist> list = null;
//	ArrayList<ActivistDTO> alist = new ArrayList<>();
//	try {
//		list = em.createNativeQuery("SELECT * FROM Activist").getResultList();
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			Object[] obj = (Object[]) it.next();
//			alist.add(new ActivistDTO(String.valueOf(obj[0]), String.valueOf(obj[1]), String.valueOf(obj[2]), String.valueOf(obj[3])));
//		}
//	} catch (Exception e) {
//		em.getTransaction().rollback();
//	} finally {
//		em.close();
//	}
//	return alist;
//}
//}
