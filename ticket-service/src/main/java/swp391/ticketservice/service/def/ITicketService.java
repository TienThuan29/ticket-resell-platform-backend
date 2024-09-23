package swp391.ticketservice.service.def;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import swp391.ticketservice.dto.request.TicketRequest;
import swp391.ticketservice.dto.response.Response;
import swp391.ticketservice.dto.response.TicketResponse;

import java.io.IOException;
import java.util.List;

/**
 * Author: Nguyen Nhat Truong
 */
@Service
public interface ITicketService {
    Response<List<TicketResponse>> getAll();
    Response<TicketResponse> getById(String id);
    Response<TicketResponse> create(TicketRequest ticketRequest, MultipartFile file) throws IOException;
    Response<?> markBought(String id);
    Response<?> markStaffCheck(String id, Long staffId);
    Response<?> updateProcess(String id, String process);
}
