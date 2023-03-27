package user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.bean.UserQueryOption;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(UserDTO userDTO) {
		sqlSession.insert("userMapper.create",userDTO);
	}

	@Override
	public UserDTO getUser(int id) {
		return sqlSession.selectOne("userMapper.getUser",id);
	}

	@Override
	public int getUserCount() {
		return sqlSession.selectOne("userMapper.getUserCount");
	}

	@Override
	public int getIdByUserId(String userId) {
		return sqlSession.selectOne("userMapper.getIdByUserId",userId);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userMapper.update",userDTO);
	}

	@Override
	public void delete(int id) {
		sqlSession.update("userMapper.softDelete",id);
	}

	@Override
	public void rollback(int id) {
		sqlSession.update("userMapper.rollback",id);
	}
	
	@Override
	public void block(int id) {
		sqlSession.update("userMapper.block",id);
	}

	@Override
	public List<UserDTO> listUsers(UserQueryOption option) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
