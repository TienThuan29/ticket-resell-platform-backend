package swp391.ticketservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Author: Nguyen Nhat Truong
 */
@Data
@Builder
public class TicketRequest {
    @JsonProperty("ticketSerial")
    @NotEmpty(message = "Số seri của vé không được phép trống")
    private String ticketSerial;

    @JsonProperty("image")
    private byte[] image;

//    @JsonProperty("isChecked")
//    private boolean isChecked;
//
//    @JsonProperty("isBought")
//    private boolean isBought;
//
//    @JsonProperty("isValid")
//    private boolean isValid;

    @JsonProperty("note")
    private String note;

//    @JsonProperty("process")
//    private String process;

    @JsonProperty("genericTicketId")
    private Long genericTicketId;

//    @JsonProperty("buyerId")
//    private Long buyerId;
//
//    @JsonProperty("boughtDate")
//    private Date boughtDate;
//
//    @JsonProperty("staffId")
//    private Long staffId;
}
