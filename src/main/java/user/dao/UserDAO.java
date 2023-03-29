package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserQueryOption;

public interface UserDAO {

	void create(UserDTO userDTO);
	
	int logIn(Map<String, Object> map);
	
	UserDTO getUser(int id);
	
	int getUserCount();
		
	void update(UserDTO userDTO);
	
	void delete(int id);
	
	void rollback(int id);
	
	void block(int id);
	
	List<UserDTO> listUsers(UserQueryOption option);

	int getIdByUserId(String userId);

	int checkIdExist(String userId);

}
