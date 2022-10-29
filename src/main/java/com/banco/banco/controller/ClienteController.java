package com.banco.banco.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.banco.model.ClienteModel;
import com.banco.banco.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    // Con Autowired no es necesario instanciar para usar los métodos
    @Autowired
    ClienteService clienteService;
    
    // Obtiene lista de clientes en la BD
    @GetMapping
    public ArrayList<ClienteModel> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    // Obtiene un cliente específico en la BD según su ID
    @GetMapping(path="/{idCliente}")
    public Optional<ClienteModel> obtenerPorIdCliente(@PathVariable("idCliente") Long idCliente) {
        return this.clienteService.obtenerPorIdCliente(idCliente);
    }

    // Obtiene clientes de ciudad específica
    @GetMapping("/place/{ciudad}")
    public ArrayList<ClienteModel> obtenerClientesPorCiudad(@PathVariable("ciudad") String ciudad) {
        return this.clienteService.obtenerClientesPorCiudad(ciudad);
    }

    // Crea un cliente en la BD
    @PostMapping
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Borra un cliente en la BD ssegún su ID
    @DeleteMapping(path="/{idCliente}")
    public boolean eliminarCliente(@PathVariable("idCliente") Long idCliente) {
        return this.clienteService.eliminarCliente(idCliente);
    }

    // No hay PUT mapping pues JPA lo gestiona internamente a través de POST cuando
    // el JSON de la petición incluye el ID
}
