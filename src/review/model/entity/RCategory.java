package review.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

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
@ToString
@Entity
@DynamicInsert
@Table(name="R_CATEGORY")

public class RCategory {
	@Id
	@Column(name = "CATEGORY_ID")
	private String categoryId; 
	
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
}
 