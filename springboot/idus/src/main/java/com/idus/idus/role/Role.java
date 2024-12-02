package com.idus.idus.role;

public enum Role {
    REGULAR("regular"),
    ADMIN("admin");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
