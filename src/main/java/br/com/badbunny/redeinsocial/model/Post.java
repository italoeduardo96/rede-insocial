package br.com.badbunny.redeinsocial.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_POST", schema = "CORE")
public class Post {
	
	@Id
	@SequenceGenerator(name = "seq_post",
	                   sequenceName = "seq_post",
	                   schema = "core",
	                   initialValue = 1,
	                   allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_post")
	@Column(name = "ID_POST")
	private Long postId;
	
	@ManyToOne
	@JoinColumn(name="ID_USER")
	private User user;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "DT_CREATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreate;
	
	@Column(name = "DS_POST")
	private String postDescription;
	
	@Column(name = "IS_DELETED")
	private boolean isDeleted;
	
	
	public Post(final User user, final String postDescription) {
		this.user = user;
		this.postDescription = postDescription;
	}
	
	@PrePersist
	public void prePersist() {
		setDtCreate(new Date());
	}
	
}
