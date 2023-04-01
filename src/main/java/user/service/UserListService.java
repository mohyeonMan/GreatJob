package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserListService implements UserService {
	private Map<String, UserDAO> userDAO;

	@Override
	public Map<String, Object> execute(Map<String, Object> map) {

		return null;
	}

}
