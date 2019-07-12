package org.wm.dao;

import org.wm.entity.User;

public interface UserDao {

	boolean isExist(User user);
}
