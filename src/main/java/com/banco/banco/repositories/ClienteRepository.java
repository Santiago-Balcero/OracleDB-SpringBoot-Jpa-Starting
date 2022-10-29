package com.banco.banco.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.banco.model.ClienteModel;

// Esta interfaz en JPA no necesita ser instanciada, se instancia internamente
// Al extender el CrudRepository se tiene acceso a métodos predefinidos
@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{

    public abstract ArrayList<ClienteModel> findAll();
    
    public abstract Optional<ClienteModel> findByIdCliente(Long idCliente);

    public abstract ArrayList<ClienteModel> findByCiudad(String ciudad);

    public abstract boolean deleteByIdCliente(Long idCliente);
}
