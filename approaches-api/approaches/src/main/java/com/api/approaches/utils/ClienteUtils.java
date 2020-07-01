package com.api.approaches.utils;

import com.api.approaches.entities.Cliente;
import com.api.approaches.entities.Influencer;
import com.api.approaches.enums.SuperEnum;

public interface ClienteUtils extends SuperUtils {
    public default String clienteDadosObrigatorios(Cliente obj){
        if(stringIsNullOrEmpty(obj.getEmail())){
            return SuperEnum.EMAIL.name();
        } else if(stringIsNullOrEmpty(obj.getNome())){
            return SuperEnum.NOME.name();
        };
        return SuperEnum.IS_OK.name();
    }
}
