package comment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comment.bean.CommentDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommentDAOMyBatis implements CommentDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(CommentDTO comment) {
		sqlSession.update("commentMapper.create", comment);
	}

	@Override
	public CommentDTO getMaterialFromParent(int parentId) {
		return sqlSession.selectOne("commentMapper.getMaterialFromParent",parentId);
	}

	@Override
	public CommentDTO getComment(int id) {
		return sqlSession.selectOne("commentMapper.getComment",id);
	}
	
	@Override
	public List<CommentDTO> listComments(CommentDTO comment) {
		return sqlSession.selectList("commentMapper.listComments",comment);
	}
	
	@Override
	public void delete(int id) {
		sqlSession.update("commentMapper.delete",id);
	}
	
	@Override
	public void rollBack(int id) {
		sqlSession.update("commentMapper.rollBack",id);
	}

	@Override
	public void update(CommentDTO comment) {
		sqlSession.update("commentMapper.update",comment);
	}
	
	@Override
	public void objectDeleted(Map<String, Object> map) {
		sqlSession.delete("commentMapper.objectDeleted",map);
	}
}
