package swp391.ticketservice.controller.def;

import swp391.ticketservice.dto.request.GenericTicketRequest;
import swp391.ticketservice.dto.response.GenericTicketResponse;
import swp391.ticketservice.dto.response.Response;

import java.util.Date;
import java.util.List;

public interface IGenericTicketController {

    Response<GenericTicketResponse> createGenericTicket(GenericTicketRequest genericTicketRequest);

    Response<?> updatePriceAndExpiredDate(Long id, Long price, Date date);

    Response<List<GenericTicketResponse>> getAll();

    Response<GenericTicketResponse> getById(Long id);
}
