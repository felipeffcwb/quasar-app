package com.api.approaches.utils;

import java.util.List;

public interface SuperUtils {

    public default boolean objIsNullOrEmpty(Object obj){
        if(obj == null || obj.equals("")){
            return true;
        }
        return false;
    }

    public default boolean  stringIsNullOrEmpty(String field){
        if(field == null || field.isEmpty()){
            return true;
        }
        return false;
    }
}
