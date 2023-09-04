package com.alura.hotelalura.model;

public class Register {
    private String id;
    private String checkin;
    private String checkout;
    private double mount;
    private String paymentMethod;

    public Register(String id,String checkin,String checkout,double mount,String paymentMethod){
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.mount = mount;
        this.paymentMethod = paymentMethod;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
