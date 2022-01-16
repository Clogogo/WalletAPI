package com.example.wallet.Utilities;

import java.sql.Timestamp;
import java.util.UUID;

public class GenerateToken {

    public String getToken() {
        StringBuilder token = new StringBuilder();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long currentTimeInMilisecond = timestamp.getTime();
        return token.append(currentTimeInMilisecond).append("-")
                .append(UUID.randomUUID()).toString();
    }

}
