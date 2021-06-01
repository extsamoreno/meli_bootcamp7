package com.primerSpring.SpringArtifact;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gettings")
public class GettingController {

    @GetMapping("/convertToRoman/{num}") //@PostMapping, etc.
    public String convertToRoman(@PathVariable int num){ //@PathVariable("name") String namePerson
        return Roman.convert(num);
    }

    @GetMapping("/morseToText/{codigo}")
    public String convertToRoman(@PathVariable String codigo){
        return Morse.toText(codigo);
    }

}
