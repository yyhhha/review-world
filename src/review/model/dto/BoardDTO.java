package review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import review.model.entity.RCategory;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoardDTO {

	private int boardId;
	private String title;
	private String content;
	private String boardDate;
	private int views;
	private int likes;
	private String categoryName; 
	private String nickname;
	private String userId;
	private String categoryId;


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" 게시글 번호 : ");
		builder.append(boardId);
		builder.append(" 제목 : ");
		builder.append(title);
		builder.append(" 카테고리 : ");
		builder.append(categoryName);
		builder.append(" 내용 : ");
		builder.append(content);
		builder.append(" 작성일 : ");
		builder.append(boardDate);
		builder.append(" 작성자 id : ");
		builder.append(userId);
		builder.append(" 조회수 : ");
		builder.append(views);
		builder.append(" 좋아요 : ");
		builder.append(likes);
		builder.append(nickname);
		builder.append(userId);
		builder.append(categoryId);
		
		return builder.toString();
	}

//	public RBoard toEntity() {
//		return RBoard.builder().boardId(boardId).title(title).categoryId(categoryId).views(views).likes(likes).
//				content(content).boardDate(boardDate).userId(userId).build();
//	}

}
