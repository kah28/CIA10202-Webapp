package com.shop.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ShopProductPicDAO implements ShopProductPicDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cia102g2db");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
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


			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, shopProductPicVO.getProdNo());
			pstmt.setBytes(2, shopProductPicVO.getProdPic());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
				+ se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, shopProductPicVO.getProdNo());
			pstmt.setBytes(2, shopProductPicVO.getProdPic());
			pstmt.setInt(3, shopProductPicVO.getProdPicNo());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " 
					+ se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prodPicNo);

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " 
					+ se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, prodPicNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// shopProductPicVO 也稱為 Domain objects
				shopProductPicVO = new ShopProductPicVO();
				shopProductPicVO.setProdPicNo(rs.getInt("prod_pic_no")); // ?變數or欄位名稱
				shopProductPicVO.setProdNo(rs.getInt("prod_no"));
				shopProductPicVO.setProdPic(rs.getBytes("prod_pic"));

			}

			
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " 
					+ se.getMessage());
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

			con = ds.getConnection();
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
		// (暫不使用) ?交由jdbcUtil_CompositeQuery_Emp3.java 測試
		return null;
	}

	
}
