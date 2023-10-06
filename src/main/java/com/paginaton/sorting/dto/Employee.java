package com.paginaton.sorting.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.internal.build.AllowPrintStacktrace;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Entity
public class Employee {

    @Id
    private int id;
    private String employeeName;
    private double salary;
}
