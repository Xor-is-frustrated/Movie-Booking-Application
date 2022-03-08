package com.personal.project.theatre.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "theatre", uniqueConstraints = @UniqueConstraint(columnNames = {
        "theatreName" }))
public class TheatrePojo {
    @Id
    @TableGenerator(name = "theatre_id", pkColumnValue = "theatre_id", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "theatre_id")
    private Long id;
    @NotNull
    private String theatreName;
}
