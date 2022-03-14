package com.personal.project.theatre.model.form;

import com.personal.project.model.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
public class TheatreForm {
    @NotNull
    private String theatreName;
    @NotNull
    private Integer rows;
    @NotNull
    private Integer columns;
    @NotNull
    private List<Integer> hours;
    @NotNull
    private Address address;
    @NotNull
    private List<Seats> seats;

    @Getter
    @Setter
    public static class Seats {
        @NotNull
        private String seatName;
        @NotNull
        private Integer rows;
        @NotNull
        private Integer priority;
    }

}
