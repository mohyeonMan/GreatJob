package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class CheckUserService implements UserService {
	private Map<String, UserDAO> userDAO;

	@Override
	public JSONArray execute(Map<String, Object> map) {
		JSONArray arr = new JSONArray();
		UserDAO dao = userDAO.get("userDAOMyBatis");

		int exist = dao.checkEmailExist((String) map.get("email"));

		arr.put("{status:200}");
		arr.put("{data:" + exist + "}");
		return arr;
	}

}
