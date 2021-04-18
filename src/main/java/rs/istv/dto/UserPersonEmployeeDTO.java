package rs.istv.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserPersonEmployeeDTO {
    private String name;
    private String surname;
    private String unid;
    private String pin;
    private String gender;
    private LocalDate birthDate;

    private String email;
    private String username;
    private String position;

    private String bank;
    private LocalDate employmentStartDate;


}
