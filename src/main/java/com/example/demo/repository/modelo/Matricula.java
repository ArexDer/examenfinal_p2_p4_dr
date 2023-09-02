package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@Entity
@Table(name = "matricula")
public class Matricula {
	
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula",allocationSize = 1)
    @Id
    @Column(name = "matr_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name ="matr_id_estudiante")
	private Estudiante estudiante;
	
	@ManyToMany
	@JoinColumn(name ="matr_id_materia")
	private List<Materia> materia;
	
	

}
