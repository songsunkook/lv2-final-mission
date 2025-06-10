package finalmission.Shop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalmission.Shop.dto.ShopResponse;
import finalmission.Shop.service.ShopService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public ResponseEntity<List<ShopResponse.Simple>> getAll() {
        return ResponseEntity.ok().body(shopService.getAll());
    }
}
