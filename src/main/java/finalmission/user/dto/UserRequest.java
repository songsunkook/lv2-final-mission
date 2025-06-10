package finalmission.user.dto;

public class UserRequest {

    private UserRequest() {
    }

    public record Login(
            String email,
            String password
    ) {

    }
}
