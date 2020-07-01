package com.api.approaches.repositories;

import com.api.approaches.entities.Cliente;
import com.api.approaches.entities.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(nativeQuery = true,
            value =
                    "select * from cliente c where c.status_cliente != 3 and c.id = ?1")
    Cliente findClienteById(Long id);

    @Query(nativeQuery = true,
            value =
                    "select * from cliente c where c.email = ?1")
    Cliente findClienteByEmail(String email);

    @Query(nativeQuery = true,
            value =
                    "select * from cliente c where c.status_cliente != 3")
    List<Cliente> getClientes();
}
