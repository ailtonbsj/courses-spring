package io.ailtonbsj.projeto1.entity;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
}
