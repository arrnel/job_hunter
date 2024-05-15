package com.jobhunter.controller;

import com.jobhunter.dto.RegistrationRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

public interface RegisterController {

    String getRegisterPage(Model model);
    String registerUser(RegistrationRequestDTO registrationModel,
                        Errors errors,
                        Model model,
                        HttpServletResponse response);

}
