package com.personal.project.theatre.api;

import com.personal.project.theatre.dao.TheatreDao;
import com.personal.project.theatre.pojo.TheatrePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TheatreApi {

    @Autowired
    private TheatreDao theatreDao;

    @Transactional
    public void insert(TheatrePojo pojo){
        theatreDao.insert(pojo);
    }
}
