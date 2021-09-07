package review.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString
@Table(name="R_USER_TYPE")
public class RUserType {
	@Id
	@Column(name = "USER_TYPE")
	private String userType; 
	
	@Column(name = "TYPE_NAME")
	private String typeName;
}
