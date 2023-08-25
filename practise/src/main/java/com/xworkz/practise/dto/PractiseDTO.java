package com.xworkz.practise.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "practise")
@NamedQuery (name="find" ,query="select dto from PractiseDTO dto ") 
public class PractiseDTO {
	@Id
	@Column(name = "id")

	private int id;
	@Column(name = "name")
	private String name;

	public PractiseDTO() {
		System.out.println("Practise DTO Running");
	}

}
