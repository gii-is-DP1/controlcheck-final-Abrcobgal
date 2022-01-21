package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import antlr.collections.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="care")
public class Care extends BaseEntity{
	
	@Column(name="name", unique = true)
	@NotNull
	@Size(min=3, max=50)
    String name;
	
	@Column(name = "description")
	@NotEmpty
    String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@NotEmpty
	@JoinColumn(name = "type_id")
    Set<PetType> compatiblePetTypes;

}
