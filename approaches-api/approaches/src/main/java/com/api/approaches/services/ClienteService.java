package com.api.approaches.services;

import com.api.approaches.entities.Cliente;
import com.api.approaches.entities.Influencer;
import com.api.approaches.enums.StatusCliente;
import com.api.approaches.enums.StatusInfluencer;
import com.api.approaches.enums.SuperEnum;
import com.api.approaches.exceptions.ClienteException;
import com.api.approaches.exceptions.InfluencerException;
import com.api.approaches.repositories.ClienteRepository;
import com.api.approaches.utils.ClienteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteUtils {
    @Autowired
    ClienteRepository repository;

    public List<Cliente> getClientes() throws ClienteException {
        List<Cliente> clientes =  repository.getClientes();
        if(clientes == null || clientes.isEmpty()){
            throw  new ClienteException("Não existem clientes cadastrados");
        }
        return clientes;
    }

    public Cliente getClienteById(Long id) throws ClienteException{
        if(id == null || id == 0){
            throw new ClienteException("Cliente inválido");
        }
        Cliente cliente = repository.findClienteById(id);
        if(objIsNullOrEmpty(cliente)){
            throw new ClienteException("Não existem clientes cadastrados com este ID: " + id);
        }
        return cliente;
    }

    public Cliente addCliente(Cliente cliente) throws ClienteException {
        String campo = clienteDadosObrigatorios(cliente);
        if(campo != SuperEnum.IS_OK.name()) {
            throw new ClienteException("Preencha corretamente os campos: " + campo);
        }
        if(objIsNullOrEmpty(repository.findClienteByEmail(cliente.getEmail()))){
            repository.save(cliente);
        } else {
            throw new ClienteException("Já existe um cliente cadastrado com email: " + cliente.getEmail()
                    + ", use outro email ou recupere sua conta!");
        }
        return cliente;
    }

    public Cliente deleteCliente(Long id) throws ClienteException{
        if(id == 0 || id == null){
            throw new ClienteException("Usuário inválido");
        }
        Cliente cliente = getClienteById(id);
        cliente.setStatusCliente(StatusCliente.EXCLUIDO);
        repository.save(cliente);
        return cliente;
    }
}
