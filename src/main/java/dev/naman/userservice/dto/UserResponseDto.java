package dev.naman.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto  {
    private Long id;

    private String fullName;

    private String email;

    private boolean active;

    public UserResponseDto(Long id, String fullName, String email, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
    }
}
