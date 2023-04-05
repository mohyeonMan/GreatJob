package recruit.bean;

import java.util.List;

import lombok.Data;

@Data
public class RecruitQueryOption {
	
	private List<Integer> categoryId;
	private List<String> address;
	private String sort;
	private int startItem = 0;
	private int itemAmount = 10;
	
}
