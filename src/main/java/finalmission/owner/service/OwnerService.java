package finalmission.owner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalmission.owner.domain.Owner;
import finalmission.owner.dto.OwnerRequest;
import finalmission.owner.repository.OwnerRepository;
import finalmission.user.domain.User;
import finalmission.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OwnerService {

    private final UserRepository userRepository;
    private final OwnerRepository ownerRepository;

    @Transactional
    public void register(Long userId, OwnerRequest.Register request) {
        User user = userRepository.getById(userId);
        ownerRepository.save(new Owner(user, request.businessLicenseUrl(), request.businessRegistrationNumber()));
    }
}
