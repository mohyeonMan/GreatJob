package userTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.main.GreatJobApplication;

import user.bean.UserDTO;
import user.dao.UserDAO;

@SpringBootTest
@ContextConfiguration(classes = GreatJobApplication.class)
public class TestUserMapper {
	@Autowired
	UserDAO userDAO;
	
	@Test
	@Transactional
	void create() {
		
		//user 생성
		UserDTO user = new UserDTO();
		user.setUserId("userId-");
		user.setPassword("password-");
		user.setImageUrl("url-");
		user.setName("name-");
		user.setInterest("interest-");
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType("kakao-");
		userDAO.create(user);
		
		int count = userDAO.getUserCount();
		Assertions.assertThat(count).isEqualTo(1);
	}
	
	@Test
	@Transactional
	void getUser() {
		
		//user생성
		UserDTO user = new UserDTO();
		user.setUserId("userId-");
		user.setPassword("password-");
		user.setImageUrl("url-");
		user.setName("name-");
		user.setInterest("interest-");
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType("kakao-");
		userDAO.create(user);
		
		//id로 user조회
		UserDTO returnUser = userDAO.getUser(userDAO.getIdByUserId("userId-"));
		Assertions.assertThat(returnUser.getUserId()).isEqualTo(user.getUserId());
		Assertions.assertThat(returnUser.getPassword()).isEqualTo(user.getPassword());
		Assertions.assertThat(returnUser.getImageUrl()).isEqualTo(user.getImageUrl());
		Assertions.assertThat(returnUser.getName()).isEqualTo(user.getName());
		Assertions.assertThat(returnUser.getInterest()).isEqualTo(user.getInterest());
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
		user.setUserId("userId-");
		user.setPassword("password-");
		user.setImageUrl("url-");
		user.setName("name-");
		user.setInterest("interest-");
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType("kakao-");
		userDAO.create(user);
		
		//user 변경
		user.setId(userDAO.getIdByUserId("userId-"));
		user.setPassword("password---");
		user.setImageUrl("url---");
		user.setName("name---");
		user.setInterest("interest---");
		user.setDescription("description---");
		user.setEmail("email@gmail.com---");
		user.setPhone("phone---");
		user.setAddress("address---");
		user.setType("kakao---");
		userDAO.update(user);
		
		//적용 확인
		UserDTO returnUser = userDAO.getUser(user.getId());
		Assertions.assertThat(returnUser.getUserId()).isEqualTo(user.getUserId());
		Assertions.assertThat(returnUser.getPassword()).isEqualTo(user.getPassword());
		Assertions.assertThat(returnUser.getImageUrl()).isEqualTo(user.getImageUrl());
		Assertions.assertThat(returnUser.getName()).isEqualTo(user.getName());
		Assertions.assertThat(returnUser.getInterest()).isEqualTo(user.getInterest());
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
		user.setUserId("userId-");
		user.setPassword("password-");
		user.setImageUrl("url-");
		user.setName("name-");
		user.setInterest("interest-");
		user.setDescription("description-");
		user.setEmail("email@gmail.com");
		user.setPhone("phone-");
		user.setAddress("address-");
		user.setType("kakao-");
		userDAO.create(user);
		
		//user 삭제
		int id = userDAO.getIdByUserId("userId-");
		userDAO.delete(id);
		
		//총 유저수 조회 - 삭제유저 포함
		Assertions.assertThat(userDAO.getUserCount()).isEqualTo(1);
		//유저 조회 - 삭제유저 미포함
		Assertions.assertThat(userDAO.getUser(id)).isNull();

		
	}

}
