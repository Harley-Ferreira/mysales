package com.harley.mysales.service;

import com.harley.mysales.NotFoundSaleException;
import com.harley.mysales.entities.Sale;
import com.harley.mysales.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    private final SaleRepository saleRepository;
    public void sendSms(long seleId) {
        Sale sale = saleRepository.findById(seleId).orElseThrow(() -> new NotFoundSaleException("Sele not found"));
        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
        String sendmMessage = "O vendedor " + sale.getSellerName() + " foi destaque em "
                + date + " com um total de R$ " + String.format("%.2f", sale.getAmount());
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, sendmMessage).create();
        System.out.println(message.getSid());
    }
}
