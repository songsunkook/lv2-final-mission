package finalmission.util.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NameGeneratorClient {

    private final String apiKey;
    private final RestClient restClient;
    // private final ObjectMapper objectMapper;

    public NameGeneratorClient(
            @Value("${client.name_gen.api_key}") String apiKey,
            RestClient restClient//,
            // ObjectMapper objectMapper
    ) {
        this.apiKey = apiKey;
        this.restClient = restClient;
        // this.objectMapper = objectMapper;
    }

    public List<String> getNames(int amount) {
        ResponseEntity<String[]> response = restClient.get()
                .uri("https://randommer.io/api/Name?nameType=fullname&quantity=" + amount)
                .header("X-Api-Key", apiKey)
                .retrieve()
                .toEntity(String[].class);

        return Arrays.asList(response.getBody());
    }
}
