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
			recruitDAO.recruitEntryDelete(id);
			String imageUrlString = recruitDAO.getRecruitImageUrl(id);
			if(imageUrlString != null) {
				s3Manager.deleteS3Image(imageUrlString);
			}
			
			if(recruitDAO.delete(id) == 0) {
				status =500;
			}

			
		}else {
			status = 400;
		}
		
		object.put("status", status);
		
		return object.toString();
	}

	

}
