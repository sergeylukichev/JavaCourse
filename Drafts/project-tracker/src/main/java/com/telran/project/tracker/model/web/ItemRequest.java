package com.telran.project.tracker.model.web;

import com.telran.project.tracker.model.entity.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemRequest {
    private String itemName;
    private ItemType itemType;
}
