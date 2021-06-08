package com.api.apiMask.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlDTO {
    String url;

    @Nullable
    String password;
}
