package com.barton.utils;

import java.time.Instant;

/**
 * NeverNote Created by Majisto on 8/31/2018.
 */
public class mainUtils {

    public static String generateTimeStamp(){
        return Instant.now().toString();
    }

}
