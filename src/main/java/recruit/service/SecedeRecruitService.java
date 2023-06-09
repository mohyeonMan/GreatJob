package recruit.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitEntryDTO;
import recruit.dao.RecruitDAO;

@Service
@RequiredArgsConstructor
public class SecedeRecruitService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;
	
	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao =recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;
		
		if(map.get("userId") != null && map.get("recruitId") != null) {
			int userId = (int)map.get("userId");
			int recruitId = (int)map.get("recruitId");
			
			if(dao.secedeRecruit(new RecruitEntryDTO(recruitId,userId)) == 0) {
				status = 500;
			}
		}else {
			status = 400;
		}
		object.put("status", status);
		
		return object.toString();
	}

}
