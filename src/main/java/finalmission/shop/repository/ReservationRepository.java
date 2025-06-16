package finalmission.shop.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import finalmission.shop.domain.Reservation;
import finalmission.shop.domain.Shop;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    boolean existsByShopAndDateAndTime(Shop shop, LocalDate date, LocalTime time);
}
