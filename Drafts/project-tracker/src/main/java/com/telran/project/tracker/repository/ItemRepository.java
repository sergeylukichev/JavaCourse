package com.telran.project.tracker.repository;

import com.telran.project.tracker.model.entity.Item;
import com.telran.project.tracker.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByUser(User user);
    List<Item> findAllByItemNameContaining(String name);
}
