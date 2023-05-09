package recruit.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecruitEntryDTO {
	
	private int id;
	private int recruitId;
	private int userId;
	private long dateCreated;
	
	public RecruitEntryDTO(int recruitId, int userId) {
		this.recruitId = recruitId;
		this.userId = userId;
	}
}
