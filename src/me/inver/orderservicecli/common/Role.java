package me.inver.orderservicecli.common;

import java.util.Locale;

public enum Role {
    ADMIN,
    USER;

    public static Role fromString(String string) {
        return string.toLowerCase().equals("admin") ? ADMIN : USER;
    }
}
