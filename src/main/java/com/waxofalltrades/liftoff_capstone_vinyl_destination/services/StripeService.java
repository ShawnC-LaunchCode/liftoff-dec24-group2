package com.waxofalltrades.liftoff_capstone_vinyl_destination.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.ProductRequest;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.dto.StripeResponse;
import org.springframework.beans.factory.annotation.Value;



public class StripeService {
@Value("${stripe.apikey}")
private String secretKey;
    public StripeResponse checkoutProducts(ProductRequest productRequest){
        Stripe.apiKey = secretKey;

        SessionCreateParams.LineItem.PriceData.ProductData productData = SessionCreateParams.LineItem.PriceData.ProductData.builder().setName(productRequest.getName()).build();
        SessionCreateParams.LineItem.PriceData priceData = SessionCreateParams.LineItem.PriceData.builder().setCurrency("USD").setUnitAmount(productRequest.getAmount()).setProductData(productData).build();
        SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder().setQuantity(productRequest.getQuantity()).setPriceData(priceData).build();

        SessionCreateParams params =  SessionCreateParams.builder().setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl("http://localhost:8080/success").setCancelUrl("http://localhost:8080/cancel").addLineItem(lineItem).build();

        Session session = null;
        try{
            session = Session.create(params);

        } catch (StripeException ex){
            System.out.println(ex.getMessage());
        }

        return checkoutProducts();
        //currently stuck here

}
