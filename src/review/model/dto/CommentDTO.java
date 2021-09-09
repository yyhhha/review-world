package review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import review.model.entity.RComment;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentDTO {

	private int boardId;
	private String commentContent;
	private String commentDate;
	private String userId;
	private int commentId; 
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("게시물 번호 : ");
		builder.append(boardId);
		builder.append("작성내용 : ");
		builder.append(commentContent);
		builder.append("작성일 : ");
		builder.append(commentDate);
		builder.append("유저 id : ");
		builder.append(userId);
		builder.append("댓글 번호 : ");
		builder.append(commentId);
		return builder.toString();

	}
	
//	public RComment toEntity() {
//		return RComment.builder().boardId(boardId).commentContent(commentContent).commentDate(commentDate).userId(userId).commentId(commentId).build();
//
//	}
}