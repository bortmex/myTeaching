package com.rog.teach.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public enum ZONE{
        ZONED_DATE_TIME_EUROPE_MOSCOW("Europe/Moscow");
        private ZoneId zone;

        ZONE(String zone) {
            this.zone = ZoneId.of(zone);
        }

        public ZoneId getZone() {
            return zone;
        }

        public void setZone(ZoneId zone) {
            this.zone = zone;
        }
    }
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    public static String getStrDate(LocalDateTime date) {
        return date.format(DATE_FORMAT);
    }

    public static LocalDateTime getDateTimeAccordingZone(LocalDateTime dateTime, ZoneId zoneId){
        return ZonedDateTime.of(dateTime, zoneId).toLocalDateTime();
    }
}
