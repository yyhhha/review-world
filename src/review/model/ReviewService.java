package review.model;


public class ReviewService {

	private static ReviewService instance = new ReviewService();

	private ReviewService() {
	}

	public static ReviewService getInstance() {
		return instance;
	}
	
	private static UserDAO userDAO = UserDAO.getInstance();
	private static BoardDAO boardDAO = BoardDAO.getInstance();
	private static CategoryDAO categoryDAO = CategoryDAO.getInstance();
	private static UserTypeDAO userTypeDAO = UserTypeDAO.getInstance();
	private static CommentDAO commentDAO = CommentDAO.getInstance();
	
	
}
