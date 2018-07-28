package com.ankang.msgboard.infrastructure.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatTools {

    public static String format(Instant date) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                        .withLocale(Locale.CHINA)
                        .withZone(ZoneId.systemDefault());
        return formatter.format(date);
    }
}
