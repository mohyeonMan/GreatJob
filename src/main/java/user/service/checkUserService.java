package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class checkUserService implements UserService{
	Map<String, UserDAO> userDAO;

	@Override
	public JSONArray execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		int exist = dao.checkEmailExist((String)map.get("email"));
		JSONArray arr = new JSONArray();
		arr.put("{status:200}");
		arr.put("{data:"+exist+"}");
		return arr;
	}

}
