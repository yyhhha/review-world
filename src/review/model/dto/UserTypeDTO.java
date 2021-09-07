package review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import review.model.entity.RUserType;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserTypeDTO {

	private String userType;
	private String typeName;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("유저 타입 종류 : ");
		builder.append(userType);
		builder.append("타입 이름 : ");
		builder.append(typeName);

		return builder.toString();

	}
	
	public RUserType toEntity() {
		return RUserType.builder().userType(userType).typeName(typeName).build();

	}
}