package com.movies.demoHQL.model.DTO;

import com.movies.demoHQL.model.DTO.ActorDTO;
import com.movies.demoHQL.model.DTO.MovieDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorMovieResponceDTO {

    ActorDTO actor;
    MovieDTO favoriteMovie;
}
