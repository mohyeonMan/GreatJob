package user.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements UserService {
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONObject object = new JSONObject();
		
		int status = 200;
		int id = (int) map.get("id");

		dao.delete(id);

		if (dao.getUser(id) != null) {
			status = 500;
		}
		object.put("status", status);
		
		return object.toString();
	}

}
