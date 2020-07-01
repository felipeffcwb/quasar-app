package com.api.approaches.services;

import com.api.approaches.entities.Influencer;
import com.api.approaches.enums.StatusInfluencer;
import com.api.approaches.enums.SuperEnum;
import com.api.approaches.exceptions.InfluencerException;
import com.api.approaches.repositories.InfluencerRepository;
import com.api.approaches.utils.InfluencerUtils;
import com.api.approaches.utils.SuperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerService implements InfluencerUtils {
    @Autowired
    InfluencerRepository repository;

    public List<Influencer> getInfluencers() throws InfluencerException {
        List<Influencer> influencers = repository.findAllInfluencers();
        return influencers;
    }

    public Influencer getInfluencerById(Long id) throws InfluencerException {
        Influencer influencer = new Influencer();
        influencer = repository.findInfluencerById(id);
        if(objIsNullOrEmpty(influencer)){
            throw new InfluencerException("Influencer não localizado com este id: " + id);
        }
        return influencer;
    }

    public Influencer addInfluencer(Influencer influencer) throws InfluencerException {
        String campo = InfluencerDadosObrigatorios(influencer);
        if(campo != SuperEnum.IS_OK.name()) {
            throw new InfluencerException("Preencha corretamente os campos: " + campo);
        }
        if(objIsNullOrEmpty(repository.findInfluencerByEmail(influencer.getEmail()))){
            repository.save(influencer);
        } else {
            throw new InfluencerException("Já existe um Influencer cadastrado com email: " + influencer.getEmail()
                    + ", use outro email ou recupere sua conta!");
        }
        return influencer;
    }

    public Influencer deleteInfluencer(Long id) throws InfluencerException{
        if(id == 0 || id == null){
            throw new InfluencerException("Usuário inválido");
        }
        Influencer influencer = getInfluencerById(id);
        influencer.setStatusInfluencer(StatusInfluencer.EXCLUIDO);
        repository.save(influencer);
        return influencer;
    }
}
