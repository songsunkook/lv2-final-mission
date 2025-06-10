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

    public void join(UserRequest.Join request) {
        String name = request.name();
        if (name == null) {
            name = "임시"; // 외부 API 호출해서 랜덤 닉네임 지정하기
        }
        userRepository.save(new User(name, request.email(), request.password()));
    }
}
