package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Emplyee {
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String department;
    @NotBlank
    private LocalDateTime createAt;
    @NotBlank
    private LocalDateTime updateAt;
}
