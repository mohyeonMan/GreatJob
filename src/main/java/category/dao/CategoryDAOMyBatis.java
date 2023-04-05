package category.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Repository
@Primary
@Transactional
@RequiredArgsConstructor
public class CategoryDAOMyBatis {
	@Autowired
	SqlSession sqlSession;

	public void create(String name) {
		sqlSession.insert("categoryMapper.create",name);
	}
	
	public List<Map<String, Object>> listCategories(){
		return sqlSession.selectList("categoryMapper.listCategories");
	}
	
	public void delete(int id) {
		sqlSession.delete("categoryMapper.delete",id);
	}
}
