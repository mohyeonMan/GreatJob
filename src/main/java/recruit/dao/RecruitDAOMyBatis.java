package recruit.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;

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
	public void getRecruit(int id) {
		sqlSession.selectOne("recuritMapper.getRecruit",id);
	}

}
