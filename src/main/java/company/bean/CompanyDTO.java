package company.bean;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CompanyDTO {

	private int id; // PK
	private String imageUrl;
	private String name; // NN
	private String userId; // NN
	private String password; // NN
	private String email;
	private String description; // NN
	private String address;
	private Date dateCreated; // NN

}
