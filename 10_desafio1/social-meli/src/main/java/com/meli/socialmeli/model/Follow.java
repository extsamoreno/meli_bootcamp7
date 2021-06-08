package com.meli.socialmeli.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private User userFrom;
    private User userTo;
}
