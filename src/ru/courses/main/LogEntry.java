package ru.courses.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
    private final String ipAddr;
    private final LocalDateTime time;
    private final HttpMethod method;
    private final String path;
    private final int responseCode;
    private final int responseSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String logLine) {
        String[] quotedParts = logLine.split("\"");

        String[] firstPart = quotedParts[0].trim().split(" ");
        this.ipAddr = firstPart[0];

        String dateTimeStr = firstPart[3].replace("[", "");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
        this.time = LocalDateTime.parse(dateTimeStr, formatter);

        String[] requestParts = quotedParts[1].split(" ");
        this.method = HttpMethod.valueOf(requestParts[0]);
        this.path = requestParts[1];

        String[] afterRequest = quotedParts[2].trim().split(" ");
        this.responseCode = Integer.parseInt(afterRequest[0]);
        this.responseSize = afterRequest[1].equals("-") ? 0 : Integer.parseInt(afterRequest[1]);

        this.referer = quotedParts[3];

        this.userAgent = new UserAgent(quotedParts[5]);
    }

    public String getIpAddr() { return ipAddr; }
    public LocalDateTime getTime() { return time; }
    public HttpMethod getMethod() { return method; }
    public String getPath() { return path; }
    public int getResponseCode() { return responseCode; }
    public int getResponseSize() { return responseSize; }
    public String getReferer() { return referer; }
    public UserAgent getUserAgent() { return userAgent; }
}