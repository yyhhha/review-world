import javax.persistence.EntityManager;

import review.model.entity.RBoard;
import review.model.entity.RUser;
import review.model.util.DBUtil;

public class test {
	
	


	public static void main(String[] args) {
//		EntityManager manager = DBUtil.getEntityManager();
//		ArrayList<RBoard> alist = new ArrayList<>();
//		List list = null;
//		list = manager.createNativeQuery("SELECT * FROM RBoard").getResultList();
//		Iterator it = list.iterator();
//		while (it.hasNext()) {
//			Object[] obj = (Object[]) it.next();
//			alist.add(new BoardDTO(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]),
//					String.valueOf(obj[2]),String.valueOf(obj[3]),Integer.parseInt(String.valueOf(obj[4])),  Integer.parseInt(String.valueOf(obj[5])),
//					 String.valueOf(obj[6]), String.valueOf(obj[7])));
//		}
//		
//		EntityManager manager = DBUtil.getEntityManager();
//		List<ProbonoProjectDTO> alist = new ArrayList<>();
//		try {
//			alist = manager.createQuery("SELECT d FROM PROBONO_PROJECT d").getResultList();
//		
//		} finally {
//			manager.close();
//		}
//		return alist;
//	}
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		
		RUser user = em.find(RUser.class, "dkdk");
		System.out.println(user);
//		RBoard board = new RBoard();
//		board.setTitle("제목");
//		board.setContent("안녕");
//		board.setUserId(user);
//		
//		em.persist(board);
//		em.getTransaction().commit();

//		
//		RBoard board1 = em.find(RBoard.class, 4);
//		System.out.println(board1);
		
//		RUser user = em.find(RUser.class, "dkdk");
//		System.out.println(user);
//		
//		RUserType type = em.find(RUserType.class, "normal");
//		System.out.println(type);
//		
//		RCategory cate = em.find(RCategory.class, "c1");
//		System.out.println(cate);
//		
//		RComment com = em.find(RComment.class, 4);
//		System.out.println(com);
		
	}
		
		

}
