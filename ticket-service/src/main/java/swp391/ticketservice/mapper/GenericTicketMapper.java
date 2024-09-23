package swp391.ticketservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swp391.adminservice.repository.PolicyRepository;
import swp391.entity.GenericTicket;
import swp391.ticketservice.dto.request.GenericTicketRequest;
import swp391.ticketservice.dto.response.GenericTicketResponse;
import swp391.ticketservice.exception.def.NotFoundException;
import swp391.ticketservice.repository.CategoryRepository;
import swp391.ticketservice.repository.EventRepository;
import swp391.userservice.repository.UserRepository;

/**
 * Author: Nguyen Nhat Truong
 */
@Component
@RequiredArgsConstructor
public class GenericTicketMapper {

    private final PolicyRepository policyRepository;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    private final EventRepository eventRepository;
    public GenericTicket toEntity(GenericTicketRequest genericTicketRequest){

        GenericTicket genericTicket= GenericTicket
                .builder()
                .ticketName(genericTicketRequest.getGenericTicketName())
                .price(genericTicketRequest.getPrice())
                .salePercent(genericTicketRequest.getSalePercent())
                .area(genericTicketRequest.getArea())
                .expiredDateTime(genericTicketRequest.getExpiredDateTime())
                .description(genericTicketRequest.getDescription())
                .linkEvent(genericTicketRequest.getLinkEvent())
                .isPaper(genericTicketRequest.isPaper())
                .policy(policyRepository.findById(genericTicketRequest.getPolicyId())
                        .orElseThrow(() -> new NotFoundException(""+genericTicketRequest.getPolicyId())))
                .event(eventRepository.findById((genericTicketRequest.getEventId()))
                        .orElseThrow(() -> new NotFoundException(""+genericTicketRequest.getEventId())))
                .category(categoryRepository.findById(genericTicketRequest.getCategoryId())
                        .orElseThrow(() -> new NotFoundException(""+genericTicketRequest.getCategoryId())))
                .seller(userRepository.findById(genericTicketRequest.getSellerId())
                        .orElseThrow(() -> new NotFoundException(""+genericTicketRequest.getSellerId())))
                .build();
        return genericTicket;
    }

    public GenericTicketResponse toResponse(GenericTicket genericTicket){
        GenericTicketResponse genericTicketResponse= GenericTicketResponse
                .builder()
                .id(genericTicket.getId())
                .ticketName(genericTicket.getTicketName())
                .price(genericTicket.getPrice())
                .salePercent(genericTicket.getSalePercent())
                .area(genericTicket.getArea())
                .expiredDateTime(genericTicket.getExpiredDateTime())
                .linkEvent(genericTicket.getLinkEvent())
                .description(genericTicket.getDescription())
                .isPaper(genericTicket.isPaper())
                .policyName(genericTicket.getPolicy().getContent())
                .categoryName(genericTicket.getCategory().getName())
                .eventName(genericTicket.getEvent().getName())
                .sellerName(genericTicket.getSeller().getFirstname()+genericTicket.getSeller().getLastname())
                .build();
        return genericTicketResponse;
    }
}
