package com.telran.project.tracker.model.web;

import com.telran.project.tracker.model.entity.Item;
import com.telran.project.tracker.model.entity.ItemStatus;
import com.telran.project.tracker.model.entity.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemResponse {

    private Long id;
    private String itemName;
    private ItemType itemType;
    private ItemStatus itemStatus;
    private LocalDateTime createdDate;
    private String createdBy;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.itemStatus = item.getItemStatus();
        this.itemType = item.getItemType();
        this.createdDate = item
                .getCreatedDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        this.createdBy = item.getUser().getUsername();
    }
}
