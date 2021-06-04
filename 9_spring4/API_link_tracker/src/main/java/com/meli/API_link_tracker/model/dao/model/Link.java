package com.meli.API_link_tracker.model.dao.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String link;
    private String password;
    private int timeUsed = 0;
    private boolean isValid = true;

    public void increaseTimesUsed() {
        this.timeUsed++;
    }
}
