package review.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import review.model.dto.BoardDTO;
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
						user.getNickName(), user.getUserId()));
			}

		} catch (Exception e) {
		} finally {
//			manager.close();
		}
		return resultList;
	}

}
