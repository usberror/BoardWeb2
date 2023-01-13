package com.ezen.biz.users;

import org.springframework.stereotype.Service;

import com.ezen.biz.user.dao.UserDAO;
import com.ezen.biz.user.dto.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	
	private UserDAO userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
	
		return userDAO.getUser(vo);
	}

	@Override
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;

	}

}
