package com.mvc.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentsService;

    @RequestMapping("/mvc/ui/payments")
    @PreAuthorize("hasRole('" + Role.USER + "')")
    public String index(final Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
//        paymentsService.fluxPayments();
        return "index";

    }
}
