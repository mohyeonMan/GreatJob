package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserLogInService implements UserService {
	private Map<String, UserDAO> userDAO;

	@Override
	public JSONArray execute(Map<String, Object> map) {
		System.out.println("This is UserLogInService");
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONArray arr = new JSONArray();
		
		//아이디 중복여부 확인 후 없으면 가입.
		if(dao.checkEmailExist((String)map.get("email")) == 0){
			UserDTO user = parseValue(map);
			System.out.println("createUser" + user);
			dao.create(user);
		}else {
			arr.put("{\"status\":400}");
			return arr;
		}
		
		//로그인 후 가져온 id
		int id = dao.logIn(map);
		System.out.println("return user id -> "+id);
		if (id == 0 ) {
			arr.put("{\"status\":500}");
		} else {
			arr.put("{\"data\":" + id + "}");
			arr.put("{\"status\":200}");
		}
		System.out.println("jsonarray -> " +arr);
		return arr;
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
