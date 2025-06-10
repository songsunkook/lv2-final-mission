package finalmission.Shop.dto;

import finalmission.Shop.domain.Shop;
import finalmission.Shop.domain.ShopType;

public class ShopResponse {

    private ShopResponse() {
    }

    public record Simple(
            Long id,
            String name,
            ShopType type
    ) {

        public Simple(Shop shop) {
            this(shop.getId(), shop.getName(), shop.getType());
        }
    }
}
