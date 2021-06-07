package linktracker.demo.Controller;

import linktracker.demo.Exception.*;
import linktracker.demo.Model.DTO.LinkCreateRequestDTO;
import linktracker.demo.Model.DTO.LinkCreateResponseDTO;
import linktracker.demo.Model.DTO.LinkMetricsDTO;
import linktracker.demo.Service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/linktracker")
public class LinkTrackerController {

    ILinkService iLinkService;

    public LinkTrackerController(ILinkService iLinkService) {
        this.iLinkService = iLinkService;
    }

    @PostMapping
    @RequestMapping("/addlink")
    public ResponseEntity<LinkCreateResponseDTO> addLink(@RequestBody LinkCreateRequestDTO link) throws LinkAlreadyPresentException, InvalidURLException {
        return new ResponseEntity<>(iLinkService.addLink(link), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/link/{id}")
    public RedirectView goTo(@PathVariable String id, @RequestParam(required = false) String password) throws LinkNotFoundException, InvalidIdException, WrongPasswordException, InvalidatedLinkException {
        return new RedirectView(iLinkService.getLinkForRedirect(id, password));
    }

    @GetMapping
    @RequestMapping("/metrics/{id}")
    public ResponseEntity<LinkMetricsDTO> getMetrics(@PathVariable String id) throws InvalidIdException, LinkNotFoundException {
        return new ResponseEntity<>(iLinkService.getMetricsById(id),HttpStatus.OK);
    };

    @PostMapping
    @RequestMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidateLink(@PathVariable String id) throws InvalidIdException, LinkNotFoundException {
        return new ResponseEntity<>(iLinkService.invalidateById(id),HttpStatus.OK);
    }


}
