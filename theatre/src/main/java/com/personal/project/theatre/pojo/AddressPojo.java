package com.personal.project.theatre.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Table(name = "address")
public class AddressPojo {
    @Id
    @TableGenerator(name = "address_id", pkColumnValue = "address_id", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "address_id")
    private Long id;
    @NotNull
    private String name;
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String state;
    private String email;
    private String phone;
    private String country;
    private String zip;
}
