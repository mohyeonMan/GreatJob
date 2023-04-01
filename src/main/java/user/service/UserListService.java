package user.service;

import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class UserListService implements UserService {
	@Autowired
	private Map<String, UserDAO> userDAO;

	@Override
	public String execute(Map<String, Object> map) {

		return null;
	}

}
