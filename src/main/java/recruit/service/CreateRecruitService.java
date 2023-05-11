package recruit.service;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	private S3Manager s3Manager;

	@Override
	public String execute(Map<String, Object> map) {
		
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitDTO recruit = parseValue((JSONObject)map.get("data"));
		System.out.println(recruit.toString());
		
		if (map.get("images") != null) {
			String imageUrls = s3Manager.UploadGetUrl((ArrayList<MultipartFile>) map.get("images"));
			recruit.setImageUrl(imageUrls);
		}
		
		dao.create(recruit);
		
		object.put("status", 200);
		
		return object.toString();
	}
	public RecruitDTO parseValue(JSONObject data) {
		RecruitDTO recruit = new RecruitDTO();
		recruit.setTitle((String)data.get("title"));
		recruit.setDescription((String)data.get("description"));
		recruit.setCategoryId((int)data.get("categoryId"));
		recruit.setDateStart((long)data.get("dateStart")/1000);
		recruit.setDateEnd((long)data.get("dateEnd")/1000);
		recruit.setHost((String)data.get("host"));
		recruit.setUserId((int)data.get("userId"));
		recruit.setMaxPersonnel((int)data.get("maxPersonnel"));
		recruit.setAddress((String)data.get("address"));
		
		return recruit; 
	}
	
	

	
}
