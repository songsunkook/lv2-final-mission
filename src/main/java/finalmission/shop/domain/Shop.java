package finalmission.shop.domain;

import java.util.ArrayList;
import java.util.List;

import finalmission.owner.domain.Owner;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ShopType type;

    private String detail;

    @OneToMany(mappedBy = "shop")
    private List<OperatingHour> operatingHours = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Owner owner;
}
