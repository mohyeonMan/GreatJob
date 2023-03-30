package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import user.bean.UserDTO;
import user.bean.UserQueryOption;

@Repository
@Primary
@Transactional
@RequiredArgsConstructor
public class UserDAOMyBatis implements UserDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void create(UserDTO userDTO) {
		sqlSession.insert("userMapper.create", userDTO);
	}

	@Override
	public int checkEmailExist(String email) {
		return sqlSession.selectOne("userMapper.checkEmailExist", email);
	}

	@Override
	public int logIn(Map<String, Object> map) {
		if (sqlSession.selectOne("userMapper.logIn", map) != null) {
			return sqlSession.selectOne("userMapper.logIn", map);
		} else {
			return 0;
		}

	}

	@Override
	public UserDTO getUser(int id) {
		return sqlSession.selectOne("userMapper.getUser", id);
	}

	@Override
	public int getUserCount() {
		return sqlSession.selectOne("userMapper.getUserCount");
	}

	@Override
	public int getIdByEmail(String email) {
		return sqlSession.selectOne("userMapper.getIdByEmail", email);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userMapper.update", userDTO);
	}

	@Override
	public void delete(int id) {
		sqlSession.update("userMapper.softDelete", id);
	}

	@Override
	public void rollback(int id) {
		sqlSession.update("userMapper.rollback", id);
	}

	@Override
	public void block(int id) {
		sqlSession.update("userMapper.block", id);
	}

	@Override
	public List<UserDTO> listUsers(UserQueryOption option) {
		// TODO Auto-generated method stub
		return null;
	}

}
