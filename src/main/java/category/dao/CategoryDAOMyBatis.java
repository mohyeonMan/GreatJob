package category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import category.bean.CategoryDTO;
import lombok.RequiredArgsConstructor;

@Repository
@Primary
@Transactional
@RequiredArgsConstructor
public class CategoryDAOMyBatis {
	@Autowired
	SqlSession sqlSession;

	public void create(CategoryDTO category) {
		sqlSession.insert("categoryMapper.create",category);
	}
	
	public List<CategoryDTO> listCategories(int object){
		return sqlSession.selectList("categoryMapper.listCategories",object);
	}
	
	public void delete(int id) {
		sqlSession.delete("categoryMapper.delete",id);
	}
}
