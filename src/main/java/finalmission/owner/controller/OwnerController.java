package finalmission.owner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalmission.auth.UserId;
import finalmission.owner.dto.OwnerRequest;
import finalmission.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @UserId Long userId,
            @RequestBody OwnerRequest.Register request
    ) {
        ownerService.register(userId, request);
        return ResponseEntity.ok().build();
    }
}
