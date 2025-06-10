package finalmission.Shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import finalmission.Shop.dto.ShopResponse;
import finalmission.Shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public List<ShopResponse.Simple> getAll() {
        return shopRepository.findAll().stream()
                .map(ShopResponse.Simple::new)
                .toList();
    }
}
