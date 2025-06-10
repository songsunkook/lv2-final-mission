package finalmission.Shop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import finalmission.Shop.domain.Shop;

public interface ShopRepository extends CrudRepository<Shop, Long> {

    List<Shop> findAll();
}
