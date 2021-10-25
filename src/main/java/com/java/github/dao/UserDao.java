package com.java.github.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.github.model.User;

@Transactional
@Repository
public class UserDao {
	private static String CURRENT_CLASS		 		= "UserDao";
	
	@Autowired
	@Qualifier("pgJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public List<User> fetchUserDetails(){
		String CURRENT_METHOD = "fetchUserDetails";	
		String USER_FETCH = "SELECT USERID, USERNAME, STATUS FROM DEV.USER";
		System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
		
		@SuppressWarnings("unchecked")
		List<User> lstUser = jdbcTemplate.query(USER_FETCH, new UserRowMapper());
		return lstUser;
	}
	
	@SuppressWarnings("rawtypes")
	class UserRowMapper implements RowMapper{		
		private String CURRENT_CLASS		 		= "UserRowMapper";
		
		/* 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			String CURRENT_METHOD = "mapRow";		
			//System.out.println(CURRENT_CLASS+" ::: "+CURRENT_METHOD+":: Inside method");
						
			return new User(rs.getInt("USERID"), rs.getString("USERNAME"), rs.getString("STATUS"));
		}
	}
		
}
