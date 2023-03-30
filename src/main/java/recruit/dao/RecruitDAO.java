package recruit.dao;

import recruit.bean.RecruitDTO;

public interface RecruitDAO {

	void create(RecruitDTO recruitDTO);

	void getRecruit(int id);

}
