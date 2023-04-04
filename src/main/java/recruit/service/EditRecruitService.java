package recruit.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.dao.RecruitDAO;

/**
 * 
 * <pre>
 * 
 * @author jihoon
 * 
 * >>input
 * id(int)				id
 * title(String)		제목
 * description(String)	내용
 * categoryId(int)		카테고리의 id
 * dateStart(long)		봉사 시작일
 * dateEnd(long)		봉사 종료일
 * host(String)			주관지
 * maxPersonnel(int)	봉사 최대인원
 * address(String) 		봉사 예정지
 * 
 * </pre>
 * 
 */


@Service 
@RequiredArgsConstructor
public class EditRecruitService implements RecruitService {
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;

	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitDTO replaceRecruit = parseValue(map);
		
		dao.update(replaceRecruit);
		
		RecruitDTO changedRecruit = dao.getRecruit((int)map.get("id"));
		
		if(replaceRecruit == null|| changedRecruit == null) {
			object.put("status", 400);
		}else {
			if(compareRecruit(replaceRecruit, changedRecruit)) {
				object.put("status", 200);
			}else {
				object.put("status", 500);
			}
		}
		
		return object.toString();
	}

	private RecruitDTO parseValue (Map<String, Object> map) {
		RecruitDTO recruit = new RecruitDTO();
		recruit.setId((int)map.get("id"));
		recruit.setTitle((String)map.get("title"));
		recruit.setDescription((String)map.get("description"));
		recruit.setCategoryId((int)map.get("categoryId"));
		recruit.setDateStart((long)map.get("dateStart")/1000);
		recruit.setDateEnd((long)map.get("dateEnd")/1000);
		recruit.setHost((String)map.get("host"));
		recruit.setMaxPersonnel((int)map.get("maxPersonnel"));
		recruit.setAddress((String)map.get("address"));

		return recruit;
	}
	
	private boolean compareRecruit(RecruitDTO recruit1, RecruitDTO recruit2) {
		System.out.println("replace------------"+recruit1);
		System.out.println("changed------------"+recruit2);
		return (
				recruit1.getId() == recruit2.getId()
			&&	recruit1.getTitle().equals(recruit2.getTitle())
			&&	recruit1.getDescription().equals(recruit2.getDescription())
			&&	recruit1.getCategoryId() == recruit2.getCategoryId()
			&&	recruit1.getDateStart() == recruit2.getDateStart()
			&&	recruit1.getDateEnd() == recruit2.getDateEnd()
			&&	recruit1.getHost().equals(recruit2.getHost())
			&&	recruit1.getMaxPersonnel() == recruit2.getMaxPersonnel()
			&&	recruit1.getAddress().equals(recruit2.getAddress())
		);
	}
	
}
