package board.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BoardQueryOption {
	
	private List<Integer> categoryId;
	private String sort;
	private int startItem = 0;
	private int itemAmount= 10;
	private String keyword;
	
	public void setCategoryId(String categoryId) {
		String[] strArr = categoryId.split(",");
		List<Integer> list = new ArrayList<>();
		for (String str : strArr) {
			list.add(Integer.parseInt(str));
		}
		this.categoryId = list;
	}
}
