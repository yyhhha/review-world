package review.model.dao;

public class CategoryDAO {
	private static CategoryDAO instance = new CategoryDAO();

	private CategoryDAO() {}

	public static CategoryDAO getInstance() {
		return instance;
	}
}
