package com.shop.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ShopProductDAO implements ShopProductDAO_interface {

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


			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, shopProductVO.getProdTypeNo());
			pstmt.setString(2, shopProductVO.getProdName());
			pstmt.setString(3, shopProductVO.getProdInfo());
			pstmt.setInt(4, shopProductVO.getProdPrice());
			pstmt.setInt(5, shopProductVO.getProdStatus());
			pstmt.setTimestamp(6, shopProductVO.getProdDate());

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
	public void update(ShopProductVO shopProductVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, shopProductVO.getProdTypeNo());
			pstmt.setString(2, shopProductVO.getProdName());
			pstmt.setString(3, shopProductVO.getProdInfo());
			pstmt.setInt(4, shopProductVO.getProdPrice());
			pstmt.setInt(5, shopProductVO.getProdStatus());
			pstmt.setTimestamp(6, shopProductVO.getProdDate());
			pstmt.setInt(7, shopProductVO.getProdNo());
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
	public void delete(Integer prodNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prodNo);

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
	public ShopProductVO findByPrimaryKey(Integer prodNo) {

		ShopProductVO shopProductVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, prodNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// shopProductVO 也稱為 Domain objects
				shopProductVO = new ShopProductVO();
				
				shopProductVO.setProdNo(rs.getInt("prod_no"));
				shopProductVO.setProdTypeNo(rs.getInt("prod_type_no"));
				shopProductVO.setProdName(rs.getString("prod_name"));
				shopProductVO.setProdInfo(rs.getString("prod_info"));
				shopProductVO.setProdPrice(rs.getInt("prod_price"));
				shopProductVO.setProdStatus(rs.getInt("prod_status"));
				shopProductVO.setProdDate(rs.getTimestamp("prod_date"));
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

			con = ds.getConnection();
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
		// ?(暫不使用)
		return null;
	}

	
}
