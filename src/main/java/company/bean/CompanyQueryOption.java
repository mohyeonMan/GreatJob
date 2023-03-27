package company.bean;

import java.sql.Date;

import lombok.Data;

@Data
public class CompanyQueryOption {

	private String keyword;
	private String category;
	private Date dateCreatedFrom;
	private Date dateCreatedTO;
	private Boolean status;
	
	private String sortOption;
	
}
