package com.paginaton.sorting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PaginationHealthCheckController {
    @GetMapping("/pagination/healthCheck")
    public String healthCheck() {
        return "Pagination Application is up and running";
    }
}
