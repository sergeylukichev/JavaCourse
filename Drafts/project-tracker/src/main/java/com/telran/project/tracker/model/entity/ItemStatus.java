package com.telran.project.tracker.model.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telran.project.tracker.exception.TypeNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
public enum ItemStatus {

    TODO(1, "To Do"),
    IN_PROGRESS(2, "In Progress"),
    DONE(3, "Done")

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
    public static ItemStatus getByName(String name) {
        if (name == null) {
            return ItemStatus.TODO;
        }


        return Arrays.stream(values())
                .filter(x -> x.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException(String.format("Item status with name [%s] does not exist", name)));
    }

    public static ItemStatus getById(Integer id) {
        if (id == null) {
            return ItemStatus.TODO;
        }

        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TypeNotFoundException(String.format("Item status with ID [%s] does not exist", id)));
    }

    public ItemStatus getNextPhase() {
        return Arrays
                .stream(values())
                .sorted(Comparator.comparing(ItemStatus::getId))
                .filter(x -> x.getId().equals(this.getId() + 1))
                .findFirst()
                .orElse(ItemStatus.DONE);
    }
}
