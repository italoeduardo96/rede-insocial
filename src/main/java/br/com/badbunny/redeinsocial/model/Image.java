package br.com.badbunny.redeinsocial.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "TB_IMAGE", schema = "CORE")
public class Image implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_IMAGE")
	private UUID idImage;
	
	@Column(name = "NM_IMAGE")
	private String nmImage;
	
	@Column(name = "DS_IMAGE_TYPE")
	private String dsImageType;
	
	@Column(name = "FILE")
	private String file;
	
	public Image(String nmImage, String dsImageType, String file) {
		this.nmImage = nmImage;
		this.dsImageType = dsImageType;
		this.file = file;
	}
	
	public Image(UUID idImage, String nmImage, String dsImageType, String file) {
		this.idImage = idImage;
		this.nmImage = nmImage;
		this.dsImageType = dsImageType;
		this.file = file;
	}
}
