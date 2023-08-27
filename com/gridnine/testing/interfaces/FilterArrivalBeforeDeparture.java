package com.gridnine.testing.interfaces;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

public class FilterArrivalBeforeDeparture implements FlightFilter {

    @Override
    public boolean filter(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return false;
            }
        }
        return true;
    }
}
