package finalmission.user.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import finalmission.auth.JwtProvider;
import finalmission.user.domain.User;
import finalmission.user.dto.UserRequest;
import finalmission.user.dto.UserResponse;
import finalmission.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public UserResponse.Login login(UserRequest.Login request) {
        User user = userRepository.getByEmail(request.email());

        if (!Objects.equals(user.getPassword(), request.password())) {
            throw new IllegalArgumentException("잘못된 이메일 또는 비밀번호입니다.");
        }

        return new UserResponse.Login(jwtProvider.createToken(user));
    }
}
