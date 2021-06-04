package com.meli.API_link_tracker.controller;

import com.meli.API_link_tracker.model.dto.LinkRequest;
import com.meli.API_link_tracker.model.dto.LinkRespond;
import com.meli.API_link_tracker.model.service.ServiceLinkTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class LinkTrackerController {
    @Autowired
    private ServiceLinkTracker serviceLinkTracker;

    @PostMapping("/create")
    public LinkRespond createLink(@RequestBody LinkRequest linkRequest, @RequestParam String password) {
        return serviceLinkTracker.createLinktoDataBase(linkRequest, password); // pendiente implementar el error
    }

    @GetMapping("/link/{linkId}")
    public ModelAndView redirecLink(@PathVariable int linkId) {
        return new ModelAndView("redirect:" + serviceLinkTracker.getLinkRedired(linkId)); // Falta implementar los errores
    }
    /*Crear un EndPoint tipo Get (/link/{linkId})
    * debe ir a la base de datos y sumarle una unidad a vecesUsado y responder con la redirección del link
    * tener en cuenta que el link debe tener true en esValido, sino, retornar 404
    * return "redirect:/linkARedireccionar";
     */

    @GetMapping("/metrics/{linkId}")
    public int getMetrics(@PathVariable int linkId) {
        return serviceLinkTracker.getMetricsOfLink(linkId);
    }
    /* Crear un EndPoint tipo Get (/metrics/{linkId})
    * debe ir a buscar a la base de datos con el id y retornar vecesUsado
     */

    @PostMapping("/invalidate/{linkId}")
    public String createLink(@PathVariable int linkId) {
        if (serviceLinkTracker.invalidateLink(linkId)) {
            return "Link invalidated";
        } else {
            return "Link not invalidated";
        }
    }
    /* Crear un EndPoint tipo Post (/invalidate/{linkID})
    * debe solicitar el password como query param, ir a la base de datos, si existe revisar que el password sea correcto
    * si todo esta ok debe que cambiar esValido a false
     */
}
