package com.shop.model;

import java.util.*;
import java.sql.*;

public class ShopProductPicJDBCDAO implements ShopProductPicDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia102g2db?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "03180318";

	private static final String INSERT_STMT = 
			"INSERT INTO shop_product_pic (prod_no,prod_pic) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT prod_pic_no,prod_no,prod_pic FROM shop_product_pic order by prod_pic_no";
	private static final String GET_ONE_STMT = 
			"SELECT prod_pic_no,prod_no,prod_pic FROM shop_product_pic where prod_no = ?";
	private static final String DELETE = 
			"DELETE FROM shop_product_pic where prod_pic_no = ?";
	private static final String UPDATE = 
			"UPDATE shop_product_pic set prod_no=?, prod_pic=? where prod_pic_no = ?";

	@Override
	public void insert(ShopProductPicVO shopProductPicVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, shopProductPicVO.getProdNo());
			pstmt.setBytes(2, shopProductPicVO.getProdPic());

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
	public void update(ShopProductPicVO shopProductPicVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, shopProductPicVO.getProdNo());
			pstmt.setBytes(2, shopProductPicVO.getProdPic());
			pstmt.setInt(3, shopProductPicVO.getProdPicNo());

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
	public void delete(Integer prodPicNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prodPicNo);

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
	public ShopProductPicVO findByPrimaryKey(Integer prodPicNo) {

		ShopProductPicVO shopProductPicVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, prodPicNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				shopProductPicVO = new ShopProductPicVO();
				shopProductPicVO.setProdPicNo(rs.getInt("prod_pic_no")); // ?變數or欄位名稱
				shopProductPicVO.setProdNo(rs.getInt("prod_no"));
				shopProductPicVO.setProdPic(rs.getBytes("prod_pic"));

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
		return shopProductPicVO;
	}

	@Override
	public List<ShopProductPicVO> getAll() {
		List<ShopProductPicVO> list = new ArrayList<ShopProductPicVO>();
		ShopProductPicVO shopProductPicVO = null;

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
				shopProductPicVO = new ShopProductPicVO();
				shopProductPicVO.setProdPicNo(rs.getInt("prod_pic_no")); // ?變數or欄位名稱
				shopProductPicVO.setProdNo(rs.getInt("prod_no"));
				shopProductPicVO.setProdPic(rs.getBytes("prod_pic"));
				list.add(shopProductPicVO); // Store the row in the list
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
	public List<ShopProductPicVO> getALL(Map<String, String[]> map) {
		// ?交由jdbcUtil_CompositeQuery_Emp3.java 測試
		return null;
	}

	public static void main(String[] args) {

		ShopProductPicJDBCDAO dao = new ShopProductPicJDBCDAO();

		// 新增
		ShopProductPicVO shopProductPicVO1 = new ShopProductPicVO();
		shopProductPicVO1.setProdNo(5);
		dao.insert(shopProductPicVO1);

		// 修改
		ShopProductPicVO shopProductPicVO2 = new ShopProductPicVO();
		shopProductPicVO2.setProdPicNo(1);
		shopProductPicVO2.setProdNo(2);
		shopProductPicVO2.setProdPic(null);
		
		dao.update(shopProductPicVO2);

		// 刪除
		dao.delete(3);

		// 查詢
		ShopProductPicVO shopProductPicVO3 = dao.findByPrimaryKey(2);
		System.out.print(shopProductPicVO3.getProdPicNo() + ",");
		System.out.print(shopProductPicVO3.getProdNo());
		System.out.println("---------------------");

		// 查詢
		List<ShopProductPicVO> list = dao.getAll();
		for (ShopProductPicVO aShopProductPic : list) {
			System.out.print(aShopProductPic.getProdPicNo() + ",");
			System.out.print(aShopProductPic.getProdNo());
			System.out.println();

		}
	}
}
