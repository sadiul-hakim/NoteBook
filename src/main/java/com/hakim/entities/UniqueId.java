package com.hakim.entities;

import java.util.UUID;

/**
 *
 * @author Hakim
 */
public class UniqueId {
    public static String getUniqueId(){
        String[] arr= UUID.randomUUID().toString().split("-");
        return arr[arr.length-1];
    }
}
