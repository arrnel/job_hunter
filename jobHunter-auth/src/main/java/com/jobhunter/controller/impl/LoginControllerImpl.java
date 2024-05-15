package com.jobhunter.controller.impl;

import com.jobhunter.controller.LoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControllerImpl implements LoginController {

    private static final String LOGIN_VIEW_NAME = "login";

    @GetMapping("/api/v1/login")
    public String login() {
        return LOGIN_VIEW_NAME;
    }

}
