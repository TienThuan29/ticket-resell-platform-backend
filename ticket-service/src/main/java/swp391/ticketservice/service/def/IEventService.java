package swp391.ticketservice.service.def;

import swp391.ticketservice.dto.request.*;
import org.springframework.web.multipart.MultipartFile;
import swp391.ticketservice.dto.response.ApiResponse;
import java.io.IOException;

public interface IEventService {

    ApiResponse<?> createEvent(EventRequest eventRequest, MultipartFile file) throws IOException;

    ApiResponse<?> getAllEvent();

}
