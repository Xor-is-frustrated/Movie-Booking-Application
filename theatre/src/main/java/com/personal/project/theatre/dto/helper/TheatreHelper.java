package com.personal.project.theatre.dto.helper;

import com.personal.project.model.ApiException;
import com.personal.project.model.ApiStatus;
import com.personal.project.theatre.model.form.TheatreForm;
import com.personal.project.theatre.pojo.AddressPojo;
import com.personal.project.theatre.pojo.SeatPojo;
import com.personal.project.theatre.pojo.TheatrePojo;
import com.personal.project.theatre.pojo.TheatreTimingPojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheatreHelper {

    public static void validate(TheatreForm form) throws ApiException {
        if (form.getSeats().size() == 0)
            throw new ApiException(ApiStatus.BAD_DATA, "Type of Seats must be greater than 1.");
        if (form.getHours().size() == 0)
            throw new ApiException(ApiStatus.BAD_DATA, "Minimum 1 timing must be there.");
        Collections.sort(form.getHours());
        int prefix = -1;
        for (Integer hour : form.getHours()) {
            if (hour < 0 || hour > 23)
                throw new ApiException(ApiStatus.BAD_DATA, "Hours range must be between 0 and 23.");
            if (prefix == -1) {
                prefix = hour;
                continue;
            }
            if (hour - prefix < 2) {
                throw new ApiException(ApiStatus.BAD_DATA, "Difference between timing must be greater than 2 hours");
            }
        }
    }

    public static TheatrePojo convertTheatre(TheatreForm form, Long addressId) {
        TheatrePojo theatrePojo = new TheatrePojo();
        theatrePojo.setTheatreName(form.getTheatreName());
        theatrePojo.setRowCount(form.getRows());
        theatrePojo.setColumnCount(form.getColumns());
        theatrePojo.setAddress_id(addressId);
        return theatrePojo;
    }

    public static List<SeatPojo> convert(TheatreForm form, Long theatreId) {
        List<SeatPojo> seats = new ArrayList<>();
        for (TheatreForm.Seats seat : form.getSeats()) {
            SeatPojo seatPojo = new SeatPojo();
            seatPojo.setTheatreId(theatreId);
            seatPojo.setNameOfSeat(seat.getSeatName());
            seatPojo.setImportance(seat.getPriority());
            seatPojo.setRowCount(seat.getRows());
            seats.add(seatPojo);
        }
        return seats;
    }

    public static AddressPojo convertAddress(TheatreForm form) {
        AddressPojo addressPojo = new AddressPojo();
        addressPojo.setName(form.getAddress().getName());
        addressPojo.setLine1(form.getAddress().getLine1());
        addressPojo.setLine2(form.getAddress().getLine2());
        addressPojo.setLine3(form.getAddress().getLine3());
        addressPojo.setCity(form.getAddress().getCity());
        addressPojo.setState(form.getAddress().getState());
        addressPojo.setEmail(form.getAddress().getEmail());
        addressPojo.setPhone(form.getAddress().getPhone());
        addressPojo.setCountry(form.getAddress().getCountry());
        addressPojo.setZip(form.getAddress().getZip());
        return addressPojo;
    }

    public static List<TheatreTimingPojo> convertToTimings(TheatreForm form, Long theatreId) {
        List<TheatreTimingPojo> theatreTimingPojos = new ArrayList<>();
        for (Integer hours : form.getHours()) {
            TheatreTimingPojo pojo = new TheatreTimingPojo();
            pojo.setTheatreId(theatreId);
            pojo.setHours(hours);
            theatreTimingPojos.add(pojo);
        }
        return theatreTimingPojos;
    }
}
