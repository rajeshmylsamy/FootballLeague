package com.starnw.football.utils;

/**
 * @author Rajesh Mylsamy
 */
public class StringUtils {

    public static String formatName(int id, String name) {
        return String.format("(%s) - %s", id, name);
    }
}
