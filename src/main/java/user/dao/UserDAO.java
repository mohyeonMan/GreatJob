package user.dao;

import java.util.List;

import user.bean.UserDTO;
import user.bean.UserQueryOption;

public interface UserDAO {

	void create(UserDTO userDTO);
	
	UserDTO getUser(int id);
	
	int getUserCount();
		
	void update(UserDTO userDTO);
	
	void delete(int id);
	
	void rollback(int id);
	
	void block(int id);
	
	List<UserDTO> listUsers(UserQueryOption option);

	int getIdByUserId(String userId);
}
