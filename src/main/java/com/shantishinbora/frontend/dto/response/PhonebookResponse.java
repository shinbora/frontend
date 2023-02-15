package com.shantishinbora.frontend.dto.response;

import lombok.Data;

@Data
public class PhonebookResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
