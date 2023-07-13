package com.example.voyage.Controller;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
@RestController
public class StripeController {
    private static final String STRIPE_API_KEY = "sk_test_51NT7L6BbfsCiqV7wf9XAw4V6xU70RGYOkTvGUxFQkB1EQpMiostjDCmgNlw4Jmi2AS6LHyVrNEyk3pRw5TVGn0Ke00lOClckry";

    @PostConstruct
    public void init() {
        Stripe.apiKey = STRIPE_API_KEY;
    }
    
    
    @PostMapping("/create-payment-intent")
    public ResponseEntity<Map<String, String>> createPaymentIntent(@RequestParam("amount") Long amount, @RequestParam("currency") String currency) {
        try {
            PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                    .setAmount(amount)
                    .setCurrency(currency)
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(createParams);

            Map<String, String> response = new HashMap<>();
            response.put("clientSecret", paymentIntent.getClientSecret());

            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    
    @GetMapping("/create-payment-intent")
    public ModelAndView showPaymentPage(@RequestParam("amount") Long amount, @RequestParam("currency") String currency, Model model) {
        model.addAttribute("amount", amount);
        model.addAttribute("currency", currency);
        return new ModelAndView("payment-page");
    }
    
    @PostMapping("/process-payment")
    public ResponseEntity<String> processPayment() {
        // Process the payment
        // ...
        return ResponseEntity.ok("Payment processed successfully");
    }


    



}
