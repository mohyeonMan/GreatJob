package comment.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.dao.CommentDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCommentService implements CommentService{
	@Autowired
	private Map<String, CommentDAO> commentDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		CommentDAO dao = commentDAO.get("commentDAOMyBatis");
		return null;
	}

}
