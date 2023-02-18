package com.etraveli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String phone;
    private Integer temperature;
    private boolean smsEnabled;
    private boolean emailEnabled;
    private boolean appEnabled;
}