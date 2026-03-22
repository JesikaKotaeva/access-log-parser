package ru.courses.main;

public class UserAgent {
    private final String os;
    private final String browser;

    public UserAgent(String userAgentString) {
        this.os = extractOS(userAgentString);
        this.browser = extractBrowser(userAgentString);
    }

    private String extractOS(String ua) {
        if (ua.contains("Windows")) return "Windows";
        if (ua.contains("Macintosh") || ua.contains("Mac OS")) return "macOS";
        if (ua.contains("Linux")) return "Linux";
        return "Unknown";
    }

    private String extractBrowser(String ua) {
        if (ua.contains("Edg/")) return "Edge";
        if (ua.contains("Firefox")) return "Firefox";
        if (ua.contains("Chrome")) return "Chrome";
        if (ua.contains("Opera") || ua.contains("OPR/")) return "Opera";
        return "Other";
    }

    public String getOs() { return os; }
    public String getBrowser() { return browser; }
}