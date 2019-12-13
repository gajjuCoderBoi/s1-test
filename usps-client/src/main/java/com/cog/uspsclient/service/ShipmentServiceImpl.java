package com.cog.uspsclient.service;


import com.cog.uspsclient.bean.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;

@Service
public class ShipmentServiceImpl implements ShipmentService {


    @Autowired
    RestTemplate restTemplate;

    @Override
    public Shipment getShipment(Long trackingNumber) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:9001/shipment/"+trackingNumber, HttpMethod.GET, entity, Shipment.class).getBody();

    }

    @Override
    public Shipment createShipment(Shipment shipment) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Shipment> requestEntity = new HttpEntity<Shipment>(shipment,headers);
        return restTemplate.exchange("http://localhost:9001/shipment/addshipment", HttpMethod.POST, requestEntity, Shipment.class).getBody();

    }
}
