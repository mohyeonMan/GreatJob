package recruit.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recruit.bean.RecruitDTO;
import recruit.bean.RecruitEntryDTO;
import recruit.dao.RecruitDAO;

/**
 * 
 * <pre>
 * 
 * @author jihoon
 * 
 * >>input
 * id(int)	 			공고 id
 * 
 * >>output
 * id(int)				공고 id
 * title(String)		제목
 * description(String)	내용
 * categoryId(int)		카테고리 id
 * categoryName			카테고리 이름
 * dateStart(long)		봉사 시작일
 * dateEnd(long)		봉사 종료일
 * host(String)			주관지
 * address(String) 		봉사 예정지
 * userId(int)			게시자 id
 * userName(String)		게사자 이름
 * maxPersonnel(int)	봉사 최대인원
 * currenPersonnel(int)	봉사 현재인원
 * dateCreated(Date)	게시일	
 * dateModified(Date)	수정일
 * 
 * </pre>
 * 
 */

@Service
@RequiredArgsConstructor
public class GetRecruitService implements RecruitService {
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;

	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		int status = 200;

		if (map.get("id") != null) {
			int id = Integer.parseInt((String) map.get("id"));
			RecruitDTO recruit = dao.getRecruit(id);

			if (recruit != null) {
				
				if(recruit.getImageUrl() != null) {
					recruit.setImageUrlArray(recruit.getImageUrl().split(","));
					recruit.setImageUrl(null);
				}
				
				if (map.get("userId") != null) {
					int userId = Integer.parseInt((String) map.get("userId"));
					recruit.setIsJoined(dao.isJoined(new RecruitEntryDTO(id, userId)));
				}
				
				dao.hit(id);
				object.put("data", new JSONObject(recruit));
			} else {
				status = 400;
			}
		} else {
			status = 400;
		}

		object.put("status", status);

		return object.toString();
	}
}
