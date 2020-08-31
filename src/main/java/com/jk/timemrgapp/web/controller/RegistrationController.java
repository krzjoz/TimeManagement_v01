package com.jk.timemrgapp.web.controller;

import com.jk.timemrgapp.service.AuthorityService;
import com.jk.timemrgapp.service.UserService;
import com.jk.timemrgapp.web.helper.Encrypt;
import com.jk.timemrgapp.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    private AuthorityService defaultAuthorityService;
    private UserService defaultUserService;

    @Autowired
    public RegistrationController(AuthorityService defaultAuthorityService,
                                  UserService defaultUserService) {
        this.defaultAuthorityService = defaultAuthorityService;
        this.defaultUserService = defaultUserService;
    }

    @GetMapping("/register")
    public String getRegistration(ModelMap modelMap) {
        modelMap.addAttribute("newUserModel", new UserModel());
        modelMap.addAttribute("authorityList", defaultAuthorityService.findAll());
        return "newuser";
    }

    @PostMapping("/save")
    public String saveNewUser(@ModelAttribute("newUserModel") UserModel userModel) {
        userModel.setHashPass(Encrypt.encrypt(userModel.getHashPass()));
        defaultUserService.save(userModel);
        return "usercreated";
    }
}
