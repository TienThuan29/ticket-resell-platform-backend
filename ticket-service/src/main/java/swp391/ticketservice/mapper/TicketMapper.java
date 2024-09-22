package swp391.ticketservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swp391.entity.Staff;
import swp391.entity.Ticket;
import swp391.entity.User;
import swp391.entity.fixed.GeneralProcess;
import swp391.ticketservice.dto.request.TicketRequest;
import swp391.ticketservice.dto.response.TicketResponse;
import swp391.ticketservice.exception.def.InvalidProcessException;
import swp391.ticketservice.exception.def.NotFoundException;
import swp391.ticketservice.repository.GenericTicketRepository;
import swp391.ticketservice.utils.ImageUtil;
import swp391.userservice.repository.UserRepository;

import java.util.Base64;
import java.util.Optional;

/**
 * Author: Nguyen Nhat Truong
 */
@Component
@RequiredArgsConstructor
public class TicketMapper {

    private final GenericTicketMapper genericTicketMapper;
    private final UserRepository userRepository;
    private final GenericTicketRepository genericTicketRepository;

    public Ticket toEntity(TicketRequest ticketRequest) throws InvalidProcessException {
        Ticket ticket= Ticket
                .builder()
                .ticketSerial(ticketRequest.getTicketSerial())
                .image(ImageUtil.compressImage(ticketRequest.getImage()))
                .isChecked(ticketRequest.isChecked())
                .isBought(ticketRequest.isBought())
                .isValid(ticketRequest.isValid())
                .note(ticketRequest.getNote())
                .process(getProcess(ticketRequest.getProcess())
                        .orElseThrow(() -> new InvalidProcessException(""+ticketRequest.getProcess())))
                .genericTicket(genericTicketRepository.findById(ticketRequest.getGenericTicketId())
                        .orElseThrow(() -> new NotFoundException(""+ticketRequest.getGenericTicketId())))
                .build();
        return  ticket;
    }

    private Optional<GeneralProcess> getProcess(String process){
        try {
            return Optional.ofNullable(GeneralProcess.valueOf(process));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public TicketResponse toResponse(Ticket ticket){
        TicketResponse ticketResponse= TicketResponse
                .builder()
                .ticketSerial(ticket.getTicketSerial())
                .image(Base64.getEncoder().encodeToString(ImageUtil.decompressImage(ticket.getImage())))
                .isChecked(ticket.isChecked())
                .isBought(ticket.isBought())
                .isValid(ticket.isValid())
                .note(ticket.getNote())
                .process(ticket.getProcess().content)
                .boughtDate(ticket.getBoughtDate())
                .genericTicketId(ticket.getGenericTicket().getId())
                .staffId(ticket.getVerifyStaff()==null?null:ticket.getVerifyStaff().getId())
                .buyerId(ticket.getBuyerId())
                .build();
        return ticketResponse;
    }
}
