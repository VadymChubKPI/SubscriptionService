package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private ProductClient productClient;


    @Autowired
    private SubscriptionRepository repository;

    public Subscription createSubscription(String username, String deliveryType, String productName, String address, String contactInfo, String frequency) {
        // Перевірка чи існує товар
        if (!productClient.existsByProductName(productName)) {
            throw new IllegalArgumentException("Продукт не існує: " + productName);
        }

        Subscription subscription = new Subscription();
        subscription.setId(System.currentTimeMillis());
        subscription.setUsername(username);
        subscription.setDeliveryType(deliveryType);
        subscription.setStartDate(LocalDate.now());
        subscription.setActive(true);
        subscription.setProductName(productName);
        subscription.setAddress(address);
        subscription.setContactInfo(contactInfo);
        subscription.setFrequency(frequency);

        return repository.save(subscription);
    }



    public List<Subscription> getUserSubscriptions(String username) {
        return repository.findByUsername(username);
    }

    public boolean cancelSubscription(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
