package finalmission.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finalmission.shop.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
