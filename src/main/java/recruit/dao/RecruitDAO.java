package recruit.dao;

import java.util.List;

import recruit.bean.RecruitDTO;
import recruit.bean.RecruitQueryOption;

public interface RecruitDAO {

	void create(RecruitDTO recruitDTO);

	RecruitDTO getRecruit(int id);
	
	List<RecruitDTO> listRecruits(RecruitQueryOption option);

}
