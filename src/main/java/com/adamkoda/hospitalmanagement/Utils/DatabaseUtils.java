package com.adamkoda.hospitalmanagement.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DatabaseUtils {
    private DatabaseUtils() {
        // prevent object creation
    }

    public static String generateId(String type) {
        String datePart = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String randomPart = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 6)
                .toUpperCase();
        return type + "-" + datePart + "-" + randomPart;
    }
}
