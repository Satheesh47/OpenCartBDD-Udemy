package org.opencart.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    public String getEmailWithTimeStamp() {
        return "Test_"+generateTimeStamp()+"@email.com";
    }
    public String generateTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return formatter.format(new Date());
    }
}