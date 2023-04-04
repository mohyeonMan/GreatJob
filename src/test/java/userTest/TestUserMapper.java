package userTest;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.main.GreatJobApplication;

import user.bean.UserDTO;
import user.dao.UserDAO;

@SpringBootTest
@ContextConfiguration(classes = GreatJobApplication.class)
public class TestUserMapper {
	@Autowired
	private Map<String, UserDAO> userDAO;
	
	@Test
	@Transactional
	void create() throws JsonProcessingException {
		
		//user 생성
		UserDTO user = new UserDTO();
		user.setImageUrl("url-");
		user.setName("name-");
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		user.setInterests(arr);
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType(1);
		userDAO.get("userDAOMyBatis").create(user);
			
		
		int count = userDAO.get("userDAOMyBatis").getUserCount();
		Assertions.assertThat(count).isEqualTo(1);
	}
	
	@Test
	@Transactional
	void checkIdExist() {
		//user 생성
		UserDTO user = new UserDTO();
		user.setImageUrl("url-");
		user.setName("name-");
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		user.setInterests(arr);
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType(1);
		userDAO.get("userDAOMyBatis").create(user);
		
		int exist = userDAO.get("userDAOMyBatis").checkEmailExist(user.getEmail());
		Assertions.assertThat(exist).isEqualTo(1);
		exist = userDAO.get("userDAOMyBatis").checkEmailExist("newEmail");
		Assertions.assertThat(exist).isEqualTo(0);
		
	}
	
	@Test
	@Transactional
	void logIn() {
		
		//user 생성
		UserDTO user = new UserDTO();
		user.setImageUrl("url-");
		user.setName("name-");
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		user.setInterests(arr);
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType(1);
		userDAO.get("userDAOMyBatis").create(user);
		
		Map<String, Object> map = new HashMap<>();
		map.put("email", "email@gmail.com");
		int id = userDAO.get("userDAOMyBatis").logIn(map);
		
		//right email
		int expectingId= userDAO.get("userDAOMyBatis").getIdByEmail(user.getEmail());
		Assertions.assertThat(id).isEqualTo(expectingId);

		//wrong email
		map.put("email", "wrongEmail@email.com");
		id = userDAO.get("userDAOMyBatis").logIn(map);
		Assertions.assertThat(id).isEqualTo(0);
	}
	
	@Test
	@Transactional
	void getUser() {
		
		//user생성
		UserDTO user = new UserDTO();
		user.setImageUrl("url-");
		user.setName("name-");
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		user.setInterests(arr);
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType(1);
		userDAO.get("userDAOMyBatis").create(user);
		
		//id로 user조회
		UserDTO returnUser = userDAO.get("userDAOMyBatis").getUser(userDAO.get("userDAOMyBatis").getIdByEmail("email@gmail.com"));
		Assertions.assertThat(returnUser.getImageUrl()).isEqualTo(user.getImageUrl());
		Assertions.assertThat(returnUser.getName()).isEqualTo(user.getName());
		Assertions.assertThat(returnUser.getInterests()).isEqualTo(user.getInterests());
		Assertions.assertThat(returnUser.getDescription()).isEqualTo(user.getDescription());
		Assertions.assertThat(returnUser.getEmail()).isEqualTo(user.getEmail());
		Assertions.assertThat(returnUser.getPhone()).isEqualTo(user.getPhone());
		Assertions.assertThat(returnUser.getAddress()).isEqualTo(user.getAddress());
		Assertions.assertThat(returnUser.getType()).isEqualTo(user.getType());
	}
	
	@Test
	@Transactional
	void update() {
		
		//user 생성
		UserDTO user = new UserDTO();
		user.setImageUrl("url-");
		user.setName("name-");
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		user.setInterests(arr);
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType(1);
		userDAO.get("userDAOMyBatis").create(user);
		
		//user 변경
		user.setId(userDAO.get("userDAOMyBatis").getIdByEmail("email@gmail.com"));
		user.setImageUrl("url---");
		user.setName("name---");
		List<Integer> arr2 = new ArrayList<>();
		arr.add(3);
		arr.add(4);
		user.setInterests(arr2);
		user.setDescription("description---");
		user.setEmail("email@gmail.com---");
		user.setPhone("phone---");
		user.setAddress("address---");
		user.setType(2);
		userDAO.get("userDAOMyBatis").update(user);
		
		//적용 확인
		UserDTO returnUser = userDAO.get("userDAOMyBatis").getUser(user.getId());
		Assertions.assertThat(returnUser.getImageUrl()).isEqualTo(user.getImageUrl());
		Assertions.assertThat(returnUser.getName()).isEqualTo(user.getName());
		Assertions.assertThat(returnUser.getInterests()).isEqualTo(user.getInterests());
		Assertions.assertThat(returnUser.getDescription()).isEqualTo(user.getDescription());
		Assertions.assertThat(returnUser.getEmail()).isEqualTo(user.getEmail());
		Assertions.assertThat(returnUser.getPhone()).isEqualTo(user.getPhone());
		Assertions.assertThat(returnUser.getAddress()).isEqualTo(user.getAddress());
		Assertions.assertThat(returnUser.getType()).isEqualTo(user.getType());
	}
	
	@Test
	@Transactional
	void softDeleft() {
		
		//user 생성
		UserDTO user = new UserDTO();
		user.setImageUrl("url-");
		user.setName("name-");
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		user.setInterests(arr);
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType(1);
		userDAO.get("userDAOMyBatis").create(user);
		
		//user 삭제
		int id = userDAO.get("userDAOMyBatis").getIdByEmail("email@gmail.com");
		userDAO.get("userDAOMyBatis").delete(id);
		
		//총 유저수 조회 - 삭제유저 포함
		Assertions.assertThat(userDAO.get("userDAOMyBatis").getUserCount()).isEqualTo(1);
		//유저 조회 - 삭제유저 미포함
		Assertions.assertThat(userDAO.get("userDAOMyBatis").getUser(id)).isNull();
		
	}

}
