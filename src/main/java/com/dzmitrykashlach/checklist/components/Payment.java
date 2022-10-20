package com.dzmitrykashlach.checklist.components;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    private int id;
    private String content;
    private boolean completed;
}
