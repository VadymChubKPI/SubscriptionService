package controller;

public class SubscriptionRequest {
    private String username;
    private String deliveryType;
    private String address;
    private String contactInfo;
    private String productName;
    private String frequency; // додано як приватне поле

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getDeliveryType() { return deliveryType; }
    public void setDeliveryType(String deliveryType) { this.deliveryType = deliveryType; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getFrequency() { return frequency; }  // додано
    public void setFrequency(String frequency) { this.frequency = frequency; }  // додано
}
