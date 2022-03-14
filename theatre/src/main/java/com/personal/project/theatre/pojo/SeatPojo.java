package com.personal.project.theatre.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "seats", uniqueConstraints = @UniqueConstraint(columnNames = {
        "nameOfSeat", "theatreId"}))
public class SeatPojo extends AbstractPojo {
    @Id
    @TableGenerator(name = "seat_id", pkColumnValue = "seat_id", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seat_id")
    private Long id;
    @NotNull
    private Long theatreId;
    private String nameOfSeat; //Gold
    private Integer importance;
    private Integer rowCount;
}
