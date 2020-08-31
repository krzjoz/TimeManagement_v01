package src.test.com.jk.timemrgapp.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class LoginControllerTest extends BaseIT {

    @Test
    void shouldGetLoginWithoutCredentials()throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}