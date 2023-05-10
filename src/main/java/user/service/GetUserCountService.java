package user.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class GetUserCountService implements UserService {
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONObject object = new JSONObject();
		
		int count = dao.getUserCount();
		object.put("data", new JSONObject().put("count", count));
		object.put("status", 200);
		return object.toString();
	}

}
