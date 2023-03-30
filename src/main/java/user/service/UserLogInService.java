package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserLogInService implements UserService {
	private Map<String, UserDAO> userDAO;

	@Override
	public JSONArray execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONArray arr = new JSONArray();
		int status = 200;
		int id = dao.logIn(map);

		if (id == 0 ) {
			status = 500;
		} else {
			arr.put("{data:" + id + "}");
		}
		arr.put("{status:" + status + "}");

		return arr;
	}

}
