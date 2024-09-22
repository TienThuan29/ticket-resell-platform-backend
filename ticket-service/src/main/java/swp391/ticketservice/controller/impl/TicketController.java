package swp391.ticketservice.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import swp391.ticketservice.controller.def.ITicketController;
import swp391.ticketservice.dto.request.TicketRequest;
import swp391.ticketservice.dto.response.Response;
import swp391.ticketservice.dto.response.TicketResponse;
import swp391.ticketservice.service.def.ITicketService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController implements ITicketController {
    private final ITicketService ticketService;

    @GetMapping("/get-all")
    @Override
    public Response<List<TicketResponse>> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/get/{id}")
    @Override
    public Response<TicketResponse> getById(@PathVariable String id) {
        return ticketService.getById(id);
    }

    @PostMapping("/create")
    @Override
    public Response<TicketResponse> create(
            @RequestPart("ticketRequest") @Valid TicketRequest ticketRequest,
            @RequestPart("file") MultipartFile file
            ) throws IOException {

        return ticketService.create(ticketRequest, file);
    }

    @PutMapping("/mark-bought/{id}")
    @Override
    public Response<?> markBought(@PathVariable String id) {
        return ticketService.markBought(id);
    }

    @PutMapping("/mark-staff-check/{id}/{staffId}")
    @Override
    public Response<?> markStaffCheck(@PathVariable String id, @PathVariable Long staffId) {
        return ticketService.markStaffCheck(id, staffId);
    }

    @PutMapping("/update-process/{id}")
    @Override
    public Response<?> updateProcess(@PathVariable String id, @RequestParam String process) {
        return ticketService.updateProcess(id, process);
    }
}
