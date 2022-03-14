package com.personal.project.theatre.dao;

import com.personal.project.theatre.pojo.AddressPojo;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AddressDao extends AbstractDao{
    @Transactional
    public AddressPojo insert(AddressPojo c) {
        em().persist(c);
        return c;
    }
}
