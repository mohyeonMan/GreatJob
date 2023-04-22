package recruit.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.javassist.expr.NewArray;
import org.json.JSONArray;
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
public class CreateRecruitService2 implements RecruitService{
	@Autowired
	private Map<String, RecruitDAO> recruitDAO;
	
	

	@Override
	public String execute(Map<String, Object> map) {
		
		RecruitDAO dao = recruitDAO.get("recruitDAOMyBatis");
		JSONObject object = new JSONObject();
		
		RecruitDTO recruit = parseValue(new JSONObject((String)map.get("data")));
		
		if (map.get("images") != null) {
			try {
				String imageUrls = imageUpload((MultipartFile[]) map.get("images"));
				recruit.setImageUrl(imageUrls);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(recruit.getImageUrl());
		dao.create(recruit);
		
		object.put("status", 200);
		
		return object.toString();
	}
	public RecruitDTO parseValue(JSONObject jsonObject) {
		RecruitDTO recruit = new RecruitDTO();
		recruit.setTitle((String)jsonObject.get("title"));
		recruit.setDescription((String)jsonObject.get("description"));
		recruit.setCategoryId((int)jsonObject.get("categoryId"));
		recruit.setDateStart((long)jsonObject.get("dateStart")/1000);
		recruit.setDateEnd((long)jsonObject.get("dateEnd")/1000);
		recruit.setHost((String)jsonObject.get("host"));
		recruit.setUserId((int)jsonObject.get("userId"));
		recruit.setMaxPersonnel((int)jsonObject.get("maxPersonnel"));
		recruit.setAddress((String)jsonObject.get("address"));
		
		return recruit; 
	}
	
	public String imageUpload(MultipartFile[] images) throws IOException {
		String imageUrls = "";
		
		for(int i = 0;i<images.length;i++) {
			UUID uuid = UUID.randomUUID();
			MultipartFile image = images[i];
			String imageUrl = uuid.toString()+"_"+image.getOriginalFilename();
			image.transferTo(new File("src/main/resources/images/"+imageUrl));
			
			imageUrls += imageUrl;
			
			if(i != images.length-1) {
				imageUrls+=",";
			}
		}
		
		return imageUrls;
		
	}

	
}
