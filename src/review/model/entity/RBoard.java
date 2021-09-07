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
@Setter
@Builder
@DynamicInsert
@Entity
@Table(name="R_BOARD")
@SequenceGenerator(name="boardId_seq_gen", sequenceName="BOARD_ID_seq", initialValue=1, allocationSize=1)
public class RBoard {
	@Id
	@Column(name = "BOARD_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="boardId_seq_gen")
	private int boardId; 
	
	private String title;
	private String content;
	
	@Column(name = "BOARD_DATE")
	private String boardDate;
	
	private int views; 
	private int likes;
	
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private RCategory categoryId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private RUser userId;

	}

