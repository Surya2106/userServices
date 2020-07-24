package dev.naman.userservice.controller;

import dev.naman.userservice.dto.PasswordResetDto;
import dev.naman.userservice.dto.ResponseDto;
import dev.naman.userservice.dto.UserDto;
import dev.naman.userservice.dto.UserResponseDto;
import dev.naman.userservice.model.User;
import dev.naman.userservice.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/token")
    public ResponseDto<UserResponseDto> fetchToken(@RequestParam String email){

        User user = userService.fetchToken(email);

        return new ResponseDto<>(
                HttpStatus.OK,
                new UserResponseDto(user.getId(), user.getFullName(), user.getEmail(), user.isActive())
        );
    }

    @GetMapping("/user/validate")
    public ResponseDto<UserResponseDto> validateUser(@RequestParam String token){

        User user = userService.validateUserToPasswordReset(token);

        return new ResponseDto<>(
                HttpStatus.OK,
                new UserResponseDto(user.getId(), user.getFullName(), user.getEmail(), user.isActive())
        );

    }

    @GetMapping("/user/resetPassword")
    public ResponseDto<UserResponseDto> resetPassword(@Valid @RequestBody PasswordResetDto passwordResetDto){

        User user = userService.resetPassword(passwordResetDto);

        return new ResponseDto<>(
                HttpStatus.OK,
                new UserResponseDto(user.getId(), user.getFullName(), user.getEmail(), user.isActive())
        );

    }
}
