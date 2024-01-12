package com.example.expenseTrackerApi.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserModel {

    @NotBlank(message="name should not be empty")
    private String name;

    @NotNull(message="email should not be empty")
    @Email(message = "enter a valid email")
    private String email;

    @NotNull(message="password should not be empty")
    @Size(min=5, message="password should  be at least 5 characters" )
    private String password;

    private Long age = 0L;

}
