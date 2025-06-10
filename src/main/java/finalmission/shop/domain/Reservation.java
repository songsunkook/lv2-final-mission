package finalmission.shop.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import finalmission.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "reservation")
    private List<ShopReservation> shopReservation = new ArrayList<>();

    private LocalDate date;

    private LocalTime time;

    public Reservation(User user, List<ShopReservation> shopReservation, LocalDate date, LocalTime time) {
        this.user = user;
        this.shopReservation = shopReservation;
        this.date = date;
        this.time = time;
    }
}
