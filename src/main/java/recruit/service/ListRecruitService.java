package recruit.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.bean.RecruitQueryOption;
import recruit.dao.RecruitDAO;

@Service
@RequiredArgsConstructor
public class ListRecruitService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;

	@Override
	public String execute(Map<String, Object> map) {
		System.out.println("recruitDAO=============="+recruitDAO);
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitQueryOption option = new RecruitQueryOption();
		List<RecruitDTO> recruits = dao.listRecruits(option);
		object.put("data", new JSONArray(recruits));
		
		return object.toString();
	}
	
	private RecruitQueryOption parseValue(Map<String, Object> map) {
		RecruitQueryOption option = new RecruitQueryOption();
		return option;
	}
	

}
