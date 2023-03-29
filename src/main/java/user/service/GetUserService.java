package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class GetUserService implements UserService{
	private Map<String, UserDAO> userDAO;

	@Override
	public JSONArray execute(Map<String, Object> map) {
		UserDAO dao = userDAO.get("userDAOMyBatis");
		JSONArray arr = new JSONArray();
		int status = 200;
		UserDTO user = dao.getUser((int)map.get("id"));
		try {
			arr.put("{data:"+
					new ObjectMapper().writeValueAsString(user)
					+"}");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			status = 500;
		}
		arr.put("{status:"+status+"}");
		return arr;
	}
	
}
