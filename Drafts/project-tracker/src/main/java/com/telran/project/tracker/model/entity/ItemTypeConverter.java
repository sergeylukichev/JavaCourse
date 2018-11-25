package com.telran.project.tracker.model.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ItemTypeConverter implements AttributeConverter<ItemType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ItemType itemType) {
        return itemType == null ? ItemType.TASK.getId() : itemType.getId();
    }

    @Override
    public ItemType convertToEntityAttribute(Integer integer) {
        return integer == null ? ItemType.TASK : ItemType.getById(integer);
    }
}
