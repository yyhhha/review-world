﻿package review.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("oracleDBUse");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();		
	}
}


















//package review.model.util;
//
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Properties;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class DBUtil {
//private static EntityManagerFactory emf;
//	
//	static {
//		emf = Persistence.createEntityManagerFactory("oracleDBUse");
//	}
//	
//	public static EntityManager getEntityManager() {
//		return emf.createEntityManager();
//	}
//	
//	public static void close() {
//		emf.close();		
//	}
//
//	
//	private static Properties dbinfo = new Properties();
//	private static Properties sql = new Properties();
//	
//	
//	static {
//		try {
//			dbinfo.load(new FileInputStream("db.properties"));
//			sql.load(new FileInputStream("buildingsql.properties"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Properties getSql() {
//		return sql;
//	}
//
//
//	//connection ��ü �ʿ�� ���� ȣ��Ǵ� �޼ҵ�
//	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url"),dbinfo.getProperty("jdbc.id"),dbinfo.getProperty("jdbc.pw"));
//		
//	}
//
//	public static void close(Connection con, Statement stmt) {
//		try {
//			if (stmt != null) {
//				stmt.close();
//				stmt = null;
//			}
//			if (con != null) {
//				con.close();
//				con = null;
//			}
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//	}
//
//	public static void close(Connection con, Statement stmt, ResultSet rset) {
//		try {
//			if (rset != null) {
//				rset.close();
//				rset = null;
//			}
//			if (stmt != null) {
//				stmt.close();
//				stmt = null;
//			}
//			if (con != null) {
//				con.close();
//				con = null;
//			}
//		} catch (SQLException s) {
//			s.printStackTrace();
//		}
//	}
//}