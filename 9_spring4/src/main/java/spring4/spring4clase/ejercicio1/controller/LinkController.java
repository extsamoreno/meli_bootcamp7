package spring4.spring4clase.ejercicio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import spring4.spring4clase.ejercicio1.domain.Link;
import spring4.spring4clase.ejercicio1.response.LinkResponse;
import spring4.spring4clase.ejercicio1.response.ViewsResponse;
import spring4.spring4clase.ejercicio1.service.ILinkService;
import spring4.spring4clase.ejercicio1.service.dto.LinkDTO;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService linkService;


    @PostMapping("/save")
    public ResponseEntity<LinkResponse> saveLink(@RequestBody LinkDTO linkDTO, @RequestParam String password){
        LinkResponse respuesta = linkService.crearLink(linkDTO,password);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Link>> showLink(){
        return new ResponseEntity<>(linkService.getLinkList(), HttpStatus.CREATED);
    }
    @GetMapping("/{linkid}")
    public RedirectView redirect(@PathVariable int linkid, @RequestParam String password){
        linkService.setView(linkid);
        return linkService.redirect(linkid);
    }
    @GetMapping("/metrics/{linkid}")
    public ResponseEntity<ViewsResponse> getMetrics(@PathVariable int linkid){
        ViewsResponse response = new ViewsResponse(linkid,linkService.getLinkById(linkid).getLink(),linkService.getView(linkid));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}

