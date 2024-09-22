package swp391.ticketservice.controller.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swp391.ticketservice.controller.def.IGenericTicketController;
import swp391.ticketservice.dto.request.GenericTicketRequest;
import swp391.ticketservice.dto.response.GenericTicketResponse;
import swp391.ticketservice.dto.response.Response;
import swp391.ticketservice.service.def.IGenericTicketService;
import swp391.ticketservice.service.impl.GenericTicketService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tickets/generic")
public class GenericTicketController implements IGenericTicketController {

    @Autowired
    private IGenericTicketService genericTicketService;

    @PostMapping("/create")
    @Override
    public Response<GenericTicketResponse> createGenericTicket(
            @RequestBody @Valid GenericTicketRequest genericTicketRequest
    ) {
        return genericTicketService.create(genericTicketRequest);
    }

    @Override
    @PutMapping("/update-price-expired")
    public Response<?> updatePriceAndExpiredDate(
            @RequestParam Long id,
            @RequestParam @Min(value = 0) Long price,
            @RequestParam Date date
    ) {
        return genericTicketService.updatePriceAndExpiredDate(id, price, date);
    }

    @GetMapping("/get-all")
    @Override
    public Response<List<GenericTicketResponse>> getAll() {
        return genericTicketService.getAll();
    }

    @GetMapping("/get/{id}")
    @Override
    public Response<GenericTicketResponse> getById(@PathVariable Long id) {
        return genericTicketService.getById(id);
    }

}
