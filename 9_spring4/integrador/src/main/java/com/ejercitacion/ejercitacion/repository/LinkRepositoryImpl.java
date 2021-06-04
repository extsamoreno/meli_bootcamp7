package com.ejercitacion.ejercitacion.repository;

import com.ejercitacion.ejercitacion.entity.StoredLink;
import com.ejercitacion.ejercitacion.exception.LinkIdNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private List<StoredLink> storedLinks = new ArrayList<>();
    private Integer idAutoincrement = 0;

    @Override
    public StoredLink storeNewLink(StoredLink storedLink) {
       storedLink.setId(++idAutoincrement);
       storedLinks.add(storedLink);
       return storedLink;
    }

    @Override
    public boolean incrementRedirectionCounterById(Integer id) throws LinkIdNotFoundException {
       AtomicBoolean found = new AtomicBoolean(false);
       storedLinks.stream().filter(s -> s.getId() == id).findFirst().ifPresent(s -> {
           s.setRedirectionsCounter(s.getRedirectionsCounter() + 1);
           found.set(true);
            });
       return found.get();
    }

    @Override
    public boolean invalidateLinkById(Integer id) {
        AtomicBoolean found = new AtomicBoolean(false);
        storedLinks.stream().filter(s -> s.getId() == id).findFirst().ifPresent(s -> {
            s.setValid(false);
            found.set(true);
        });
        return found.get();
    }

    @Override
    public StoredLink getStoredLinkById(Integer id) {
        Optional<StoredLink> sl = storedLinks.stream().filter(s -> s.getId() == id).findFirst();
        return sl.orElse(null);
    }
}

