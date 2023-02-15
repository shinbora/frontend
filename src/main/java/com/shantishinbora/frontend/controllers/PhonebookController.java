package com.shantishinbora.frontend.controllers;

import com.shantishinbora.frontend.dto.request.PhonebookRequest;
import com.shantishinbora.frontend.dto.response.PhonebookResponse;
import com.shantishinbora.frontend.services.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PhonebookController {
    @Autowired
    PhonebookService phonebookService;

    @GetMapping("/")
    public String viewHomepage(Model model){
        List<PhonebookResponse> listPhonebook = phonebookService.getAllContact();
        model.addAttribute("listPhonebook", listPhonebook);
        return "index";
    }

    @GetMapping("/showContactForm")
    public String showContactForm(Model model){
        PhonebookRequest phonebook = new PhonebookRequest();
        model.addAttribute("phonebook", phonebook);
        return "add_phonebook";
    }

    @PostMapping("/addContact")
    public String addContact(@ModelAttribute("phonebook") PhonebookRequest phonebookRequest){
        phonebookService.addContact(phonebookRequest);
        return "redirect:/";
    }

    @GetMapping("/showContactUpdateForm/{id}")
    public String showContactUpdateForm(@PathVariable Long id, Model model){
        PhonebookResponse phonebook = phonebookService.getUpdateForm(id);
        model.addAttribute("phonebook", phonebook);
        return "update_phonebook";
    }

    @PostMapping("/updateContact/{id}")
    public String updateContact(@PathVariable Long id, @ModelAttribute("phonebook") PhonebookRequest phonebookRequest){
        phonebookService.updateContact(id, phonebookRequest);
        return "redirect:/";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id){
        phonebookService.deleteContact(id);
        return "redirect:/";
    }
}
