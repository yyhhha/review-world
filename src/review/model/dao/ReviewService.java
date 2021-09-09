package review.model.dao;

import java.sql.SQLException;
import java.util.List;

import review.exception.MessageException;
import review.exception.NotExistException;
import review.model.dto.BoardDTO;
import review.model.dto.UserDTO;

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
	
	
	public static List<BoardDTO> getBoardlistAll() throws SQLException,NotExistException{
		List<BoardDTO> boardlistAll = AdminDAO.getBoardlistAll();
		
		if(boardlistAll == null){
			throw new NotExistException("조회한 게시글 목록 값이 존재하지 않아요.");
		}
		
		return boardlistAll;
	}


	public static List<UserDTO> getMemberlistAll() throws SQLException,NotExistException{
		List<UserDTO> memberlistAll = AdminDAO.getMemberlistAll();
		
		if(memberlistAll == null){
			throw new NotExistException("조회한 회원 목록 값이 존재하지 않아요.");
		}
		
		return memberlistAll;
	}
	
	
	//boardId로 검색하는 메소드
	public static BoardDTO getBoard(String boardId) throws SQLException, NotExistException{
		BoardDTO board = AdminDAO.getBoard(boardId);
		if(board == null){
			throw new NotExistException("검색했는데, 관련 게시글이 존재하지않아요. ");
		}
		return board;
	}
	
	//게시글 카테고리 수정하는 메소드
	public static boolean updateCategory(String boardId, String categoryId) throws SQLException, NotExistException{		
//		notExistActivist(boardId);
		boolean result = AdminDAO.updateCategory(boardId, categoryId);
		if(!result){
			throw new NotExistException("카테고리 변경이 어렵네요.");
		}
		return result;
	}
	
}
