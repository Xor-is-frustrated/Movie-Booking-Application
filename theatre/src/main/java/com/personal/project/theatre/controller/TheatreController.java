package com.personal.project.theatre.controller;

import com.personal.project.model.ApiException;
import com.personal.project.theatre.dto.TheatreDto;
import com.personal.project.theatre.model.form.TheatreForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Add Theatre")
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void add(@RequestBody TheatreForm form) throws ApiException {
        dto.add(form);
    }


}
