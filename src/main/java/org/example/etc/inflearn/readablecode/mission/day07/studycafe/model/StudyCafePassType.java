package org.example.etc.inflearn.readablecode.mission.day07.studycafe.model;

import java.util.List;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권"),
    WEEKLY("주 단위 이용권"),
    FIXED("1인 고정석");

    private static final List<StudyCafePassType> LOCKER_TYPES = List.of(StudyCafePassType.FIXED);

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }

    public boolean isLockerType() {
        return LOCKER_TYPES.contains(this);
    }

    public boolean isNotLockerType() {
        return isLockerType();
    }
}
