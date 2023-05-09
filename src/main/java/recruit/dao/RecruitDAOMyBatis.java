package recruit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.bean.RecruitEntryDTO;
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
	
	@Override
	public void delete(int id) {
		sqlSession.delete("recruitMapper.delete",id);
	}
	
	@Override
	public void hit(int id) {
		sqlSession.update("recruitMapper.hit",id);
	}
	
	@Override
	public String getRecruitImageUrl(int id) {
		return sqlSession.selectOne("recruitMapper.getRecruitImageUrl",id);
	}
	
	@Override
	public int joinRecruit(RecruitEntryDTO entryDTO) {
		return sqlSession.insert("recruitEntryMapper.join",entryDTO);
	}
	
	@Override
	public int secedeRecruit(RecruitEntryDTO entryDTO) {
		return sqlSession.delete("recruitEntryMapper.secede",entryDTO);
	}
	
	@Override
	public int isJoined(RecruitEntryDTO entryDTO) {
		System.out.println(entryDTO.toString());
		return sqlSession.selectOne("recruitEntryMapper.isJoined", entryDTO);
	}
	

}
