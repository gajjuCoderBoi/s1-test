package com.cog.uspsclient.service;

import com.cog.uspsclient.bean.Shipment;

public interface ShipmentService {

    public Shipment getShipment(Long trackingNumber);

    public Shipment createShipment(Shipment shipment);

}
