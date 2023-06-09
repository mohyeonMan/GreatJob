package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import board.bean.BoardDTO;
import board.bean.BoardQueryOption;
import lombok.RequiredArgsConstructor;

@Repository
@Primary
@Transactional
@RequiredArgsConstructor
public class BoardDAOMyBatis implements BoardDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void create(BoardDTO board) {
		sqlSession.insert("boardMapper.create",board);
	}
	
	@Override
	public BoardDTO getBoard(int id) {
		return sqlSession.selectOne("boardMapper.getBoard",id);
	}
	
	@Override
	public List<BoardDTO> listBoards(BoardQueryOption option){
		return sqlSession.selectList("boardMapper.listBoards",option);
	}
	
	@Override
	public int update(BoardDTO board) {
		return sqlSession.update("boardMapper.update",board);
	}
	
	@Override
	public int delete(int id) {
		return sqlSession.delete("boardMapper.delete",id);
	}
	
	@Override
	public void hit(int id) {
		sqlSession.update("boardMapper.hit",id);
	}
	
	@Override
	public String getBoardImageUrl(int id) {
		return sqlSession.selectOne("boardMapper.getBoardImageUrl",id);
	}
}
