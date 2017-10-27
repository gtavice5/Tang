package com.jkxy.tang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jkxy.tang.entity.Poetry;
import com.jkxy.tang.util.DBUtil;

public class PoetryDao {
	private Connection connection;
	private PreparedStatement ps;
	public PoetryDao(){
		connection=DBUtil.makeConnection();
	}

	public List<Poetry> getAllByName(String name){
		String sqlString="select ps.* from poetries ps left join poets p on ps.poet_id=p.id where p.name=?";
		List<Poetry> sList=new ArrayList<Poetry>();
		try {
			ps=connection.prepareStatement(sqlString);
			ps.setString(1, name);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()){
				Poetry poetry=new Poetry();
				poetry.setId(rSet.getInt(1));
				poetry.setPoet_id(rSet.getInt(2));
				poetry.setContent(rSet.getString(3));
				poetry.setTitle(rSet.getString(4));
				poetry.setCreated_at(rSet.getDate(5));
				poetry.setUpdated_at(rSet.getDate(6));
				sList.add(poetry);
			}
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DBUtil.closeConnection(ps,connection);
		}
	}
	
	
	public Poetry getByTitle(String title){
		String sqlString="select * from poetries where title =?";
		Poetry poetry=new Poetry();
		try {
			ps=connection.prepareStatement(sqlString);
			ps.setString(1, title);
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()){
				poetry.setId(rSet.getInt(1));
				poetry.setPoet_id(rSet.getInt(2));
				poetry.setContent(rSet.getString(3));
				poetry.setTitle(rSet.getString(4));
				poetry.setCreated_at(rSet.getDate(5));
				poetry.setUpdated_at(rSet.getDate(6));
			}
			return poetry;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DBUtil.closeConnection(ps,connection);
		}
		
	}
	
	public Poetry getByContent(String content){
		String sqlString="select "+ 
						"ps.id, "+
						"ps.poet_id, "+
						"p.name, "+
						"ps.content, "+
						"ps.title, "+
						"ps.created_at, "+
						"ps.updated_at "+ 
						"from poetries ps "+
						"left join poets p on ps.poet_id=p.id "+
						"where ps.content like ? limit 1";
		Poetry poetry=new Poetry();
		try {
			ps=connection.prepareStatement(sqlString);
			ps.setString(1, "%"+content+"%");
			ResultSet rSet=ps.executeQuery();
			while(rSet.next()){
				poetry.setId(rSet.getInt(1));
				poetry.setPoet_id(rSet.getInt(2));
				poetry.setName(rSet.getString(3));
				poetry.setContent(rSet.getString(4));
				poetry.setTitle(rSet.getString(5));
				poetry.setCreated_at(rSet.getDate(6));
				poetry.setUpdated_at(rSet.getDate(7));
			}
			return poetry;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			DBUtil.closeConnection(ps,connection);
		}
		
	}
}
