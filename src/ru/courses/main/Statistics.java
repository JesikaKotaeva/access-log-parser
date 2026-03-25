package ru.courses.main;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private int entryCount;
    private HashSet<String> pages;
    private HashMap<String, Integer> osCount;
    private HashSet<String> notFoundPages;
    private HashMap<String, Integer> browserCount;

    public Statistics() {
        this.totalTraffic= 0;
        this.minTime=null;
        this.maxTime=null;
        this.entryCount=0;
        this.pages=new HashSet<>();
        this.notFoundPages = new HashSet<>();
        this.osCount = new HashMap<>();
        this.browserCount = new HashMap<>();
    }

    public void addEntry(LogEntry entry) {
        totalTraffic+=entry.getResponseSize();
        entryCount++;
        LocalDateTime currentTime=entry.getTime();
        if (minTime==null|| currentTime.isBefore(minTime)) {
            minTime=currentTime;
        }
        if (maxTime==null || currentTime.isAfter(maxTime)) {
            maxTime=currentTime;
        }
        if (entry.getResponseCode()==200) {
            pages.add(entry.getPath());
        }
        if (entry.getResponseCode()==404) {
            notFoundPages.add(entry.getPath());
        }
        String os = entry.getUserAgent().getOs();
        if (osCount.containsKey(os)) {
            osCount.put(os, osCount.get(os) + 1);
        } else {
            osCount.put(os, 1);
        }
        String browser = entry.getUserAgent().getBrowser();
        if (browserCount.containsKey(browser)) {
            browserCount.put(browser, browserCount.get(browser) + 1);
        } else {
            browserCount.put(browser, 1);
        }
    }
    public double getTrafficRate() {
        if (minTime==null ||maxTime==null) {
            return 0.0;
        }
        long hoursBetween=Duration.between(minTime, maxTime).toHours();
        if (hoursBetween==0) {
            return totalTraffic;
        }
        return (double) totalTraffic / hoursBetween;
    }
    public Set<String> getAllPages() {
        return pages;
    }
    // метод для получения списка всех несуществующих страниц (404)
    public Set<String> getNotFoundPages() {
        return notFoundPages;
    }
    // метод для получения статистики операционных систем
    public Map<String, Double> getOSStatistics() {
        HashMap<String, Double> osStatistics=new HashMap<>();
        int totalOSCount=0;
        for (int count:osCount.values()) {
            totalOSCount+=count;
        }
        for (Map.Entry<String, Integer> entry : osCount.entrySet()) {
            double share = (double) entry.getValue() / totalOSCount;
            osStatistics.put(entry.getKey(), share);
        }

        return osStatistics;
    }
    public Map<String, Double> getBrowserStatistics() {
        HashMap<String, Double> browserStatistics = new HashMap<>();

        // посчет общего количество записей
        int totalBrowserCount = 0;
        for (int count : browserCount.values()) {
            totalBrowserCount += count;
        }
        // посчет браузеров
        for (Map.Entry<String, Integer> entry : browserCount.entrySet()) {
            double share = (double) entry.getValue() / totalBrowserCount;browserStatistics.put(entry.getKey(), share);
        }
        return browserStatistics;
    }
    public int getTotalTraffic() { return totalTraffic; }
    public int getEntryCount() { return entryCount; }
    public LocalDateTime getMinTime() { return minTime; }
    public LocalDateTime getMaxTime() { return maxTime; }
}