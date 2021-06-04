package com.spring8tarde.demo.Controler;


import com.spring8tarde.demo.Model.DTO.CharacterDTOIN;
import com.spring8tarde.demo.Model.DTO.CharacterDTOOUT;
import com.spring8tarde.demo.Service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CharacterControler{

    @Autowired
    ICharacterService iCharacterService;

    @PostMapping("/getCharacter")
    public ArrayList<CharacterDTOOUT> getCharacter(@RequestBody CharacterDTOIN characterDTOIN) throws IOException {
        return iCharacterService.getCharacter(characterDTOIN);
    }
}
