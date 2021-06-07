package linktracker.demo.Model.DTO;

import lombok.Data;

@Data
public class LinkMetricsDTO {
    int numberOfRedirects;
    int linkId;

    public LinkMetricsDTO(int numberOfRedirects, int linkId) {
        this.numberOfRedirects = numberOfRedirects;
        this.linkId = linkId;
    }
}
