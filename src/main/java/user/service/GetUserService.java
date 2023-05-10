package user.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class GetUserService implements UserService{
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		UserDTO user = dao.getUser((int)map.get("id"));
		if(user == null){
			status = 400;
		}else {
			object.put("data",new JSONObject(user));
		}
		object.put("status",status);
		
		return object.toString();
	}
	
}
