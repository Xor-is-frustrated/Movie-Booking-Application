package com.personal.project.theatre.dao;

import com.personal.project.theatre.pojo.TheatreTimingPojo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TheatreTimingDao extends AddressDao{

    @Transactional
    public TheatreTimingPojo insert(TheatreTimingPojo c) {
        em().persist(c);
        return c;
    }
}
