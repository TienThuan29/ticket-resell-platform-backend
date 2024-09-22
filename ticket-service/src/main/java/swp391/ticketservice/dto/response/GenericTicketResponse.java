package swp391.ticketservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class GenericTicketResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("ticketName")
    private String ticketName;

    @JsonProperty("price")
    private Long price;

    @JsonProperty("salePercent")
    private Double salePercent;

    @JsonProperty("area")
    private String area;

    @JsonProperty("expiredDateTime")
    private Date expiredDateTime;

    @JsonProperty("description")
    private String description;

    @JsonProperty("linkEvent")
    private String linkEvent;

    @JsonProperty("isPaper")
    private boolean isPaper;

    @JsonProperty("policyName")
    private String policyName;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("eventName")
    private String eventName;

    @JsonProperty("sellerName")
    private String sellerName;
}
