package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "materia")
public class Materia {
	
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia",allocationSize = 1)
    @Id
    @Column(name = "mat_id")
	private Integer id;
	
	@Column(name = "mat_nombre")
	private String nombre;
	
	@Column(name = "mat_codigo")
	private String codigo;
	
	@Column(name = "mat_numero_credito")
	private String numeroCredito;
	
	@Column(name = "mat_cedula_profesor")
	private String cedulaProfesor;
	
	@OneToMany(mappedBy = "materia")
	 private List<Matricula> listaMatriculaM;
	

}
