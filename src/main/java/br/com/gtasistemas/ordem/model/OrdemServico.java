/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gtasistemas.ordem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
@Table(name = "ordem_servico")
@ApiModel(value = "OrdemServico", description = "Modelo para mostrar detalhes da Ordem de Serviço ")
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false)
    private Cliente clienteordem;
    @Column(columnDefinition = "TEXT")
    private String problema;
    @Column(columnDefinition = "TEXT")
    private String solucao;
    private String modelo_equipamento;
    private String marca_equipamento;
    private String status;
    @ManyToOne
    @JoinColumn(name = "idusuarioordem", nullable = false)
    private Usuario usuario_ordem_servico;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuario_ordem;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_entrega_prevista;
    @ManyToOne
    @JoinColumn(name = "idusuariofechamento", nullable = false)
    private Usuario usuario_fechamento;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data_hora_usuario_fechamento;


}
