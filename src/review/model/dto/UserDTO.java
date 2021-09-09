package review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import review.model.entity.RUser;
import review.model.entity.RUserType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
	
	private String userId;
	private String userPw;
	private String nickName;
	private String userType;
	private String userEmail;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" id : ");
		builder.append(userId);
		builder.append(" pw : ");
		builder.append(userPw);
		builder.append(" 닉네임 : ");
		builder.append(nickName);
		builder.append(" 유저타입 : ");
		builder.append(userType);
		builder.append(" 유저 이메일 : ");
		builder.append(userEmail);
		return builder.toString();

	}
	
	public RUser toEntity() {
		RUser ruser = new RUser();
		ruser.setUserId(userId);
		ruser.setNickName(nickName);
		ruser.setUserEmail(userEmail);
		ruser.setUserPw(userPw);
		return ruser;
	}
}
