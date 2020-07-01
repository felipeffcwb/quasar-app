package com.api.approaches.controllers.v1;

import com.api.approaches.entities.Cliente;
import com.api.approaches.entities.Influencer;
import com.api.approaches.exceptions.ClienteException;
import com.api.approaches.exceptions.InfluencerException;
import com.api.approaches.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService service;

    @RequestMapping(
            path = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getClientes() throws ClienteException {
        List<Cliente> clientes = service.getClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @RequestMapping(
            path = "/listbyid/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getClienteById(@PathVariable Long id) throws ClienteException {
        Cliente cliente = service.getClienteById(id);
        ResponseEntity responseEntity = new ResponseEntity(cliente, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/add/cliente",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity addInfluencer(@RequestBody Cliente cliente) throws ClienteException {
        service.addCliente(cliente);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/delete/cliente/{id}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity deleteCliente(@PathVariable Long id) throws ClienteException{
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
