package com.charge.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="customer")
public interface ChargeAPI {

}
