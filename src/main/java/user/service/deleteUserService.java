package user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import user.dao.UserDAO;

@Service
@RequiredArgsConstructor
public class deleteUserService {
	Map<String, UserDAO> userDAO;

}
