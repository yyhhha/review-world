package review.model.dao;

import java.sql.SQLException;

import review.exception.MessageException;

public class ReviewService {
	private ReviewService() {}
	
	private static ReviewService instance = new ReviewService();
	
	public static ReviewService getInstance() {
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
	
}
