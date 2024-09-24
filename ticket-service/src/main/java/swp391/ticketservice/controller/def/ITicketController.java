package swp391.ticketservice.controller.def;

import org.springframework.web.multipart.MultipartFile;
import swp391.ticketservice.dto.request.TicketRequest;
import swp391.ticketservice.dto.response.ApiResponse;
import swp391.ticketservice.dto.response.TicketResponse;
import java.io.IOException;
import java.util.List;

public interface ITicketController {
    ApiResponse<List<TicketResponse>> getAll();
    ApiResponse<TicketResponse> getById(String id);
    ApiResponse<TicketResponse> create(TicketRequest ticketRequest, MultipartFile file) throws IOException;
    ApiResponse<?> markBought(String id);
    ApiResponse<?> markStaffCheck(String id, Long staffId);
    ApiResponse<?> updateProcess(String id, String process);
}
