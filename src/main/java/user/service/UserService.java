package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.bean.UserQueryOption;
import user.dao.UserDAO;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	
	public void signIn(UserDTO user) {
		userDAO.create(user);
	}

	public UserDTO getUser(int id) {
		return userDAO.getUser(id);
	}
	
	public List<UserDTO> listUsers() {
		UserQueryOption option = new UserQueryOption();
		return userDAO.listUsers(option);
	}

	public void editUser(UserDTO user) {
		userDAO.update(user);
	}

	public void deleteUser(int id) {
		userDAO.delete(id);
	}
	
	public void rollback(int id) {
		userDAO.rollback(id);
	}
	
	public void block(int id) {
		userDAO.block(id);
	}

	public int getUserCount() {
		return userDAO.getUserCount();
	}
	
}
