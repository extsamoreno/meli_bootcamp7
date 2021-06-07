package linktracker.demo.Model.DTO;

import lombok.Data;

@Data
public class LinkCreateResponseDTO {
    int LinkId;

    public LinkCreateResponseDTO(int linkId) {
        LinkId = linkId;
    }
}
