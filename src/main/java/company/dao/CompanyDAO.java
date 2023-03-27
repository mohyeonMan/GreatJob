package company.dao;

import java.util.List;

import company.bean.CompanyDTO;
import company.bean.CompanyQueryOption;

public interface CompanyDAO {

	void create(CompanyDTO companyDTO);

	CompanyDTO getCompany(int id);

	int getCompanyCount();

	void update(CompanyDTO companyDTO);

	int getIdByUserId(String userId);

	void delete(int id);

	void rollback(int id);
	
	List<CompanyDTO> listCompanies(CompanyQueryOption option);

}
