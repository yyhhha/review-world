package review.model.dao;

import java.sql.SQLException;
import java.util.List;

import review.exception.MessageException;
import review.exception.NotExistException;
import review.model.dto.BoardDTO;

public class ReviewServiceZyan {
	private ReviewServiceZyan() {}
	
	private static ReviewServiceZyan instance = new ReviewServiceZyan();
	
	public static ReviewServiceZyan getInstance() {
		return instance;
	}
	
	private static BoardDAO boardDAO = BoardDAO.getInstance();
	private static CategoryDAO categoryDAO = CategoryDAO.getInstance();
	private static UserTypeDAO userTypeDAO = UserTypeDAO.getInstance();
	private static CommentDAO commentDAO = CommentDAO.getInstance();
	
	public boolean addBorad(String userId) throws MessageException{
		boolean result = false;
		try{
			result = boardDAO.addBoard(userId);
		}catch(SQLException s){
			throw new MessageException("");
		}
		return result;
	}
	
	
	public static List<BoardDTO> getBoardlistAll() throws SQLException,NotExistException{
		List<BoardDTO> boardlistAll = AdminDAO.getBoardlistAll();
		
		if(boardlistAll == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
		
		return boardlistAll;
		
	}
	
}
