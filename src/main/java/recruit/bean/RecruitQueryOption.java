package recruit.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
public class RecruitQueryOption {
	
	private List<Integer> categoryId;
	private List<String> address;
	private String sort;
	private int startItem = 0;
	private int itemAmount = 10;
	
	public void setCategoryId(String categoryId) {
		String[] strArr = categoryId.split(",");
		List<Integer> list = new ArrayList<>();
		for (String str : strArr) {
			list.add(Integer.parseInt(str));
		}
		this.categoryId = list;
	}
	
	public void setAddress(String address) {
		String[] strArr = address.split(",");
		List<String> list = new ArrayList<>();
		for (String str : strArr) {
			list.add(str);
		}
		this.address = list;
	}
	
}
