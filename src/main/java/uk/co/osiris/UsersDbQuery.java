package uk.co.osiris;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository //this annotation is to tell the spring that this class is to access data for user (DAO class)
public class UsersDbQuery {
	private JdbcTemplate jdbcTemplate;

	public UsersDbQuery(@Autowired JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<UsersPojo> getUserDetails(String username) {
		String userSQLQuery = "SELECT * FROM USERS WHERE USERNAME=?";
		List<UsersPojo> list = jdbcTemplate.query(userSQLQuery, new ResultSetExtractor<List<UsersPojo>>(){  
			@Override 
			public List<UsersPojo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			  List<UsersPojo> list=new ArrayList<UsersPojo>(); 
			  while (rs.next()) {
				  UsersPojo u = new UsersPojo(rs.getString("username"), rs.getString("password")); 
				  list.add(u);
			  }
			  return list;
			}
		}, username);
		return list;
	}
}