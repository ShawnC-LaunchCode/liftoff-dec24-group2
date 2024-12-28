package com.waxofalltrades.liftoff_capstone_vinyl_destination.dto;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ConditionType;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import jakarta.validation.constraints.NotNull;

public class ItemConditionTypeDTO {
    @NotNull
    private Item item;

    @NotNull
    private ConditionType conditionType;

    public ItemConditionTypeDTO() {
    }

    public @NotNull Item getItem() {
        return item;
    }

    public void setItem(@NotNull Item item) {
        this.item = item;
    }

    public @NotNull ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(@NotNull ConditionType conditionType) {
        this.conditionType = conditionType;
    }
}
