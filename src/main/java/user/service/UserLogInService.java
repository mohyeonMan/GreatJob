package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserLogInService implements UserService {
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public JSONArray execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONArray arr = new JSONArray();
		
		//아이디 중복여부 확인 후 없으면 가입.
		int type = dao.checkEmailExist((String)map.get("email"));
		if(type == -1){
			UserDTO user = parseValue(map);
			dao.create(user);
		}else if(type != (int)map.get("type")) {
			arr.put(new JSONObject().put("status", 400));
		}
		int id = dao.logIn(map);
		if (id == 0 ) {
			arr.put(new JSONObject().put("status", 500));
		} else {
			arr.put(new JSONObject().put("data", id));
			arr.put(new JSONObject().put("status", 200));
		}
		return arr;
		
		//로그인 후 가져온 id
	}
	
	public UserDTO parseValue (Map<String, Object> map) {
		UserDTO user = new UserDTO();
		user.setEmail((String)map.get("email"));
		user.setImageUrl((String)map.get("imageUrl"));
		user.setType((int)map.get("type"));
		user.setName((String)map.get("name"));	
		System.out.println("parsedUser ->"+user);
		return user;
	}

}
