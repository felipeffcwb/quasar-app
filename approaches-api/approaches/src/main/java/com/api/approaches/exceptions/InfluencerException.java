package com.api.approaches.exceptions;

import com.api.approaches.entities.Influencer;
import com.api.approaches.utils.SuperUtils;

public class InfluencerException extends SuperException {

    public InfluencerException(String message, Object... args) {
        super(message, args);
    }

}
