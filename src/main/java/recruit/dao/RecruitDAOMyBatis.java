package recruit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.bean.RecruitQueryOption;

@Repository
@Primary
@Transactional
@RequiredArgsConstructor
public class RecruitDAOMyBatis implements RecruitDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(RecruitDTO recruitDTO) {
		sqlSession.insert("recruitMapper.create",recruitDTO);
	}
	
	@Override
	public void update(RecruitDTO recruitDTO) {
		sqlSession.update("recruitMapper.update",recruitDTO);
	}
	
	@Override
	public RecruitDTO getRecruit(int id) {
		return sqlSession.selectOne("recruitMapper.getRecruit",id);
	}

	@Override
	public List<RecruitDTO> listRecruits(RecruitQueryOption option) {
		return sqlSession.selectList("recruitMapper.listRecruits",option);			
	}

}
