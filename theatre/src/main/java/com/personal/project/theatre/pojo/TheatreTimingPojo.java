package com.personal.project.theatre.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "theatreTimings", uniqueConstraints = @UniqueConstraint(columnNames = {
        "theatreId", "hours"}))
public class TheatreTimingPojo {
    @Id
    @TableGenerator(name = "theatre_timing_id", pkColumnValue = "theatre_timing_id", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "theatre_timing_id")
    private Long id;
    private Long theatreId;
    private Integer hours;
}
