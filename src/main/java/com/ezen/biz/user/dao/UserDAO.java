package com.ezen.biz.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.user.dto.UserVO;
import com.ezen.biz.users.UserService;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	private static final String USER_GET 
	= "select * from users where id=? and password=?";
	
	public UserVO getUser(UserVO vo) {
			UserVO user = null;

			try {
				conn = JDBCUtil.getConnection();
				pstmt = conn.prepareStatement(USER_GET);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPassword());
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					user = new UserVO();
					user.setId(rs.getString("id"));
					user.setPassword(rs.getString("password"));
					user.setName(rs.getString("name"));
					user.setRole(rs.getString("role"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn, pstmt, rs);
			}
			
			return user;
		}
}
