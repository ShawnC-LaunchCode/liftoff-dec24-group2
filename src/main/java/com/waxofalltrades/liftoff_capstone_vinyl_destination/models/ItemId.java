package com.waxofalltrades.liftoff_capstone_vinyl_destination.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "condition_type_id")
    private ConditionType conditionType;

    @ManyToOne
    @JoinColumn(name = "format_type_id")
    private FormatType formatType;

    public ItemId() {
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public FormatType getFormatType() {
        return formatType;
    }

    public void setFormatType(FormatType formatType) {
        this.formatType = formatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemId itemId)) return false;
        return Objects.equals(album, itemId.album) && Objects.equals(conditionType, itemId.conditionType) && Objects.equals(formatType, itemId.formatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, conditionType, formatType);
    }
}
