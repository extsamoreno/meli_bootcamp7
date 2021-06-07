package com.example.LinkTracker.controller;
import com.example.LinkTracker.exceptions.ExistentLinkException;
import com.example.LinkTracker.exceptions.InvalidLinkException;
import com.example.LinkTracker.service.dto.RequestUrlNewDTO;
import com.example.LinkTracker.service.dto.ResponseMetricDTO;
import com.example.LinkTracker.service.dto.ResponseUrlEnmascar;
import com.example.LinkTracker.service.dto.ResponseUrlNewDTO;
import com.example.LinkTracker.service.LinkAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newlink")
public class NewLink {

    @Autowired
    LinkAddService iLinkService;


    @PostMapping("/url")
    public ResponseEntity<ResponseUrlNewDTO> setUrl(@RequestBody RequestUrlNewDTO requesturl) throws ExistentLinkException, InvalidLinkException {
        ResponseUrlNewDTO response = new ResponseUrlNewDTO();
        response.setId(iLinkService.saveUrlNew(requesturl).getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/url/{value}")
    public ResponseUrlEnmascar getUrl(@PathVariable Integer value){
        ResponseUrlEnmascar response = new ResponseUrlEnmascar();
        response.setValue(iLinkService.getUrl(value).getValue());
        return  response;
    }
    @GetMapping("/metric/{value}")
    public ResponseMetricDTO getMetricUrl(@PathVariable Integer value){
        return  iLinkService.getMetric(value);
    }

    @PostMapping("/url/invalidate/{value}")
    public boolean inalidateUrl(@PathVariable Integer value){

        return iLinkService.disableUrl(value);
    }
}
