package swp391.ticketservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swp391.ticketservice.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
}
