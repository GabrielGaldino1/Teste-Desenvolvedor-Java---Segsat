package com.prova_segsat.projeto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Vehicle {
    @Id
    @JsonProperty("Id")
    private Long id;

    @JsonProperty("Loja")
    private String loja;

    @JsonProperty("LojaId")
    private int lojaId;

    @JsonProperty("Tipo")
    private String tipo;

    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Modelo")
    private String modelo;

    @JsonProperty("Versao")
    private String versao;

    @JsonProperty("Km")
    private int km;

    @JsonProperty("AnoFabricacao")
    private int anoFabricacao;

    @JsonProperty("AnoModelo")
    private int anoModelo;

    @JsonProperty("Cor")
    private String cor;

    @JsonProperty("Combustivel")
    private String combustivel;

    @JsonProperty("Transmissao")
    private String transmissao;

    @JsonProperty("Placa")
    private String placa;

    @JsonProperty("Chassi")
    private String chassi;

    @JsonProperty("Opcionais")
    @Column(length = 2048)
    private String opcionais;

    @JsonProperty("Caracteristicas")
    @Column(length = 2048)
    private String caracteristicas;

    @JsonProperty("PrecoDe")
    private Double precoDe;

    @JsonProperty("Preco")
    private Double preco;

    @JsonProperty("Portas")
    private int portas;

    @JsonProperty("Condicao")
    private String condicao;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Estoque")
    private String estoque;

    @JsonProperty("Publicado")
    private boolean publicado;

    @JsonProperty("Blindado")
    private boolean blindado;

    @JsonProperty("HashDados")
    private String hashDados;

    @JsonProperty("HashImagem")
    private String hashImagem;

    @JsonProperty("Fotos")
    @CollectionTable(name = "vehicle_fotos", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Column(name = "fotos", length = 2048)
    @ElementCollection
    private List<String> fotos;

    @JsonProperty("Observacao")
    @Column(length = 2048)
    private String observacao;

    @JsonProperty("DataHoraAPI")
    private String dataHoraAPI;

    @JsonProperty("SuperOferta")
    private boolean superOferta;

    @JsonProperty("Video")
    private String video;

    @JsonProperty("Carroceria")
    private String carroceria;

    @JsonProperty("SpinCar")
    private boolean spinCar;

    @JsonProperty("DiasEstoque")
    private Integer diasEstoque;
}
