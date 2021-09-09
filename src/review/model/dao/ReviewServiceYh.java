package review.model.dao;

import java.sql.SQLException;
import java.util.List;

import review.exception.MessageException;
import review.exception.NotExistException;
import review.model.dto.BoardDTO;
import review.model.dto.UserDTO;

	public class ReviewServiceYh {
	
	private static ReviewServiceYh instance = new ReviewServiceYh();
	
	public static ReviewServiceYh getInstance() {
		return instance;
	}
	
	private static BoardDAO boardDAO = BoardDAO.getInstance();
	private static CategoryDAO categoryDAO = CategoryDAO.getInstance();
	private static UserTypeDAO userTypeDAO = UserTypeDAO.getInstance();
	private static CommentDAO commentDAO = CommentDAO.getInstance();
	private static UserDAO userDAO = UserDAO.getInstance();
	
	
//	public boolean addBorad(String userId) throws MessageException{
//		boolean result = false;
//		try{
//			result = boardDAO.addBoard(userId);
//		}catch(SQLException s){
//			throw new MessageException("");
//		}
//		return result;
//	}
//	
	
	public static List<BoardDTO> getBoardlistAll() throws SQLException,NotExistException{
		List<BoardDTO> boardlistAll = AdminDAO.getBoardlistAll();
		
		if(boardlistAll == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
		
		return boardlistAll;
		
	}


	public static boolean addUser(UserDTO user) throws MessageException {
		boolean result = false;
		try{
			result = UserDAO.addUser(user);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}


	public static UserDTO getUser(String email) throws NotExistException {
		UserDTO activist = userDAO.getUser(email);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
		return activist;
	}


	public static UserDTO getUserForLogin(String id, String pw) throws NotExistException {
		UserDTO user = null;
		try {
			user = userDAO.getUserForLogin(id,pw);
			if(user == null){
				throw new NotExistException("ID를 확인해주세요.");
			}
		}catch (Exception e) {
			throw new NotExistException("PW를 확인해주세요.");
		}
		return user;
	}
	
}
