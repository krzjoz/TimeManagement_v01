package src.test.com.jk.timemrgapp.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RegistrationControllerTest extends BaseIT{

    @Test
    void shouldGetRegisterPageWithoutCredentials() throws Exception{
        mockMvc.perform(get("/user/register"))
                .andExpect(status().isOk());

    }

}