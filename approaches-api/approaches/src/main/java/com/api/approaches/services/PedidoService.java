package com.api.approaches.services;

import com.api.approaches.entities.Cliente;
import com.api.approaches.entities.Pedido;
import com.api.approaches.enums.SuperEnum;
import com.api.approaches.exceptions.ClienteException;
import com.api.approaches.exceptions.PedidoException;
import com.api.approaches.repositories.PedidoRepository;
import com.api.approaches.utils.PedidoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements PedidoUtils {
    @Autowired
    PedidoRepository repository;

    public List<Pedido> getPedidos() throws PedidoException {
        List<Pedido> pedidos = repository.findAll();
        if(objIsNullOrEmpty(pedidos)){
            throw new PedidoException("Não existem pedidos cadastrados");
        }
        return pedidos;
    }

    public Pedido addPedido(Pedido pedido) throws PedidoException {
        repository.save(pedido);
        return pedido;
    }
}
