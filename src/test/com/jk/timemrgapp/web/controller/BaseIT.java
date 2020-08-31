package src.test.com.jk.timemrgapp.web.controller;

import com.jk.timemrgapp.dto.repository.CategoryRepository;
import com.jk.timemrgapp.dto.repository.StatusRepository;
import com.jk.timemrgapp.dto.repository.TaskRepository;
import com.jk.timemrgapp.service.CategoryService;
import com.jk.timemrgapp.service.StatusService;
import com.jk.timemrgapp.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

public abstract class BaseIT {

    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @MockBean
    TaskRepository taskRepository;

    @MockBean
    CategoryRepository categoryRepository;

    @MockBean
    StatusRepository statusRepository;

    @MockBean
    TaskService taskService;

    @MockBean
    CategoryService categoryService;

    @MockBean
    StatusService statusService;


    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

}
