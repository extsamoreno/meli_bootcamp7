package com.example.demo.repository;

import com.example.demo.controller.exception.ExistLinkException;
import com.example.demo.controller.exception.NotFoundLinkException;
import com.example.demo.services.DTO.LinkDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Repository
public class LinkTackerRepository implements ILinkTackerRepository{

    private HashMap<String,LinkDTO> linkRepository ;
    private HashMap<String,Integer> linkStatistics;

    public LinkTackerRepository(){
        this.linkRepository = new HashMap<>();
        this.linkStatistics = new HashMap<>();
    }

    @Override
    public LinkDTO newLink(LinkDTO linkDTO) throws ExistLinkException {

        String key = randomString(5);
        if (existLinkDTO(linkDTO))
            throw new ExistLinkException(linkDTO.getUrl(),getKeysByValue(linkDTO).getLinkId());
        linkRepository.put(key,linkDTO);
        linkDTO.setLinkId(key);

        return linkDTO;
    }

    @Override
    public LinkDTO localRedirect(String linkId) throws NotFoundLinkException {
        LinkDTO linkDTO = null;
        linkDTO = this.linkRepository.get(linkId);
        if (linkDTO == null)
            throw new NotFoundLinkException(linkId);

        return linkDTO;
    }

    @Override
    public void addRegister(String linkId){
        if (!this.linkStatistics.containsKey(linkId))
            this.linkStatistics.put(linkId,1);
        else
            this.linkStatistics.put(linkId, this.linkStatistics.get(linkId) +1);
    }

    @Override
    public Integer metrics(String linkId) {
        return this.linkStatistics.get(linkId);
    }

    private String randomString(int size) {
        String bank = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String generateString = "";
        for (int x = 0; x < size; x++) {
            int randomIndex = randomNumberRange(0, bank.length() - 1);
            char caracterAleatorio = bank.charAt(randomIndex);
            generateString += caracterAleatorio;
        }
        return generateString;
    }

    private int randomNumberRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private LinkDTO getKeysByValue( LinkDTO linkDTO) {
        LinkDTO linkExist = new LinkDTO();
        for (Map.Entry<String, LinkDTO> entry: this.linkRepository.entrySet()) {
            if (entry.getValue().getUrl().equals(linkDTO.getUrl()))
                linkExist.setLinkId(entry.getValue().getLinkId());
        }
        return linkExist;
    }
    
    private boolean existLinkDTO (LinkDTO linkDTO){
        boolean exist = false;
        for (Map.Entry<String,LinkDTO> entry: this.linkRepository.entrySet()) {
            if(entry.getValue().getUrl().equals(linkDTO.getUrl()))
                exist = true;
        }
        return exist;
    }
}
