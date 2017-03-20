package org.yoking.vo;

/**
 * Created by zhangyuqing on 2017/3/20.
 */
public enum Gender {
    UNKNOWN(-1),
    MALE(1),
    FEMALE(0);

    private int code;

    Gender(int code) {
        this.code = code;
    }

    public static Gender of(int code) {
        for (Gender g : values()) {
            if (code == g.code) {
                return g;
            }
        }
        return UNKNOWN;
    }
}