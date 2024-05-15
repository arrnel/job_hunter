package com.jobhunter.service;

import jakarta.annotation.Nonnull;

public interface UserService {

    String registerUser(String username, @Nonnull String password);
}
