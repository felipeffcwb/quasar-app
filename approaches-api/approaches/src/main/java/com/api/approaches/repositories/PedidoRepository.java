package com.api.approaches.repositories;

import com.api.approaches.entities.Influencer;
import com.api.approaches.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
