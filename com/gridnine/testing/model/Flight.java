package com.gridnine.testing.model;


import com.gridnine.testing.interfaces.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segments;

    public Flight(List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void printFlights() {
        System.out.println("Перелёт: ");
        for (int i = 0; i < segments.size(); i++) {
            System.out.println(segments.get(i));
        }
    }

    public boolean filter(FlightFilter filter) {
        return filter.filter(this);
    }

    public Duration getTimeOnEarth() {
        Duration timeOnEarth = Duration.ZERO;
        for (int i = 0; i < segments.size(); i++) {
            timeOnEarth = timeOnEarth.plus(
                    Duration.between(segments.get(i-1).getArrivalDate(),
                            segments.get(i).getDepartureDate()));
        }
        return timeOnEarth;
    }


    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}

