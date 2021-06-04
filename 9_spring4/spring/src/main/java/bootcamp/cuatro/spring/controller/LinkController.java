package bootcamp.cuatro.spring.controller;


import bootcamp.cuatro.spring.exception.LInkUnavailableException;
import bootcamp.cuatro.spring.exception.LinkMalformedSyntaxException;
import bootcamp.cuatro.spring.exception.LinkNotFoundException;
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
    public RedirectView redirect(@PathVariable(name = "linkId") Integer id) throws LinkNotFoundException, LinkMalformedSyntaxException, LInkUnavailableException {
        return iServiceLink.redirectByLinkId(id);
    }


    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<ResponseLinkDTO> getStadistics(@PathVariable(name = "linkId") Integer id) throws LinkNotFoundException, LInkUnavailableException {
        return new ResponseEntity<>(iServiceLink.getStadistics(id),HttpStatus.OK);
    }

    @GetMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponseLinkDTO> invalidate(@PathVariable(name = "linkId") Integer id) throws LinkNotFoundException, LInkUnavailableException {
        return new ResponseEntity<>(iServiceLink.inactivateLink(id),HttpStatus.OK);
    }

    @PostMapping("/password/{linkId}")
    public ResponseEntity<ResponseLinkDTO> addPassword(@PathVariable(name = "linkId") Integer id,@RequestBody LinkDto link) throws LinkNotFoundException, LInkUnavailableException {
        return new ResponseEntity<>(iServiceLink.addPassword(id,link),HttpStatus.OK);
    }
}
