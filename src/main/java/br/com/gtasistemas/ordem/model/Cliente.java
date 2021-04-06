package br.com.gtasistemas.ordem.model;

import java.io.*;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode

/**
 *
 * @author Jeandro
 */
@Entity
@ApiModel(value = "Cliente", description = "Modelo para mostrar detalhes do Cliente ")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    @org.hibernate.annotations.NaturalId(mutable = true)
    private String email;
    @org.hibernate.annotations.NaturalId(mutable = true)
    private String cpf;
    private String celular;
    private String endereco;
    private String cep;
    @ManyToOne
    @JoinColumn(name = "idcidade", nullable = false)
    private Cidade cidadecliente;


}
