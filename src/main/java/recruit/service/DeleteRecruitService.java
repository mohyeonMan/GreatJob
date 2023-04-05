package recruit.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.dao.RecruitDAO;

@Service
@RequiredArgsConstructor
public class DeleteRecruitService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		int status = 200;
		int id = (int)map.get("id");
		
		dao.delete(id);
		
		if(dao.getRecruit(id) != null) {
			status = 500;
		}
		object.put("status", status);
		
		return object.toString();
	}

}
