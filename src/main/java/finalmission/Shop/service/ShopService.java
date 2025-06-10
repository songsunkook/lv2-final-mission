package finalmission.Shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalmission.Shop.dto.ShopResponse;
import finalmission.Shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopService {

    private final ShopRepository shopRepository;

    public List<ShopResponse.Simple> getAll() {
        return shopRepository.findAll().stream()
                .map(ShopResponse.Simple::new)
                .toList();
    }

    public ShopResponse.Detail getDetail(Long id) {
        return new ShopResponse.Detail(shopRepository.getById(id));
    }
}
