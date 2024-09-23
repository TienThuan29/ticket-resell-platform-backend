package swp391.ticketservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import swp391.adminservice.repository.PolicyRepository;
import swp391.entity.GenericTicket;
import swp391.entity.User;
import swp391.ticketservice.config.MessageConfiguration;
import swp391.ticketservice.dto.request.GenericTicketRequest;
import swp391.ticketservice.dto.response.GenericTicketResponse;
import swp391.ticketservice.dto.response.Response;
import swp391.ticketservice.exception.def.NotFoundException;
import swp391.ticketservice.mapper.GenericTicketMapper;
import swp391.ticketservice.repository.CategoryRepository;
import swp391.ticketservice.repository.EventRepository;
import swp391.ticketservice.repository.GenericTicketRepository;
import swp391.ticketservice.service.def.IGenericTicketService;
import swp391.userservice.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Nguyen Nhat Truong
 */
@Component
@RequiredArgsConstructor
public class GenericTicketService implements IGenericTicketService {

    private final GenericTicketMapper genericTicketMapper;
    private final MessageConfiguration message;
    private final GenericTicketRepository genericTicketRepository;
    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private CategoryRepository categoryRepository;
    @Override
    public Response<GenericTicketResponse> create(GenericTicketRequest genericTicketRequest) {
        policyRepository.findById(genericTicketRequest.getPolicyId())
                .orElseThrow(() -> new NotFoundException(message.INVALID_POLICY+" :"+genericTicketRequest.getPolicyId()));
        categoryRepository.findById(genericTicketRequest.getCategoryId())
                .orElseThrow(() -> new NotFoundException(message.INVALID_CATEGORY+" :"+genericTicketRequest.getCategoryId()));
        eventRepository.findById(genericTicketRequest.getEventId())
                .orElseThrow(() -> new NotFoundException(message.INVALID_EVENT+" :"+genericTicketRequest.getEventId()));
        User seller= userRepository.findById(genericTicketRequest.getSellerId())
                .orElseThrow(() -> new NotFoundException(message.INVALID_BUYER+" :"+genericTicketRequest.getSellerId()));
        if(seller.getIsSeller())
            throw new NotFoundException(""+seller.getId());
        GenericTicket genericTicket= genericTicketRepository.save(genericTicketMapper.toEntity(genericTicketRequest));
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, genericTicketMapper.toResponse(genericTicket));
    }

    @Override
    public Response<?> updatePriceAndExpiredDate(Long id, Long price, Date date) {
        GenericTicket genericTicket= genericTicketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message.INVALID_GENERICTICKET+" :"+id));
        genericTicket.setPrice(price);
        genericTicket.setExpiredDateTime(date);
        genericTicketRepository.save(genericTicket);
        return new Response<>(HttpStatus.OK,message.SUCCESS_OPERATION, null);
    }

    @Override
    public Response<List<GenericTicketResponse>> getAll() {
        List<GenericTicket> genericTickets = genericTicketRepository.findAll();
        List<GenericTicketResponse> genericTicketResponses= genericTickets.stream()
                .map(genericTicketMapper::toResponse)
                .collect(Collectors.toList());
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, genericTicketResponses);
    }

    @Override
    public Response<GenericTicketResponse> getById(Long id) {
        GenericTicket genericTicket= genericTicketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(message.INVALID_GENERICTICKET+" :"+id));
        return new Response<>(HttpStatus.OK, message.SUCCESS_OPERATION, genericTicketMapper.toResponse(genericTicket));
    }
}
