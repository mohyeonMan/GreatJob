package user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public Map<String, Object> execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		Map<String, Object> returnMap = new HashMap<>();
		
		//아이디 중복여부 확인 후 없으면 가입.
		int type = dao.checkEmailExist((String)map.get("email"));
		if(type == -1){
			UserDTO user = parseValue(map);
			dao.create(user);
		//type이 일치하지 않으면, 이미 가입된 이메일.
		}else if(type != (int)map.get("type")) {
			returnMap.put("status", 400);
			return returnMap;
		}
		//로그인
		int id = dao.logIn(map);
		if (id == 0 ) {
			returnMap.put("status", 500);
		} else {
			JSONArray arr = new JSONArray();
			arr.put(new JSONObject().put("id", id));
			returnMap.put("data", arr.toString());
			returnMap.put("status", 200);
		}
		return returnMap;
		
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
