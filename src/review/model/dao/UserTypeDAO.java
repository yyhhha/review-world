package review.model.dao;
public class UserTypeDAO {
	private static UserTypeDAO instance = new UserTypeDAO();

	private UserTypeDAO() {}

	public static UserTypeDAO getInstance() {
		return instance;
	}
}