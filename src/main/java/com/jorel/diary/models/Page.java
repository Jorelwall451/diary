package com.jorel.diary.models;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public final class Page {
    private final UUID id;
    @NotNull(message = "The title cannot be null.")
    @Size(max = 60)
    private String title;
    @NotNull(message = "The text cannot be null.")
    private String text;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private final UUID userId;

    public Page(UUID userId){
        this.id = UUID.randomUUID();
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        setField(() -> this.title = title);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        setField(() -> this.text = text);
    }

    private void setField(Runnable fieldUpdate){
        fieldUpdate.run();
        setUpdatedAt();
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    private void setUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getUserId(){
        return userId;
    }
}
