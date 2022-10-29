package com.banco.banco.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Decorador que mapea esta clase a una entidad en la BD
@Entity
// Decoradores de Lombok para gestión automática de getters y setters
// Decorador para gestión automática de constructor sin argumentos
@Getter @Setter @NoArgsConstructor
// Decorador que declara el nombre de la tabla en la BD
@Table(name = "cliente")
public class ClienteModel {

    @Id
    // Siguientes dos líneas llaman la secuencia creada previamente en la BD y la insertan como idCliente
    // OJO: al crear la secuencia en la BD poner en sequenceName el nombre que le dieron
    // allocationSize determina el valor del autoincremento en la secuencia
    @GeneratedValue(generator="idClienteSeq")
    @SequenceGenerator(name = "idClienteSeq", sequenceName = "seq_idcliente", allocationSize = 1)
    @Column(name = "id_cliente")
    private Long idCliente;
    
    @Column(name = "documento")
    private String documento;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "celular")
    private String celular;
    
    public ClienteModel(Long idCliente, String documento, String nombres, String apellidos, String correo, String ciudad, String dirección, String celular) {
        this.idCliente = idCliente;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.ciudad = ciudad;
        this.direccion = dirección;
        this.celular = celular;
    }
}
