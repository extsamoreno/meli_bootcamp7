package com.meli.API_link_tracker.model.service;

import com.meli.API_link_tracker.model.dto.*;
import com.meli.API_link_tracker.model.exception.*;

public interface ServiceLinkTracker {
    LinkRespond createLinktoDataBase(LinkRequest linkRequest, String password) throws FormatLinkNotValidateException,
            PasswordNotEnteredException, LinkAlreadyCreatedException;
    String getLinkRedired(int linkId) throws LinkAlreadyInvalidatedException, IDNotFoundException;
    int getMetricsOfLink(int linkId) throws IDNotFoundException;
    void invalidateLink(int linkId) throws LinkAlreadyInvalidatedException, IDNotFoundException;
}
