package review.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@DynamicInsert
@Setter
@Builder
@SequenceGenerator(name="commentId_seq_gen", sequenceName="COMMENT_ID_seq", initialValue=1, allocationSize=1)
@Entity
@Table(name="R_COMMENT")
public class RComment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="commentId_seq_gen")
	@Column(name = "COMMENT_ID")
	private int commentId; 
	
	@Column(name = "COMMENT_CONTENT")
	private String commentContent;
		
	@Column(name = "COMMENT_DATE")
	private String commentDate;
	
	@ManyToOne
	@JoinColumn(name = "BOARD_ID")
	private RBoard boardId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private RUser userId; 
}
