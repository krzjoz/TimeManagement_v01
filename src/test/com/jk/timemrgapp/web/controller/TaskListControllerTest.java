package src.test.com.jk.timemrgapp.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class TaskListControllerTest extends BaseIT{

    @Test
    void showTaskListWhenLoggedIn() throws Exception {
        mockMvc.perform(get("/task/list").with(httpBasic("user", "user")))
                .andExpect(status().isOk());

    }

}