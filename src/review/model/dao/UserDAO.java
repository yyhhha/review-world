package review.model.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import review.exception.NotExistException;
import review.model.dto.UserDTO;
import review.model.entity.RUser;
import review.model.util.DBUtil;

public class UserDAO {
	
	
	private static UserDAO instance = new UserDAO();

	private UserDAO() {}

	public static UserDAO getInstance() {
		return instance;
	}

	public static boolean addUser(UserDTO user) throws SQLException {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		boolean result = false;

		try {
			
			em.persist(user.toEntity());
			em.getTransaction().commit();

			result = true;

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}

	public UserDTO getUser(String email) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		UserDTO user = null;

		try {
			
			RUser a = (RUser) em.createNativeQuery("SELECT * FROM R_USER WHERE USER_EMAIL= '"+email+"'", RUser.class).getSingleResult();
			
			user = new UserDTO(a.getUserId(),a.getUserPw(),a.getNickName(),null,a.getUserEmail());
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return user;
	}

	public static UserDTO getUserForLogin(String id, String pw) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		UserDTO user = null;

		try {
			RUser a = em.find(RUser.class, id);
			user = new UserDTO(a.getUserId(),a.getUserPw(),a.getNickName(),a.getUserType().getTypeName(),a.getUserEmail());
			if(!user.getUserPw().equals(pw)) {
				user =null;
				throw new NotExistException("pw를 확인해주세요.");
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return user;
	}
	
	
}
