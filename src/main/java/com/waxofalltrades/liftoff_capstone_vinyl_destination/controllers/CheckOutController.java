package com.waxofalltrades.liftoff_capstone_vinyl_destination.controllers;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.Item;
import com.waxofalltrades.liftoff_capstone_vinyl_destination.models.ShoppingCart;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CheckOutController {

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @GetMapping("/checkout")
    public void createCheckoutSession(HttpServletResponse response) throws Exception{
        Stripe.apiKey = stripeSecretKey;
        List<Item> items = ShoppingCart.cart;

        if(items.isEmpty()){
            response.sendRedirect("/shop");
            return;
        }

        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

        for (Item item : items){
            SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                            .setPriceData(SessionCreateParams.LineItem.PriceData.builder().setCurrency("usd").setUnitAmount(Math.round(item.getPrice() * 100)).
                            setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder().setName(item.getAlbum().getName()).build()).build()).build();

            lineItems.add(lineItem);
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:8080/shop/success")
                .setCancelUrl("http://localhost:8080/shop/cancel")
                .addAllLineItem(lineItems)
                .setShippingAddressCollection(
                        SessionCreateParams.ShippingAddressCollection.builder().addAllowedCountry(
                                SessionCreateParams.ShippingAddressCollection.AllowedCountry.US).build()).build();
        Session session = Session.create(params);
        String checkoutUrl = session.getUrl();
        response.sendRedirect(checkoutUrl);

    }
}
