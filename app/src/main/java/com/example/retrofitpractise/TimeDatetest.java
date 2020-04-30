package com.example.retrofitpractise;

import java.util.Calendar;

public interface TimeDatetest {
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR);
    int min = calendar.get(Calendar.MINUTE);
    int sec = calendar.get(Calendar.SECOND);

    public void TimeDatetest1(Calendar calendar, int hour, int min, int sec);
}
