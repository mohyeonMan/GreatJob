package user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class EditUserService implements UserService{
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONObject object = new JSONObject();
		
		UserDTO replaceUser = parseValue(map);
		
		dao.update(replaceUser);
		
		UserDTO changedUser = dao.getUser((int)map.get("id"));
		
		if(replaceUser == null|| changedUser == null) {
			object.put("status", 400);
		}else {
			if(compareUser(replaceUser, changedUser)) {
				object.put("status", 200);
			}else {
				object.put("status", 500);
			}
		}
		
		return object.toString();
	}
	
	private UserDTO parseValue (Map<String, Object> map) {
		UserDTO user = new UserDTO();
		user.setId((int)map.get("id"));
		user.setName((String)map.get("name"));
		user.setInterests((ArrayList<Integer>)map.get("interest"));
		user.setDescription((String)map.get("description"));
		user.setPhone((String)map.get("phone"));
		user.setAddress((String)map.get("address"));
		
		return user;
	}
	
	private boolean compareUser (UserDTO user1,UserDTO user2) {
		return(
				user1.getId() == user2.getId()
			&&	user1.getName().equals(user2.getName())
			&&	user1.getInterests().equals(user2.getInterests())
			&&	user1.getDescription().equals(user2.getDescription())
			&&	user1.getPhone().equals(user2.getPhone())
			&&	user1.getAddress().equals(user2.getAddress())
		);
		
	}

	
}
