package project.starwarsapi.project.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.starwarsapi.project.repository.StarwarsCharacter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarwarsResponseDTO {
ArrayList<String> nameList = new ArrayList<>();
}
