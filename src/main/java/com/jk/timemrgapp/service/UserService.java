package com.jk.timemrgapp.service;

import com.jk.timemrgapp.web.model.UserModel;

public interface UserService {
    UserModel save(UserModel userModel);
    Long findUserIdByUsername(String username);

}
