package recruit.service;

import java.sql.Date;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.dao.RecruitDAO;

@Service 
@RequiredArgsConstructor
public class CreateRecruitService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;

	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitDTO recruit = parseValue(map);
		dao.create(recruit);
		
		object.put("status", 200);
		
		return object.toString();
	}
	public RecruitDTO parseValue(Map<String, Object> map) {
		RecruitDTO recruit = new RecruitDTO();
		recruit.setTitle((String)map.get("title"));
		recruit.setDescription((String)map.get("description"));
		recruit.setCategoryId((int)map.get("categoryId"));
		recruit.setDateStart(new Date((long)map.get("dateStart")));
		recruit.setDateEnd(new Date((long)map.get("dateEnd")));
		recruit.setHost((String)map.get("host"));
		recruit.setUserId((int)map.get("userId"));
		recruit.setMaxPersonnel((int)map.get("maxPersonnel"));
		recruit.setAddress((String)map.get("address"));
		
		return recruit; 
	}

	
}
