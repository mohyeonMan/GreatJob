package user.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.bean.UserQueryOption;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class ListUsersService implements UserService{
	@Autowired
	private Map<String, UserDAO> userDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONObject object = new JSONObject();
		
		UserQueryOption option = new UserQueryOption();
		List<UserDTO> users = dao.listUsers(option);
		object.put("data", new JSONArray(users));
		object.put("status", 200);
		
		return object.toString();
	}

}
