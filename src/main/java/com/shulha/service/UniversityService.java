package com.shulha.service;

import java.util.Optional;

public class UniversityService {
    private static UniversityService instance;

    private UniversityService() {
    }

    public static UniversityService getInstance() {
        instance = Optional.ofNullable(instance)
                .orElseGet(UniversityService::new);

        return instance;
    }
}
