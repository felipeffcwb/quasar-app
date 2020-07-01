package com.api.approaches.utils;

import com.api.approaches.entities.Influencer;
import com.api.approaches.enums.SuperEnum;
import com.api.approaches.exceptions.InfluencerException;
import com.api.approaches.repositories.InfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface InfluencerUtils extends SuperUtils {
    public default String InfluencerDadosObrigatorios(Influencer obj){
        if(stringIsNullOrEmpty(obj.getEmail())){
            return SuperEnum.EMAIL.name();
        } else if(stringIsNullOrEmpty(obj.getNome())){
            return SuperEnum.NOME.name();
        };
        return SuperEnum.IS_OK.name();
    }
}
