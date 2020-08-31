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
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static com.jk.timemrgapp.web.controller.ControllerConstants.SESSION_END_VIEW_NAME;

@Controller
@RequestMapping("/task")
@SessionAttributes({"taskModel", SESSION_END_VIEW_NAME})
public class TaskListController {

    private static final Logger LOGGER = Logger.getLogger(TaskListController.class.getName());

    private boolean reset = true;

    TaskModel taskModel = new TaskModel();

    private TaskService defaultTaskService;
    private StatusService defaultStatusService;
    private CategoryService defaultCategoryService;
    private UserService defaultUserService;

    @Autowired
    public TaskListController(TaskService defaultTaskService,
                              StatusService defaultStatusService,
                              CategoryService defaultCategoryService,
                              UserService defaultUserService) {
        this.defaultTaskService = defaultTaskService;
        this.defaultStatusService = defaultStatusService;
        this.defaultCategoryService = defaultCategoryService;
        this.defaultUserService = defaultUserService;
    }

    @RequestMapping("/list")
    public String getTaskList(ModelMap modelMap) {

        modelMap.addAttribute("taskModel", taskModel);
        modelMap.addAttribute("categoryList", defaultCategoryService.findAllByCategoryIdIsNot(1));
        modelMap.addAttribute("statusList", defaultStatusService.findAllByStatusIdIsNot(1));

        String username = Utils.getUsername();
        String role = Utils.getUserRole();

        Long userId = defaultUserService.findUserIdByUsername(Utils.getUsername());

        if (role.contains("USER")) {
            if (reset == true) {
                modelMap.addAttribute("taskList", defaultTaskService.findAllByUserUserId(userId));
            } else {
                modelMap.addAttribute("taskList", defaultTaskService.findByUserStatusCategory(userId,
                        taskModel.getStatusId(), taskModel.getCategoryId()));
            }
        } else {
            if (reset == true) {
                modelMap.addAttribute("taskList", defaultTaskService.findAll());
            } else {
                modelMap.addAttribute("taskList", defaultTaskService.findAllByStatusAndCategory(
                        taskModel.getStatusId(), taskModel.getCategoryId()));
            }
        }
        return "tasklist";
    }


    @PostMapping("/filter")
    public String refineCriteria(@ModelAttribute("taskModel") TaskModel taskModel, ModelMap modelMap) {

        reset = false;
        taskModel.getStatusId();
        taskModel.getCategoryId();

        return "redirect:/task/list";
    }


    @PostMapping("/reset")
    public String resetCriteria(@ModelAttribute("taskList") TaskModel taskModel, ModelMap modelMap) {
        reset = true;
        return "redirect:/task/list";
    }

    @GetMapping("/delete")
    public String deleteTask(@RequestParam("taskId") Long taskId) {
        defaultTaskService.deleteById(taskId);
        return "redirect:/task/list";
    }

    @PostMapping("/update")
    public String updateTask(@RequestParam("taskId") Long taskId, ModelMap modelMap) {
        TaskModel foundTaskModel = defaultTaskService.findByTaskId(taskId);
        modelMap.addAttribute("foundTaskModel", foundTaskModel);
        defaultTaskService.save(foundTaskModel);
        return "redirect:/task/list";
    }
}
