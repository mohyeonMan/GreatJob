package company.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import company.bean.CompanyDTO;
import company.bean.CompanyQueryOption;

@Repository
@Transactional
public class CompanyDAOMyBatis implements CompanyDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void create(CompanyDTO companyDTO) {
		sqlSession.insert("companyMapper.create", companyDTO);
	}

	@Override
	public CompanyDTO getCompany(int id) {
		return sqlSession.selectOne("companyMapper.getCompany", id);
	}

	@Override
	public int getCompanyCount() {
		return sqlSession.selectOne("companyMapper.getCompanyCount");
	}

	@Override
	public void update(CompanyDTO companyDTO) {
		sqlSession.update("companyMapper.update", companyDTO);
	}

	@Override
	public int getIdByUserId(String userId) {
		return sqlSession.selectOne("companyMapper.getIdByUserId", userId);
	}

	@Override
	public void delete(int id) {
		sqlSession.update("companyMapper.softDelete", id);
	}

	@Override
	public void rollback(int id) {
		sqlSession.update("companyMapper.rollback", id);
	}

	@Override
	public List<CompanyDTO> listCompanies(CompanyQueryOption option) {
		return sqlSession.selectList("companyMapper.listCompanies", option);
	}

}
