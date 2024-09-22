package swp391.ticketservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import swp391.adminservice.repository.StaffRepository;
import swp391.entity.Ticket;
import swp391.entity.fixed.GeneralProcess;
import swp391.ticketservice.config.MessageConfiguration;
import swp391.ticketservice.dto.request.TicketRequest;
import swp391.ticketservice.dto.response.Response;
import swp391.ticketservice.dto.response.TicketResponse;
import swp391.ticketservice.exception.def.InvalidProcessException;
import swp391.ticketservice.exception.def.NotFoundException;
import swp391.ticketservice.mapper.TicketMapper;
import swp391.ticketservice.repository.TicketRepository;
import swp391.ticketservice.service.def.ITicketService;
import swp391.ticketservice.utils.ImageUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Author: Nguyen Nhat Truong
 */
@Component
@RequiredArgsConstructor
public class TicketService implements ITicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final StaffRepository staffRepository;
    private final MessageConfiguration message;
    @Override
    public Response<List<TicketResponse>> getAll() {
        List<Ticket> tickets= ticketRepository.findAll();
        List<TicketResponse> ticketResponses= tickets.stream()
                .map(ticketMapper::toResponse)
                .collect(Collectors.toList());
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, ticketResponses);
    }

    @Override
    public Response<TicketResponse> getById(String id) {
        Ticket ticket= ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message.INVALID_TICKET+" :"+id));
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, ticketMapper.toResponse(ticket));
    }

    @Override
    public Response<TicketResponse> create(TicketRequest ticketRequest, MultipartFile file) throws IOException {
        ticketRequest.setProcess(GeneralProcess.WAITING.toString());
        ticketRequest.setImage(file.getBytes());

        Ticket ticket= ticketMapper.toEntity(ticketRequest);
        ticketRepository.save(ticket);
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, ticketMapper.toResponse(ticket));
    }

    @Override
    public Response<?> markBought(String id) {
        Ticket ticket= ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message.INVALID_TICKET+" :"+id));
        ticket.setBought(Boolean.TRUE);
        ticketRepository.save(ticket);
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, null);
    }

    @Override
    public Response<?> markStaffCheck(String id, Long staffId) {
        Ticket ticket= ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message.INVALID_TICKET+" :"+id));
        ticket.setChecked(Boolean.TRUE);
        ticket.setVerifyStaff(staffRepository.findById(staffId)
                .orElseThrow(() -> new NotFoundException(message.INVALID_STAFF+" :"+id)));
        ticketRepository.save(ticket);
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, null);
    }

    @Override
    public Response<?> updateProcess(String id, String process) {
        Ticket ticket= ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message.INVALID_TICKET+" :"+id));
        ticket.setProcess(getProcess(process)
                .orElseThrow(() -> new InvalidProcessException(message.INVALID_PROCESS+" :"+process)));
        return new Response<>(HttpStatus.OK,message.SUCCESS_OPERATION,null);
    }
    private Optional<GeneralProcess> getProcess(String process){
        try {
            return Optional.ofNullable(GeneralProcess.valueOf(process));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
