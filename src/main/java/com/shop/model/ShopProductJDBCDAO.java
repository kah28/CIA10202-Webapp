package com.shop.model;

import java.util.*;
import java.sql.*;

public class ShopProductJDBCDAO implements ShopProductDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia102g2db?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "03180318";

	private static final String INSERT_STMT = 
			"INSERT INTO shop_product (prod_type_no, prod_name, prod_info, prod_price, prod_status, prod_date) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT prod_no, prod_type_no, prod_name, prod_info, prod_price, prod_status, prod_date FROM shop_product order by prod_no";
	private static final String GET_ONE_STMT = 
			"SELECT prod_no, prod_type_no, prod_name, prod_info, prod_price, prod_status, prod_date FROM shop_product where prod_no = ?";
	private static final String DELETE = 
			"DELETE FROM shop_product where prod_no = ?";
	private static final String UPDATE = 
			"UPDATE shop_product set prod_type_no=?, prod_name=?, prod_info=?, prod_price=?, prod_status=?, prod_date=? where prod_no = ?";

	@Override
	public void insert(ShopProductVO shopProductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
	
			pstmt.setInt(1, shopProductVO.getProdTypeNo());
			pstmt.setString(2, shopProductVO.getProdName());
			pstmt.setString(3, shopProductVO.getProdInfo());
			pstmt.setInt(4, shopProductVO.getProdPrice());
			pstmt.setInt(5, shopProductVO.getProdStatus());
			pstmt.setTimestamp(6, shopProductVO.getProdDate());
			
			System.out.println(pstmt);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}

	}

	@Override
	public void update(ShopProductVO shopProductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, shopProductVO.getProdTypeNo());
			pstmt.setString(2, shopProductVO.getProdName());
			pstmt.setString(3, shopProductVO.getProdInfo());
			pstmt.setInt(4, shopProductVO.getProdPrice());
			pstmt.setInt(5, shopProductVO.getProdStatus());
			pstmt.setTimestamp(6, shopProductVO.getProdDate());
			pstmt.setInt(7, shopProductVO.getProdNo());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}

	}

	@Override
	public void delete(Integer prodNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prodNo);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}

	}

	@Override
	public ShopProductVO findByPrimaryKey(Integer prodNo) {

		ShopProductVO shopProductVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, prodNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				shopProductVO = new ShopProductVO();
				
				shopProductVO.setProdNo(rs.getInt("prod_no"));
				shopProductVO.setProdTypeNo(rs.getInt("prod_type_no"));
				shopProductVO.setProdName(rs.getString("prod_name"));
				shopProductVO.setProdInfo(rs.getString("prod_info"));
				shopProductVO.setProdPrice(rs.getInt("prod_price"));
				shopProductVO.setProdStatus(rs.getInt("prod_status"));
				shopProductVO.setProdDate(rs.getTimestamp("prod_date"));
				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}

		}
		return shopProductVO;
	}

	@Override
	public List<ShopProductVO> getAll() {
		List<ShopProductVO> list = new ArrayList<ShopProductVO>();
		ShopProductVO shopProductVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				shopProductVO = new ShopProductVO();
				shopProductVO.setProdNo(rs.getInt("prod_no"));
				shopProductVO.setProdTypeNo(rs.getInt("prod_type_no"));
				shopProductVO.setProdName(rs.getString("prod_name"));
				shopProductVO.setProdInfo(rs.getString("prod_info"));
				shopProductVO.setProdPrice(rs.getInt("prod_price"));
				shopProductVO.setProdStatus(rs.getInt("prod_status"));
				shopProductVO.setProdDate(rs.getTimestamp("prod_date"));
				
				list.add(shopProductVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public List<ShopProductVO> getALL(Map<String, String[]> map) {
		// ?暫不使用
		return null;
	}

	
	public static void main(String[] args) {

		ShopProductJDBCDAO dao = new ShopProductJDBCDAO();

		// 新增
		ShopProductVO shopProductVO1 = new ShopProductVO();

		shopProductVO1.setProdTypeNo(2);
		shopProductVO1.setProdName("TIMP HIKER GTX 廷帕 中筒防水戶外鞋 男款 黑色");
		shopProductVO1.setProdInfo("TIMP 系列全新改革並同步推出健行戶外款式，採用全球公認濕地抓地力表現最佳的Vibram MegaGrip鞋底，能夠有效面對乾、濕不同的地形等多元使用情境。");
		shopProductVO1.setProdPrice(6100);
		shopProductVO1.setProdStatus(1);
		shopProductVO1.setProdDate(java.sql.Timestamp.valueOf("2024-04-29 00:00:00"));
		dao.insert(shopProductVO1);

		// 修改
		ShopProductVO shopProductVO2 = new ShopProductVO();
		
		
		shopProductVO2.setProdTypeNo(3);
		shopProductVO2.setProdName("TIMP HIKER 低筒防水戶外鞋 女款 灰色");
		shopProductVO2.setProdInfo("TIMP 系列全新改革並同步推出健行戶外款式，採用全球公認濕地抓地力表現最佳的Vibram MegaGrip鞋底，能夠有效面對乾、濕不同的地形等多元使用情境。");
		shopProductVO2.setProdPrice(5800);
		shopProductVO2.setProdStatus(1);
		shopProductVO2.setProdDate(java.sql.Timestamp.valueOf("2024-06-12 00:00:00"));
		shopProductVO2.setProdNo(1);
		
		dao.update(shopProductVO2);

		// 刪除
		dao.delete(3);

		// 查詢
		ShopProductVO shopProductVO3 = dao.findByPrimaryKey(4);
		System.out.print(shopProductVO3.getProdNo() + ",");
		System.out.print(shopProductVO3.getProdTypeNo() + ",");
		System.out.print(shopProductVO3.getProdName() + ",");
		System.out.print(shopProductVO3.getProdInfo() + ",");
		System.out.print(shopProductVO3.getProdPrice() + ",");
		System.out.print(shopProductVO3.getProdStatus() + ",");
		System.out.print(shopProductVO3.getProdDate());
		
		System.out.println("---------------------");
		

		// 查詢
		List<ShopProductVO> list = dao.getAll();
		for (ShopProductVO aShopProduct : list) {
			System.out.print(aShopProduct.getProdNo() + ",");
			System.out.print(aShopProduct.getProdTypeNo() + ",");
			System.out.print(aShopProduct.getProdName() + ",");
			System.out.print(aShopProduct.getProdInfo() + ",");
			System.out.print(aShopProduct.getProdPrice() + ",");
			System.out.print(aShopProduct.getProdStatus() + ",");
			System.out.print(aShopProduct.getProdDate());
			System.out.println();
			
		}
	}
}
