package review.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import review.model.dto.UserDTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicInsert
@Entity
@Table(name="R_USER")
public class RUser {
	@Id
	@Column(name = "USER_ID")
	private String userId; 
	
	@Column(name = "USER_PW")
	private String userPw;
	
	private String nickName;
	
	@Column(name = "USER_EMAIL")
	private String userEmail; 

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USER_TYPE")
	private RUserType userType;

	
//  맵핑이 안되서 그냥 manytoOne으로 바꿈
//	@ManyToOne(targetEntity = RUserType.class)
//	@JoinColumn(name = "USER_TYPE")
//	private String userType; 
}
