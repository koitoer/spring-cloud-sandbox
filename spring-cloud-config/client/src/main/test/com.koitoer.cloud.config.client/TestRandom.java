package com.koitoer.cloud.config.client;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mauricio.mena on 08/06/2016.
 */
public class TestRandom {

    private double MaxPerWeek = 250.00;

    @Test
    public void myTest(){
        List<Event> listOfEvents = new ArrayList<Event>();
        listOfEvents.add(new Event("1/06/2016",16.00));
        listOfEvents.add(new Event("8/06/2016",22.00));
        listOfEvents.add(new Event("15/06/2016",22.00));
        listOfEvents.add(new Event("22/06/2016",22.00));
        Assert.assertEquals(168, difference(listOfEvents), 0.00D);

        System.out.println(DateTime.now().weekOfWeekyear().get());
        //Bring records from one week before and the current one
        System.out.println(DateTime.now().minusDays(7).withDayOfWeek(DateTimeConstants.FRIDAY));
        Date start = DateTime.now().minusDays(7).withDayOfWeek(DateTimeConstants.FRIDAY).toDate();
        Date end = DateTime.now().withDayOfWeek(DateTimeConstants.FRIDAY).toDate();
        System.out.println(DateTime.now().withDayOfWeek(DateTimeConstants.FRIDAY));
        // 3-10/06/2016
        Assert.assertEquals(228, difference(listOfEvents, start, end),0.00);

    }

    private double difference(List<Event> events, Date start, Date end){
        DateTimeFormatter df = DateTimeFormat.forPattern("dd/MM/yyyy");
        double totalWeek = 0.0;
        for(Event event : events){
            Date current = DateTime.parse(event.getDateTime(), df).toDate();
            if(current.after(start) && current.before(end)){
                totalWeek += event.getTotal();
            }
        }
        return MaxPerWeek-totalWeek;
    }


    private double difference(List<Event> events){
        double totalWeek = 0.0;
        for(Event event : events){
            totalWeek += event.getTotal();
        }
        return MaxPerWeek-totalWeek;
    }

    private class Event {
        private String dateTime;
        private double total;

        public Event() {
        }

        public Event(String dateTime, double total) {
            this.dateTime = dateTime;
            this.total = total;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }
}
