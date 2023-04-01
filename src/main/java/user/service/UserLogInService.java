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
public class UserLogInService implements UserService {
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONObject object = new JSONObject();
		
		//아이디 중복여부 확인 후 없으면 가입.
		int type = dao.checkEmailExist((String)map.get("email"));
		if(type == -1){
			UserDTO user = parseValue(map);
			dao.create(user);
		//type이 일치하지 않으면, 이미 가입된 이메일.
		}else if(type != (int)map.get("type")) {
			object.put("status", 400);
			return object.toString();
		}
		//로그인
		int id = dao.logIn(map);
		if (id == 0 ) {
			object.put("status", 500);
		} else {
			object.put("status", 200);
			object.put("data", new JSONObject().put("id", id));
		}
		return object.toString();
		
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
