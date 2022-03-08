package com.personal.project.theatre.controller;

import com.increff.commons.form.OrderForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.personal.project.theatre.api.ApiException;
import com.personal.project.theatre.dto.TheatreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("")
public class TheatreController {

    @Autowired
    private TheatreDto dto;

    @ApiOperation(value = "Test the application")
    @RequestMapping(path = "/test", method = RequestMethod.POST)
    public void add(@RequestBody OrderForm form) throws ApiException {
        dto.add(form);
    }

//    @ApiOperation(value = "Deletes a order")
//    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable Long id) throws ApiException {
//        dto.delete(id);
//    }
//
//    @ApiOperation(value = "Gets a order by id")
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
//    public OrderData get(@PathVariable int id) throws ApiException {
//
//        return dto.get(Long.valueOf(id));
//    }
//
//    @ApiOperation(value = "Gets list of all orders")
//    @RequestMapping(path = "/external",method = RequestMethod.GET)
//    public List<OrderData> getAll() {
//        return dto.getAll();
//
//    }
//
//    @ApiOperation(value = "Gets list of all channel orders")
//    @RequestMapping(path="/search" ,method = RequestMethod.POST)
//    public List<OrderData> getChannelOrdersBySearch(@RequestBody OrderSearchForm form) throws ApiException {
//        return dto.getOrderBySearch(form);
//    }

}
