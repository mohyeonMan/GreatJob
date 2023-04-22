package recruit.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.json.JSONArray;
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
 * title(String)		제목
 * description(String)	내용
 * categoryId(int)		카테고리의 id
 * dateStart(long)		봉사 시작일
 * dateEnd(long)		봉사 종료일
 * host(String)			주관지
 * userId(int)			게시자의 id
 * maxPersonnel(int)	봉사 최대인원
 * address(String) 		봉사 예정지
 * 
 * </pre>
 * 
 */


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
		recruit.setDateStart((long)map.get("dateStart")/1000);
		recruit.setDateEnd((long)map.get("dateEnd")/1000);
		recruit.setHost((String)map.get("host"));
		recruit.setUserId((int)map.get("userId"));
		recruit.setMaxPersonnel((int)map.get("maxPersonnel"));
		recruit.setAddress((String)map.get("address"));
		
		return recruit; 
	}
	
	public void imageUpload() {
		
	}

	
}
