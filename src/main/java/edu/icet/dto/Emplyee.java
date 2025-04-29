package edu.icet.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emplyee {
    private Integer id;
    private String name;
    private String address;
    private Double salary;
}
