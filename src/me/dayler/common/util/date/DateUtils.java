/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dayler.common.util.date;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author asalazar
 */
public final class DateUtils {

    public static long getNowTime() {
        return new Date().getTime();
    }

    /**
     * Creates new instance of java.util.Date based on timestamp.
     *
     * @param timestamp
     * @return
     */
    public static Date timestampSqlToDate(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }

        return new Date(timestamp.getTime());
    }
}
