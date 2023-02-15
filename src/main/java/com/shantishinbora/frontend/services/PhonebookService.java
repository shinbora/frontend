package com.shantishinbora.frontend.services;

import com.shantishinbora.frontend.dto.request.PhonebookRequest;
import com.shantishinbora.frontend.dto.response.PhonebookListResponse;
import com.shantishinbora.frontend.dto.response.PhonebookResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PhonebookService {
    public List<PhonebookResponse> getAllContact() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082/phonebook", PhonebookListResponse.class).getPhonebookList();
    }

    public void addContact(PhonebookRequest phonebookRequest){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation("http://localhost:8082/phonebook", phonebookRequest);
    }

    public void updateContact(Long id, PhonebookRequest phonebookRequest){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put("http://localhost:8082/phonebook/"+id, phonebookRequest);
    }

    public PhonebookResponse getUpdateForm(Long id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082/phonebook/"+id, PhonebookResponse.class);
    }

    public void deleteContact(Long id){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete("http://localhost:8082/phonebook/"+id);
    }
}
