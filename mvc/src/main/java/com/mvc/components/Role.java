package com.mvc.components;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public final class Role {

    public static final String SUPER_ADMIN = "SUPER_ADMIN";
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    private static final Map<String, Set<String>> AVAILABLE_ROLES_TO_CREATE;

    static {
        AVAILABLE_ROLES_TO_CREATE = Map.of(
                SUPER_ADMIN, Set.of(ADMIN, USER),
                ADMIN, Set.of(USER)
        );
    }

    private Role() {
    }

    public static Set<String> getAvailableRolesToCreate(String role) {
        if (StringUtils.isEmpty(role)) {
            return Collections.emptySet();
        }

        return AVAILABLE_ROLES_TO_CREATE.getOrDefault(role, Collections.emptySet());
    }

    public static Set<String> getAvailableRolesToCreate(Set<String> roles) {
        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptySet();
        }

        Set<String> availableRoles = new HashSet<>();
        roles.forEach(r -> availableRoles.addAll(getAvailableRolesToCreate(r)));
        return availableRoles;
    }
}
