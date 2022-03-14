package com.personal.project.theatre.api;

import com.personal.project.theatre.dao.AddressDao;
import com.personal.project.theatre.dao.SeatDao;
import com.personal.project.theatre.dao.TheatreDao;
import com.personal.project.theatre.dao.TheatreTimingDao;
import com.personal.project.theatre.pojo.AddressPojo;
import com.personal.project.theatre.pojo.SeatPojo;
import com.personal.project.theatre.pojo.TheatrePojo;
import com.personal.project.theatre.pojo.TheatreTimingPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TheatreApi {

    @Autowired
    private TheatreDao theatreDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private TheatreTimingDao theatreTimingDao;
    @Autowired
    private SeatDao seatDao;

    @Transactional
    public Long insert(TheatrePojo pojo) {
        return theatreDao.insert(pojo).getId();
    }

    @Transactional
    public void insert(List<SeatPojo> seats) {
        for (SeatPojo seat : seats) {
            seatDao.insert(seat);
        }
    }

    @Transactional
    public Long insert(AddressPojo address) {
        return addressDao.insert(address).getId();
    }

    @Transactional
    public void insertTimings(List<TheatreTimingPojo> timings) {
        for (TheatreTimingPojo timing : timings) {
            theatreTimingDao.insert(timing);
        }
    }
}
