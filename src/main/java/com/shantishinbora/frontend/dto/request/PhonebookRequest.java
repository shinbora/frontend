package com.shantishinbora.frontend.dto.request;

import lombok.Data;

@Data
public class PhonebookRequest {
    private String name;
    private String email;
    private String phone;
    private String address;
}
