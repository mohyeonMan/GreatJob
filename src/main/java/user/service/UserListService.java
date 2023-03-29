package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserListService implements UserService{
	public Map<String, UserDAO> userDAO;
	
	@Override
	public JSONArray execute(Map<String, Object> map) {
		 
		return null;
	}

}