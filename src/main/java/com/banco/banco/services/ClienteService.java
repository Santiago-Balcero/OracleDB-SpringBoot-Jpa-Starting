package com.banco.banco.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.banco.model.ClienteModel;
import com.banco.banco.repositories.ClienteRepository;

@Service
public class ClienteService {

    // No es necesario instanciar
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel usuario) {
        return clienteRepository.save(usuario);
    }

    // Optional hace el manejo de excepciones automáticamente en caso de no encontrar registro en la BD
    public Optional<ClienteModel> obtenerPorIdCliente(Long idCliente) {
        return clienteRepository.findByIdCliente(idCliente);
    }

    public ArrayList<ClienteModel> obtenerClientesPorCiudad(String ciudad) {
        return clienteRepository.findByCiudad(ciudad);
    }

    public boolean eliminarCliente(Long idCliente) {
        try {
            return clienteRepository.deleteByIdCliente(idCliente);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
