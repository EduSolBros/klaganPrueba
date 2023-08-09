package com.tecnico.test.operations;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateOperations {
    private SimpleDateFormat sdf;
    public DateOperations(){
        sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
    }

    public Timestamp convertToTimestamp(String dateToConvert) throws ParseException {
        java.util.Date valueInDate = sdf.parse(dateToConvert);
        Timestamp timestamp = new Timestamp(valueInDate.getTime());
        return timestamp;
    }
}
