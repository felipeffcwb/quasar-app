package com.api.approaches.controllers.v1;

import com.api.approaches.entities.Influencer;
import com.api.approaches.exceptions.InfluencerException;
import com.api.approaches.services.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/influencer/")
public class InfluencerController {
    @Autowired
    InfluencerService service;
    @RequestMapping(
            path = "/list",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getInfluencers() throws InfluencerException {
        List<Influencer> influencers = service.getInfluencers();
        ResponseEntity responseEntity = new ResponseEntity(influencers, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/listbyid/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getInfluencerById(@PathVariable Long id) throws InfluencerException {
        Influencer influencer = service.getInfluencerById(id);
        ResponseEntity responseEntity = new ResponseEntity(influencer, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/add/influencer",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity addInfluencer(@RequestBody Influencer influencer) throws InfluencerException {
        service.addInfluencer(influencer);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(
            path = "/delete/influencer/{id}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity deleteInfluencer(@PathVariable Long id) throws InfluencerException{
        service.deleteInfluencer(id);
        return ResponseEntity.noContent().build();
    }
}
