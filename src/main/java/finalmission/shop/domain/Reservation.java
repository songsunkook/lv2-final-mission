package finalmission.shop.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import finalmission.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    // @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    // private List<ShopReservation> shopReservation = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private LocalDate date;

    private LocalTime time;

    public Reservation(User user, LocalDate date, LocalTime time, Shop shop) {
        this.user = user;
        this.date = date;
        this.time = time;
        // shopReservation.add(new ShopReservation(shop, this));
        this.shop = shop;
    }
}
