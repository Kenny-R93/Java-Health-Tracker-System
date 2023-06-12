package org.example.Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class SleepRecord {
    private LocalTime sleepTime;
    private LocalTime wakeTime;

    public SleepRecord(LocalTime sleepTime, LocalTime wakeTime) {
        this.sleepTime = sleepTime;
        this.wakeTime = wakeTime;
    }

    public SleepRecord(LocalDateTime startTime, LocalDateTime endTime) {
    }

    public LocalTime getSleepTime() {
        return this.sleepTime;
    }

    public LocalTime getWakeTime() {
        return this.wakeTime;
    }

    public long getHours() {
        return ChronoUnit.HOURS.between(sleepTime, wakeTime);
    }
}
