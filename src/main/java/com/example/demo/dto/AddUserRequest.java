package com.example.demo.dto;

import com.example.demo.domain.User;
import lombok.Data;

@Data
public class AddUserRequest {
    private String email;
    private String password;
    private String nickname;

}
