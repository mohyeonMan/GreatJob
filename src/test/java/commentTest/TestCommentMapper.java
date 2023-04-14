package commentTest;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.main.GreatJobApplication;

import comment.bean.CommentDTO;
import comment.dao.CommentDAO;
import user.dao.UserDAO;

@SpringBootTest
@ContextConfiguration(classes = GreatJobApplication.class)
public class TestCommentMapper {
	@Autowired
	private CommentDAO dao;
	
//	@Test
//	@Transactional
//	void getMaxGroup(){
//		CommentDTO comment = new CommentDTO();
//		comment.setObject(1);
//		comment.setObjectId(1);
//		comment.setUserId(130);
//		comment.setDescription("댓글");	
//		
//		int maxGroup = dao.getMaxGroup(comment)+1;
//		
//		int commentGroup = dao.getMaxGroup(comment)+1;
//		comment.setCommentGroup(commentGroup);
//		
//		dao.create(comment);
//		
//	}

}
