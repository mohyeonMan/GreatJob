package recruit.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comment.dao.CommentDAO;
import lombok.RequiredArgsConstructor;
import recruit.dao.RecruitDAO;

@Service
@RequiredArgsConstructor
public class DeleteRecruitService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAOMap;
	@Autowired
	private Map<String, CommentDAO> commentDAOMap;
	@Autowired
	private S3Manager s3Manager;
	
	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO recruitDAO = recruitDAOMap.get("recruitDAOMyBatis");
		CommentDAO commentDAO = commentDAOMap.get("commentDAOMyBatis");
		JSONObject object = new JSONObject();
		
		int status = 200;
		
		if(map.get("id") != null) {
			int id = (int)map.get("id");
			
			map.put("object", 1);
			commentDAO.objectDeleted(map);
			String imageUrlString = recruitDAO.getRecruitImageUrl(id);
			deleteS3Image(imageUrlString);
			
			recruitDAO.delete(id);

			if(recruitDAO.getRecruit(id) != null) {
				status = 500;
			}
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}

	private void deleteS3Image(String imageUrlString) {
		String[] imageUrlArray= imageUrlString.split(",");
		for (String imageUrl : imageUrlArray) {
			s3Manager.delete(imageUrl);
		}
	}

}
