package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import board.bean.BoardDTO;
import board.bean.BoardQueryOption;

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
	public void update(BoardDTO board) {
		sqlSession.update("boardMapper.update",board);
	}
	
	@Override
	public void delete(int id) {
		sqlSession.delete("boardMapper.delete",id);
	}
	
	@Override
	public void hit(int id) {
		sqlSession.update("boardMapper.hit",id);
	}
}
