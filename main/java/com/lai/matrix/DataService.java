package com.lai.matrix;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    public static List<Event> getEvent() {
        List<Event> eventData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            eventData.add(new Event("abc hhhh", "1184 W", "This is"));
        }
        return eventData;
    }
}
