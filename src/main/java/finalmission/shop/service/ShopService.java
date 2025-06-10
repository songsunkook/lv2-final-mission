package finalmission.shop.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalmission.shop.domain.OperatingHour;
import finalmission.shop.dto.ReservationResponse;
import finalmission.shop.dto.ShopResponse;
import finalmission.shop.repository.OperatingHourRepository;
import finalmission.shop.repository.ReservationRepository;
import finalmission.shop.repository.ShopRepository;
import finalmission.user.domain.User;
import finalmission.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopService {

    private final ShopRepository shopRepository;
    private final OperatingHourRepository operatingHourRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public List<ShopResponse.Simple> getAll() {
        return shopRepository.findAll().stream()
                .map(ShopResponse.Simple::new)
                .toList();
    }

    public ShopResponse.Detail getDetail(Long id) {
        return new ShopResponse.Detail(shopRepository.getById(id));
    }

    public List<LocalTime> getAvailableTime(Long shopId, LocalDate date) {
        List<OperatingHour> operatingHour = operatingHourRepository.findAllByShopIdAndDayOfWeek(
                shopId, date.getDayOfWeek());
        if (operatingHour.isEmpty()) {
            return List.of();
        }

        // TODO 예약 테이블에서 꺼내와서 계산 필요

        return operatingHour.stream()
                .map(OperatingHour::getTime)
                .toList();
    }

    // TODO 구현 중 ..
    public ReservationResponse.Created reserve(Long userId, Long shopId, LocalDate date, LocalTime time) {
        User user = userRepository.getById(userId);
        // new Reservation(user, date, time);
        // reservationRepository.save(null);
        return null;
    }
}
