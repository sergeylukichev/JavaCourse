package com.telran.project.tracker.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telran.project.tracker.exception.TypeNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum ItemType {

    TASK(1, "Task"),
    BUG(2, "Bug"),
    TEST(3, "Test")
    ;

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static ItemType getByName(String name) {
        if (name == null) {
            return ItemType.TASK;
        }

        return Arrays.stream(values())
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException(String.format("Item type with name [%s] does not exist", name)));

    }

    public static ItemType getById(Integer itemTypeId) {
        if (itemTypeId == null) {
            return ItemType.TASK;
        }

        return Arrays.stream(values())
                .filter(x -> x.getId().equals(itemTypeId))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException(String.format("Item type with ID [%s] does not exist", itemTypeId)));

    }
}
