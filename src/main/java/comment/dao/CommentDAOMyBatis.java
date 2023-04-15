package comment.dao;

import java.util.List;

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
	public CommentDTO getComment(int parentId) {
		return sqlSession.selectOne("commentMapper.getComment",parentId);
	}

	@Override
	public List<CommentDTO> listComments(CommentDTO comment) {
		return sqlSession.selectList("commentMapper.listComments",comment);
	}

}
