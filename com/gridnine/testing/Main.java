package com.gridnine.testing;

import com.gridnine.testing.builder.FlightBuilder;
import com.gridnine.testing.interfaces.FilterArrivalBeforeDeparture;
import com.gridnine.testing.interfaces.FilterDepartureBeforeAndNow;
import com.gridnine.testing.interfaces.FilterTimeOnEarthTwoHours;
import com.gridnine.testing.interfaces.FlightFilter;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Все перелеты: ");
        for (Flight flight : flights) {
            flight.printFlights();
        }

        FlightFilter filter = new FilterDepartureBeforeAndNow();
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.filter(filter)) {
                filterFlights.add(flight);
            }
        }
        System.out.println("Перелеты с вылетом позже: ");
        for (Flight flight : filterFlights) {
            flight.printFlights();
        }

        filter = new FilterArrivalBeforeDeparture();
        filterFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.filter(filter)) {
                filterFlights.add(flight);
            }
        }
        System.out.println("Перелеты с сегментами, где прибытие раньше вылета:");
        for (Flight flight : filterFlights) {
            flight.printFlights();
        }
        filter = new FilterTimeOnEarthTwoHours();
        filterFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.filter(filter)) {
                filterFlights.add(flight);
            }
        }
        System.out.println("Перелеты, проведенное время у которых на земле больше 2 часов:");
        for (Flight flight : filterFlights) {
            flight.printFlights();
        }

    }
}