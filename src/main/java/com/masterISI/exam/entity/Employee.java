package com.masterISI.exam.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "employees")

@ToString
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank(message = "The fist name field is required")
    private String firstname;

    @NotNull
    @NotBlank(message = "The last name field is required")
    private String lastname;

    @NotNull
    @NotBlank(message = "The grade field is required")
    private String grade;

    @NotNull
    @NotBlank(message = "The performance field is required")
    private String performance;

    @NotNull
    @NotBlank(message = "The type field is required")
    private String type;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy="manager")
    private Set<Employee> subordinates = new HashSet<Employee>();

}
