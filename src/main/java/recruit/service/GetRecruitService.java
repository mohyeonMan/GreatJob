package recruit.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.dao.RecruitDAO;

@Service
@RequiredArgsConstructor
public class GetRecruitService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;

	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitDTO recruit = dao.getRecruit((int)map.get("id"));
		if(recruit == null) {
			object.put("status", 400);
		}else {
			object.put("data",new JSONObject(recruit));
			object.put("status", 200);
		}
		
		return object.toString();
	}
}
