package review.model.dao;

import java.sql.SQLException;
import java.util.List;

import review.exception.MessageException;
import review.exception.NotExistException;
import review.model.dto.BoardDTO;
import review.model.dto.CommentDTO;
import review.model.dto.UserDTO;

public class ReviewService {
	private ReviewService() {}
	
	private static ReviewService instance = new ReviewService();
	
	public static ReviewService getInstance() {
		return instance;
	}
	
	private static BoardDAO boardDAO = BoardDAO.getInstance();
	private static UserDAO userDAO = UserDAO.getInstance();
	private static AdminDAO adminDAO = AdminDAO.getInstance();
	
	public static List<UserDTO> getMemberlistAll() throws SQLException,NotExistException{
		List<UserDTO> memberlistAll = adminDAO.getMemberlistAll();
		
		if(memberlistAll == null){
			throw new NotExistException("조회한 회원 목록 값이 존재하지 않아요.");
		}
		
		return memberlistAll;
	}
	
	//모든 댓글 조회
	public static List<CommentDTO> getCommentlistAll() throws SQLException,NotExistException{
		List<CommentDTO> commentlistAll = adminDAO.getCommentlistAll();
		
		if(commentlistAll == null){
			throw new NotExistException("조회한 댓글 목록 값이 존재하지 않아요.");
		}
		
		return commentlistAll;
	}
	
	
	//삭제 메소드 배열.. deleteBoardAll
	public boolean deleteBoardAll(String[] boardIds) {
		return adminDAO.deleteBoardAll(boardIds);
	} 
	
	//boardId로 검색하는 메소드
	public BoardDTO getBoard(int boardId) throws SQLException, NotExistException{
		BoardDTO board = adminDAO.getBoard(boardId);
		if(board == null){
			throw new NotExistException("검색했는데, 관련 게시글이 존재하지않아요.");
		}
		return board;
	}
	
	//게시글 카테고리 수정하는 메소드
	public boolean updateCategory(String boardId, String categoryId) throws SQLException, NotExistException{		
//		notExistActivist(boardId);
		boolean result = adminDAO.updateCategory(boardId, categoryId);
		if(!result){
			throw new NotExistException("카테고리 변경이 어렵네요.");
		}
		return result;
	}
	
	public boolean addUser(UserDTO user) throws MessageException {
		boolean result = false;
		try{
			result = userDAO.addUser(user);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}

	public UserDTO getUser(String email) throws NotExistException {
		UserDTO activist = userDAO.getUser(email);
		if(activist == null){
			throw new NotExistException("검색하는 유저가 없습니다.");
		}
		return activist;
	}

	public UserDTO getUserForLogin(String id, String pw) throws NotExistException {
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

	public boolean deleteUser(String id, String pw) throws MessageException {
		boolean result = false;
		try{
			result = userDAO.deleteUser(id,pw);
		}catch(Exception s){
			throw new MessageException("존재하는 않는 ID입니다 다시 시도 하세요");
		}
		return result;
	}
	
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
		public boolean deleteBoard(int BoardId) throws SQLException, NotExistException{
			System.out.println("service test");
			return boardDAO.deleteBoard(BoardId);
		}
		
		//**게시물 전체 보기
		public  List<BoardDTO> getBoardlistAll() throws SQLException,NotExistException{
			List<BoardDTO> boardlistAll = adminDAO.getBoardlistAll();
			
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
