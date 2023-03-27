package companyTest;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.main.GreatJobApplication;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;


@SpringBootTest
@ContextConfiguration(classes = GreatJobApplication.class)
public class TestCompanyMapper {
	@Autowired
	CompanyDAO companyDAO;

	@Test
	@Transactional
	void create() {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setImageUrl("url-");
		companyDTO.setName("name-");
		companyDTO.setUserId("userId-");
		companyDTO.setPassword("password-");
		companyDTO.setDescription("description-");
		companyDTO.setAddress("address-");
		companyDTO.setEmail("email@gmail.com");
		
		companyDAO.create(companyDTO);
		
		int count = companyDAO.getCompanyCount();
		Assertions.assertThat(count).isEqualTo(1);
	}
	
	@Test
	@Transactional
	void getCompany() {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setUserId("userId-");
		companyDTO.setImageUrl("url-");
		companyDTO.setPassword("password-");
		companyDTO.setName("name-");
		companyDTO.setDescription("description-");
		companyDTO.setAddress("address-");

		companyDAO.create(companyDTO);
		
		CompanyDTO returnCompany = companyDAO.getCompany(companyDAO.getIdByUserId("userId-"));
		Assertions.assertThat(returnCompany.getImageUrl()).isEqualTo("url-");
		Assertions.assertThat(returnCompany.getName()).isEqualTo("name-");
		Assertions.assertThat(returnCompany.getDescription()).isEqualTo("description-");
		Assertions.assertThat(returnCompany.getAddress()).isEqualTo("address-");
	}
	
	@Test
	@Transactional
	void edit() {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setUserId("userId-");
		companyDTO.setImageUrl("url-");
		companyDTO.setPassword("password-");
		companyDTO.setName("name-");
		companyDTO.setDescription("description-");
		companyDTO.setAddress("address-");
		companyDTO.setEmail("email@gmail.com-");
		companyDAO.create(companyDTO);	
		
		companyDTO.setId(companyDAO.getIdByUserId("userId-"));
		companyDTO.setUserId("userId---");
		companyDTO.setImageUrl("url---");
		companyDTO.setPassword("password---");
		companyDTO.setName("name---");
		companyDTO.setDescription("description---");
		companyDTO.setAddress("address---");
		companyDTO.setEmail("email@gmail.com---");
		
		companyDAO.update(companyDTO);
		
		CompanyDTO returnCompany = companyDAO.getCompany(companyDTO.getId());
		Assertions.assertThat(returnCompany.getImageUrl()).isEqualTo("url---");
		Assertions.assertThat(returnCompany.getName()).isEqualTo("name---");
		Assertions.assertThat(returnCompany.getDescription()).isEqualTo("description---");
		Assertions.assertThat(returnCompany.getAddress()).isEqualTo("address---");
		Assertions.assertThat(returnCompany.getEmail()).isEqualTo("email@gmail.com---");
	}
	
	@Test
	@Transactional
	void delete_rollback() {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setUserId("userId-");
		companyDTO.setPassword("password-");
		companyDTO.setName("name-");
		companyDTO.setDescription("description-");
		companyDAO.create(companyDTO);	
		int id = companyDAO.getIdByUserId("userId-");
		
		CompanyDTO returnCompany = companyDAO.getCompany(id);
		Assertions.assertThat(returnCompany).isNotNull();
		
		companyDAO.delete(id);
		
		returnCompany = companyDAO.getCompany(id);
		Assertions.assertThat(returnCompany).isNull();
		
		companyDAO.rollback(id);
		
		returnCompany = companyDAO.getCompany(id);
		Assertions.assertThat(returnCompany).isNotNull();
		
	}

}
