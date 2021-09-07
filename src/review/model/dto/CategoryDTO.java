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
public class CategoryDTO {

	private String categoryId;
	private String categoryName;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" 카테고리 id : ");
		builder.append(categoryId);
		builder.append(" 카테고리 이름 : ");
		builder.append(categoryName);
		return builder.toString();
	}

	public RCategory toEntity() {
		return RCategory.builder().categoryId(categoryId).categoryName(categoryName).build();
	}
}
