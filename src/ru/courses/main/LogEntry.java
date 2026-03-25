package ru.courses.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
        String[] quotedParts=logLine.split("\"");
        if (quotedParts.length < 6) {
            throw new IllegalArgumentException("Неверный формат строки лога: " + logLine);
        }
        String[] firstPart=quotedParts[0].trim().split(" ");
        if (firstPart.length < 4) {
            throw new IllegalArgumentException("Неверный формат даты/IP: " + logLine);
        }
        this.ipAddr=firstPart[0];
        String dateTimeStr=firstPart[3].replace("[","");
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
        this.time=LocalDateTime.parse(dateTimeStr, formatter);

        String[] requestParts=quotedParts[1].split(" ");
        if (requestParts.length>=2) {
            this.method=HttpMethod.valueOf(requestParts[0]);
            this.path=requestParts[1];
        } else {
            this.method=HttpMethod.GET;
            this.path="/";
        }
        String[] afterRequest=quotedParts[2].trim().split(" ");
        if (afterRequest.length>=2) {
            this.responseCode=Integer.parseInt(afterRequest[0]);
            this.responseSize=afterRequest[1].equals("-")? 0:Integer.parseInt(afterRequest[1]);
        } else if (afterRequest.length==1) {
            this.responseCode=Integer.parseInt(afterRequest[0]);
            this.responseSize=0;
        } else {
            this.responseCode=200;
            this.responseSize=0;
        }
        this.referer=quotedParts[3];
        this.userAgent=new UserAgent(quotedParts[5]);
    }
    public String getIpAddr() {return ipAddr; }
    public LocalDateTime getTime() {return time; }
    public HttpMethod getMethod() {return method; }
    public String getPath() {return path; }
    public int getResponseCode() {return responseCode; }
    public int getResponseSize() {return responseSize; }
    public String getReferer() {return referer; }
    public UserAgent getUserAgent() {return userAgent; }
}