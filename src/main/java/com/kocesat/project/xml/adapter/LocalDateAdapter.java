package com.kocesat.project.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate>
{
    @Override
    public String marshal(LocalDate date)
    {
        if ( date == null ) return null;
        return date.toString();
    }

    @Override
    public LocalDate unmarshal(String string)
    {
        return LocalDate.parse(string, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
