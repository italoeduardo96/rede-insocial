package com.br.redeinsocial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USER", schema = "CORE")
public class User {
	
	@Id
	@SequenceGenerator(name = "seq_user",
	                   sequenceName = "seq_user",
	                   schema = "core",
	                   initialValue = 1,
	                   allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	@Column(name = "ID_USER")
	private Long id;
	
	@Column(name = "NM_NICKNAME")
	private String nickname;
	
	@Column(name = "DT_CREATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCreate;
	
	@PrePersist
	public void prePersist() {
		setDtCreate(new Date());
	}
	
}
