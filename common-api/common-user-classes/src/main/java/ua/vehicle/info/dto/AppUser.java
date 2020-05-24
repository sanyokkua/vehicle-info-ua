package ua.vehicle.info.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    private Integer userId;
    private String username;
    private String email;
    private String password;
}
