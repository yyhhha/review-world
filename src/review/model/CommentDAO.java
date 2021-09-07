package review.model;

public class CommentDAO {
	
	private static CommentDAO instance = new CommentDAO();

	private CommentDAO() {}

	public static CommentDAO getInstance() {
		return instance;
	}
	
}