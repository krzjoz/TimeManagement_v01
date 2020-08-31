package com.jk.timemrgapp.web.controller;

import com.jk.timemrgapp.service.CategoryService;
import com.jk.timemrgapp.service.StatusService;
import com.jk.timemrgapp.service.TaskService;
import com.jk.timemrgapp.service.UserService;
import com.jk.timemrgapp.web.helper.Utils;
import com.jk.timemrgapp.web.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Controller
@RequestMapping("/new")
public class AddNewTaskController {

    private static final Logger LOGGER = Logger.getLogger(TaskListController.class.getName());

    private TaskService defaultTaskService;
    private StatusService defaultStatusService;
    private CategoryService defaultCategoryService;
    private UserService defaultUserService;

    @Autowired
    public AddNewTaskController(TaskService defaultTaskService,
                                StatusService defaultStatusService,
                                CategoryService defaultCategoryService,
                                UserService defaultUserService) {
        this.defaultTaskService = defaultTaskService;
        this.defaultStatusService = defaultStatusService;
        this.defaultCategoryService = defaultCategoryService;
        this.defaultUserService = defaultUserService;
    }

    @GetMapping("/add-task")
    public String getNewTaskPage(ModelMap modelMap) {

        modelMap.addAttribute("newTask", new TaskModel());
        modelMap.addAttribute("categoryList", defaultCategoryService.findAllByCategoryIdIsNot(1));
        modelMap.addAttribute("statusList", defaultStatusService.findAllByStatusIdIsNot(1));

        return "newtask";
    }


    @PostMapping("/save")
    public String saveNewTask(@ModelAttribute("newTask") TaskModel taskModel) {

        taskModel.setUserId(defaultUserService.findUserIdByUsername(Utils.getUsername()));
        taskModel.setTaskAddDate(LocalDateTime.now());
        defaultTaskService.save(taskModel);

        return "taskadded";
    }
}