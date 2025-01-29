package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ContactForm;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.repositories.ContactFormRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping(value = "contact")
public class ContactFormController {
    @Autowired
    ContactFormRepository contactFormRepository;

    // Display Contact Form
    @GetMapping("/")
    public String displayContactForm(Model model){
        model.addAttribute(new ContactForm());
        return "contact/add";
    }

    // Post Submission
    @PostMapping("/")
    public String processContactForm(@ModelAttribute @Valid ContactForm newContactForm, Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute(new Item());
            return "contact/add";
        }

        newContactForm.setSubmissionDateTime(LocalDateTime.now());
        contactFormRepository.save(newContactForm);
        return "redirect:/contact/success";

    }

    // Display Contact Form Submissions
    @GetMapping("list")
    public String displayContactFormSubmission(Model model){

        model.addAttribute("contacts", contactFormRepository.findAll());
        return "contact/list";
    }

    // Display Contact Form Submissions
    @GetMapping("detail/{contactFormId}")
    public String displayContactFormSubmissionDetail(Model model, @PathVariable int contactFormId){
        Optional<ContactForm> currentContactForm = contactFormRepository.findById(contactFormId);
        if(currentContactForm.isEmpty()){
            model.addAttribute("heading", "Invalid Contact Form Submission");
        }
        else{
            ContactForm result = currentContactForm.get();
            model.addAttribute("heading", "Contact Form Submission Detail");
            model.addAttribute("contact", result);
        }

        return "contact/detail";
    }

    @GetMapping("success")
    public String displayContactFormSuccessful(){

        return "contact/success";
    }
}
