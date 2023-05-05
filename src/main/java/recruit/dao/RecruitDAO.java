package recruit.dao;

import java.util.List;

import recruit.bean.RecruitDTO;
import recruit.bean.RecruitQueryOption;

public interface RecruitDAO {

	void create(RecruitDTO recruitDTO);

	void update(RecruitDTO recruitDTO);
	
	RecruitDTO getRecruit(int id);

	List<RecruitDTO> listRecruits(RecruitQueryOption option);

	void delete(int id);

	void hit(int id);

	String getRecruitImageUrl(int id);

}
