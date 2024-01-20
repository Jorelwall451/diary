package com.jorel.diary.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class User {
    private final UUID id;
    @NotNull(message = "The name cannot be null.")
    private String name;
    @Email(message = "The email have a specify format.")
    @NotNull(message = "The email cannot be null.")
    private String email;
    @NotNull(message = "The password cannot be null.")
    @Size(min = 12, max = 255, message = "Password must be greater than 12 and less than 255.")
    private String password;
    @NotNull(message = "The age cannot be null.")
    private int age;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private final List<Page> pageList = new ArrayList<>();

    public User() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setField(() -> this.name = name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        setField(() -> this.email = email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        setField(() -> this.password = password);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        setField(() -> this.age = age);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private void setField(Runnable fieldUpdate) {
        fieldUpdate.run();
        setUpdatedAt();
    }

    private void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPage(Page page) {
        this.pageList.add(page);
    }
}
