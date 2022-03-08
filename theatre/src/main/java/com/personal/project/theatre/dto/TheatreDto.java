package com.personal.project.theatre.dto;

import com.increff.commons.form.OrderForm;
import com.personal.project.theatre.api.TheatreApi;
import com.personal.project.theatre.pojo.TheatrePojo;
import lombok.Setter;
import com.personal.project.theatre.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Setter
public class TheatreDto {

    @Autowired
    private TheatreApi theatreApi;

    public void add(OrderForm form) {
        TheatrePojo pojo = new TheatrePojo();
        pojo.setTheatreName(form.getChannelName());
        theatreApi.insert(pojo);
    }
}
