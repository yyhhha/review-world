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
	
	//게시글 추가
	public boolean addBorad(BoardDTO board) throws MessageException{
		boolean result = false;
		try{
			result = boardDAO.addBoard(board);
		}catch(SQLException s){
			throw new MessageException("sql error");
		}
		return result;
	}
	
	//게시물 삭제
	public boolean deleteBoard(String probonoId) throws SQLException, NotExistException{
		return boardDAO.deleteBoard(probonoId);
	}
	
	//게시물 상세보기
	public BoardDTO getBoard(int boardId) throws SQLException{
		return boardDAO.getBoard(boardId);
	}
	
	//**게시물 전체 보기
	public  List<BoardDTO> getBoardlistAll() throws SQLException,NotExistException{
		List<BoardDTO> boardlistAll = AdminDAO.getBoardlistAll();
		
		if(boardlistAll == null){
			throw new NotExistException("");
		}
		
		return boardlistAll;
	}

	//게시글 수정
	public boolean updateBoard(String boardId, String title, String content) throws SQLException,NotExistException{
		return boardDAO.updateBoard(boardId, title, content);
	}
	
}
