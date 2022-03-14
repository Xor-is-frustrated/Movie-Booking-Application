package com.personal.project.theatre.dto;

import com.personal.project.model.ApiException;
import com.personal.project.theatre.api.TheatreApi;
import com.personal.project.theatre.dto.helper.TheatreHelper;
import com.personal.project.theatre.model.form.TheatreForm;
import com.personal.project.theatre.pojo.AddressPojo;
import com.personal.project.theatre.pojo.SeatPojo;
import com.personal.project.theatre.pojo.TheatrePojo;
import com.personal.project.theatre.pojo.TheatreTimingPojo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class TheatreDto {

    @Autowired
    private TheatreApi theatreApi;

    public void add(TheatreForm form) throws ApiException {
//        validate(form);
        TheatreHelper.validate(form);
        Long addressId = addAddress(form);
        Long theatreId = addTheatre(form, addressId);
        addSeats(form, theatreId);
        addHours(form, theatreId);
    }

    private void addHours(TheatreForm form, Long theatreId) {
        List<TheatreTimingPojo> timings = TheatreHelper.convertToTimings(form, theatreId);
        theatreApi.insertTimings(timings);
    }

    private Long addAddress(TheatreForm form) {
        AddressPojo address = TheatreHelper.convertAddress(form);
        return theatreApi.insert(address);
    }

    private void addSeats(TheatreForm form, Long theatreId) {
        List<SeatPojo> seats = TheatreHelper.convert(form, theatreId);
        theatreApi.insert(seats);
    }

    private Long addTheatre(TheatreForm form, Long addressId) {
        TheatrePojo theatre = TheatreHelper.convertTheatre(form, addressId);
        return theatreApi.insert(theatre);
    }
}
