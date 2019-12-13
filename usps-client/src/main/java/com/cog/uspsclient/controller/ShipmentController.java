package com.cog.uspsclient.controller;


import com.cog.uspsclient.bean.Shipment;
import com.cog.uspsclient.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientfe/shipment")
public class ShipmentController {

    @Autowired
    ShipmentService shipmentService;


    @GetMapping("/{trackingNumber}")
    public Shipment getShipment(@PathVariable Long trackingNumber){
        return shipmentService.getShipment(trackingNumber);
    }

    @PostMapping("/addshipment")
    public Shipment createShipment(@RequestBody Shipment shipment){
        return shipmentService.createShipment(shipment);
    }

}
