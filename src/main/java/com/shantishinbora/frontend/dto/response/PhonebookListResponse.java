package com.shantishinbora.frontend.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class PhonebookListResponse {
    List<PhonebookResponse> phonebookList;
}
