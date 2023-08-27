package com.gridnine.testing.interfaces;

import com.gridnine.testing.model.Flight;

public class FilterTimeOnEarthTwoHours implements FlightFilter {

    @Override
    public boolean filter(Flight flight) {
        return flight.getTimeOnEarth().toHours() <= 2;
    }
}
