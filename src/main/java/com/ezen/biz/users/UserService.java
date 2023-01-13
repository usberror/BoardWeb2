package com.ezen.biz.users;

import com.ezen.biz.user.dao.UserDAO;
import com.ezen.biz.user.dto.UserVO;

public interface UserService {

	UserVO getUser(UserVO vo);

	void setUserDAO(UserDAO userDAO);

}