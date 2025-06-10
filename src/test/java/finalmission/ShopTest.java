package finalmission;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import finalmission.shop.dto.ShopResponse;
import finalmission.shop.repository.ShopRepository;

@SpringBootTest
@DirtiesContext
@AutoConfigureMockMvc
@Sql("/data.sql")
class ShopTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAll() throws Exception {
        // when
        String responseBody = mockMvc.perform(get("/shops")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        ShopResponse.Simple[] response = objectMapper.readValue(responseBody, ShopResponse.Simple[].class);

        // then
        assertThat(response).hasSize(DataConstant.SHOP_COUNT);
    }

    @Test
    void getDetail() throws Exception {
        // given
        Long shopId = 1L;

        // when
        String responseBody = mockMvc.perform(get("/shops/" + shopId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        ShopResponse.Detail response = objectMapper.readValue(responseBody, ShopResponse.Detail.class);

        // then
        assertThat(response.id()).isEqualTo(shopId);
    }

    @Test
    void getAvailableTime() throws Exception {
        // given
        Long shopId = 1L;

        // when
        String responseBody = mockMvc.perform(get("/shops/" + shopId + "/times")
                        .param("date", "2025-06-10")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        LocalTime[] response = objectMapper.readValue(responseBody, LocalTime[].class);

        // then
        assertThat(response[0]).isEqualTo(LocalTime.of(12, 0));
    }
}
