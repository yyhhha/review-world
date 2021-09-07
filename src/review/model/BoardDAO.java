package review.model;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {}

	public static BoardDAO getInstance() {
		return instance;
	}
}
