package swp391.ticketservice.service.def;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import swp391.entity.GenericTicket;
import swp391.ticketservice.dto.request.GenericTicketRequest;
import swp391.ticketservice.dto.response.GenericTicketResponse;
import swp391.ticketservice.dto.response.Response;
import swp391.ticketservice.exception.def.BindException;

import java.util.Date;
import java.util.List;

/**
 * Author: Nguyen Nhat Truong
 */
@Service
public interface IGenericTicketService {

    Response<GenericTicketResponse> create(GenericTicketRequest genericTicketRequest);

    Response<?> updatePriceAndExpiredDate(Long id, Long price, Date date);

    Response<List<GenericTicketResponse>> getAll();

    Response<GenericTicketResponse> getById(Long id);
}
