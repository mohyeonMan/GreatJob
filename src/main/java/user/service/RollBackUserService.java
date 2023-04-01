package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class RollBackUserService implements UserService {
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONArray arr = new JSONArray();
		int status = 200;
		int id = (int) map.get("id");
		dao.rollback(id);

		if (dao.getUser(id) == null) {
			status = 500;
		}
		arr.put("{status:" + status + "}");
		return null;
	}

}
