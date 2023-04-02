package category.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CategoryDAOMyBatis {
	@Autowired
	SqlSession sqlSession;

	public void create(String name) {
		sqlSession.insert("categoryMapper.create",name);
	}
	
	public List<Map<String, Object>> listCategories(){
		return sqlSession.selectList("categoryMapper.listCategories");
	}
}
