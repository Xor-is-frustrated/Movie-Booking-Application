package com.personal.project.theatre.dao;

import com.personal.project.theatre.pojo.SeatPojo;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class SeatDao extends AbstractDao{

    @Transactional
    public SeatPojo insert(SeatPojo c) {
        em().persist(c);
        return c;
    }
}
