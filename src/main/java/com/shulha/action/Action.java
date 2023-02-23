package com.shulha.action;

import com.shulha.service.UniversityService;

public interface Action {
    UniversityService UNIVERSITY_SERVICE = UniversityService.getInstance();

    void execute();
}
