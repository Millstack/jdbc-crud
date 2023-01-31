package com.jsp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.Dto.Cafe;
import com.jsp.Utility.DBConnection;

public class CafeImplement implements CafeDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	String sql;
	
	public boolean addCafe(Cafe cafe) {
		con = DBConnection.getConnection();
		sql = "insert into cafe (name, type, category, price) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cafe.getName());
			ps.setString(2, cafe.getType());
			ps.setString(3, cafe.getCategory());
			ps.setDouble(4, cafe.getPrice());
			row = ps.executeUpdate();
			if(row>0) {
				return true;
			} else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCafe(Cafe cafe) {
		con = DBConnection.getConnection();
		sql = "update cafe set id=?, name=?, type=?, category=?, price=?";
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, cafe.getId());
			ps.setString(2, cafe.getName());
			ps.setString(3, cafe.getType());
			ps.setString(4, cafe.getCategory());
			ps.setDouble(5, cafe.getPrice());
			
			row = ps.executeUpdate();
			if(row>0) {
				return true;
			} else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteCcafe(int cafeID) {
		con = DBConnection.getConnection();
		sql = "delete from cafe where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cafeID);
			row = ps.executeUpdate();
			if(row>0) {
				return true;
			} else return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Cafe searchCafeById(int cafeId) {
		con = DBConnection.getConnection();
		Cafe cafe = null;
		sql = "select * from cafe where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cafeId);
			rs = ps.executeQuery();
			if (rs.next()) {
				cafe = new Cafe();
				cafe.setId(rs.getInt("id"));
				cafe.setName(rs.getString("name"));
				cafe.setType(rs.getString("type"));
				cafe.setCategory(rs.getString("category"));
				cafe.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cafe;
	}

	public List<Cafe> getAllCafe() {
		List<Cafe> cafeList = new ArrayList<Cafe>();
		con = DBConnection.getConnection();
		sql = "select * from cafe";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cafe cafe = new Cafe();
				cafe.setId(rs.getInt("id"));
				cafe.setName(rs.getString("name"));
				cafe.setType(rs.getString("type"));
				cafe.setCategory(rs.getString("category"));
				cafe.setPrice(rs.getDouble("price"));
				cafeList.add(cafe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cafeList;
	}
}