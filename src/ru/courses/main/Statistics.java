package ru.courses.main;

import java.time.LocalDateTime;
import java.time.Duration;

public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private int entryCount;

    public Statistics() {
        this.totalTraffic = 0;
        this.minTime = null;
        this.maxTime = null;
        this.entryCount = 0;
    }

    public void addEntry(LogEntry entry) {
        totalTraffic += entry.getResponseSize();
        entryCount++;

        LocalDateTime currentTime = entry.getTime();

        if (minTime == null || currentTime.isBefore(minTime)) {
            minTime = currentTime;
        }

        if (maxTime == null || currentTime.isAfter(maxTime)) {
            maxTime = currentTime;
        }
    }

    public double getTrafficRate() {
        if (minTime == null || maxTime == null) {
            return 0.0;
        }

        long hoursBetween = Duration.between(minTime, maxTime).toHours();

        if (hoursBetween == 0) {
            return totalTraffic;
        }

        return (double) totalTraffic / hoursBetween;
    }

    public int getTotalTraffic() { return totalTraffic; }
    public int getEntryCount() { return entryCount; }
    public LocalDateTime getMinTime() { return minTime; }
    public LocalDateTime getMaxTime() { return maxTime; }
}