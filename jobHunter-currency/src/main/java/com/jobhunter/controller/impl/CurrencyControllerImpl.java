package com.jobhunter.controller.impl;

import com.jobhunter.controller.CurrencyController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currency")
@RequiredArgsConstructor
public class CurrencyControllerImpl implements CurrencyController {
}
