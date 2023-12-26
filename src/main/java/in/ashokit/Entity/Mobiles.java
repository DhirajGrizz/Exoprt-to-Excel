package in.ashokit.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Mobile_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mobiles {
	
	@Id
	private Integer mobileId;
	
	private String mobileName;
	
	private Double mobilePrice;

	

}
