package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.dao.UserDAO;
import user.dao.UserDAOMyBatis;

@Service
@RequiredArgsConstructor
public class UserSignInService implements UserService{
	private Map<String, UserDAO> userDAO;
	
	@Override
	public JSONArray execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		UserDTO user = (UserDTO)map.get("user");
		
		dao.create(user);
		JSONArray arr = new JSONArray();
		int status = dao.getUser(dao.getIdByUserId(user.getUserId())) != null? 200:500;
		arr.put("{status:"+status+"}");			
		
		return arr;
	}
	
}
