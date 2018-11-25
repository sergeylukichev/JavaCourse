package com.telran.project.tracker.model.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ItemStatusConverter implements AttributeConverter<ItemStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ItemStatus itemStatus) {
        return itemStatus == null ? ItemStatus.TODO.getId() : itemStatus.getId();
    }

    @Override
    public ItemStatus convertToEntityAttribute(Integer integer) {
        return integer == null ? ItemStatus.TODO : ItemStatus.getById(integer);
    }
}
