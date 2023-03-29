package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class getUserCountService implements UserService{
	Map<String, UserDAO> userDAO;
	
	@Override
	public JSONArray execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONArray arr = new JSONArray();
		
		int count = dao.getUserCount();
		arr.put("{status:200}");
		arr.put("{data:"+count+"}");
		return arr;
	}

}
