package bootcamp.cuatro.spring.controller;


import bootcamp.cuatro.spring.service.IServiceLink;
import bootcamp.cuatro.spring.service.dto.LinkDto;
import bootcamp.cuatro.spring.service.dto.ResponseLinkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    IServiceLink iServiceLink;


    @PostMapping("/tracker")
    public ResponseEntity<ResponseLinkDTO> createLink(@RequestBody LinkDto link){
        return new ResponseEntity<>(iServiceLink.createLink(link), HttpStatus.OK);
    }


    @GetMapping("/redirect/{linkId}")
    public RedirectView redirect(@PathVariable(name = "linkId") Integer id){
        return iServiceLink.redirectByLinkId(id);
    }
}
