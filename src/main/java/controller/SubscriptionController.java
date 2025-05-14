package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @GetMapping("/user/{username}")
    public List<Subscription> getUserSubscriptions(@PathVariable String username) {
        return service.getUserSubscriptions(username);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSubscription(@RequestBody SubscriptionRequest request) {
        try {
            Subscription subscription = service.createSubscription(
                    request.getUsername(),
                    request.getDeliveryType(),
                    request.getProductName(),
                    request.getAddress(),
                    request.getContactInfo(),
                    request.getFrequency()
            );
            return ResponseEntity.ok(subscription);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Внутрішня помилка сервера");
        }
    }

    @DeleteMapping("/{id}")
    public void cancelSubscription(@PathVariable Long id) {
        service.cancelSubscription(id);
    }
}
