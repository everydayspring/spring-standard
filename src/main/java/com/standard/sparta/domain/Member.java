package com.standard.sparta.domain;

import lombok.AllArgsConstructor;

/**
 * 회원 엔티티
 */
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String email;
    private boolean isDeleted;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
}
