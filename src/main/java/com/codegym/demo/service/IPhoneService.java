package com.codegym.demo.service;

import com.codegym.demo.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> getAllPhone();

    void addPhone(Phone phone);
}
