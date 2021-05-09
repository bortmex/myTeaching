package com.rog.teach.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtils {
    public enum ZONE {
        ZONED_DATE_TIME_EUROPE_MOSCOW("Europe/Moscow");
        private ZoneId zone;

        ZONE(String zone) {
            this.zone = ZoneId.of(zone);
        }

        public ZoneId getZone() {
            return zone;
        }
    }

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String getStrDate(LocalDateTime date) {
        return date.format(DATE_FORMAT);
    }
}
