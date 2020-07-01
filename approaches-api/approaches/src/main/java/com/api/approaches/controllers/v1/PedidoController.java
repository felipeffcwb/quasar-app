package com.api.approaches.controllers.v1;

import com.api.approaches.entities.Influencer;
import com.api.approaches.entities.Pedido;
import com.api.approaches.exceptions.InfluencerException;
import com.api.approaches.exceptions.PedidoException;
import com.api.approaches.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/pedido/")
public class PedidoController {
    @Autowired
    PedidoService service;

    @RequestMapping(
            path = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getInfluencers() throws PedidoException {
        List<Pedido> pedidos = service.getPedidos();
        ResponseEntity responseEntity = new ResponseEntity(pedidos, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/add/pedido",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity addPedido(@RequestBody Pedido pedido) throws PedidoException {
        service.addPedido(pedido);
        return ResponseEntity.ok().body(pedido);
    }
}
