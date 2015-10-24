package com.example.vladok.rentaddresses.repository.contract;

import com.example.vladok.rentaddresses.domain.RentAddress;

public interface RentAddressRepository extends Repository<RentAddress> {
    String readResponse(long id);
}
