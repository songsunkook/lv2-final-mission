package finalmission.owner.dto;

public class OwnerRequest {

    public record Register(
            String businessLicenseUrl,
            String businessRegistrationNumber
    ) {

    }
}
