package com.learning.apis.staff;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@FeignClient(value = "leadnews-article")
public interface StaffClient {



}