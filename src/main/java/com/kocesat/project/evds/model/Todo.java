package com.kocesat.project.evds.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private boolean completed;
}
