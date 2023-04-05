package recruit.service;

import java.util.ArrayList;
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


/**
 * 
 * <pre>
 * 
 * @author jihoon
 * >>input
 * categoryId(List<int>)	카테고리 id
 * address(List<String>)	주소 조건
 * sort(String)				정렬조건
 * startItem(int)			시작 행
 * 
 * >>output
 * list [
 * 		id(int)				공고 id
 * 		title(String)		제목
 * 		description(String)	내용
 * 		categoryId(int)		카테고리 id
 * 		categoryName(String)카테고리 이름
 * 		dateStart(Date)		봉사 시작일
 * 		dateEnd(Date)		봉사 종료일
 * 		host(String)		주관지
 * 		address(String) 	봉사 예정지
 * 		userId(int)			게시자 id
 * 		userName(String)	게시자 이름
 * 		maxPersonnel(int)	봉사 최대인원
 * 		currenPersonnel(int)봉사 현재인원
 * 		dateCreated(Date)	게시일	
 * 		dateModified(Date)	수정일
 * ]
 * </pre>
 * 
 */


@Service
@RequiredArgsConstructor
public class ListRecruitsService implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;

	@Override
	public String execute(Map<String, Object> map) {
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitQueryOption option;
		if(map == null) {
			option = new RecruitQueryOption();			
		}else {
			option = parseValue(map);
			System.out.println(option);
		}
		
		List<RecruitDTO> recruits = dao.listRecruits(option);
		object.put("data", new JSONArray(recruits));
		object.put("status", 200);
		
		return object.toString();
	}
	
	private RecruitQueryOption parseValue(Map<String, Object> map) {
		RecruitQueryOption option = new RecruitQueryOption();
		option.setCategoryId((ArrayList<Integer>)map.get("categoryId"));
		option.setAddress((ArrayList<String>)map.get("address"));
		option.setSort((String)map.get("sort")); 
		option.setStartItem(
			map.get("startItem") != null? (int)map.get("startItem"):0
		);
		
		return option;
	}
	

}
