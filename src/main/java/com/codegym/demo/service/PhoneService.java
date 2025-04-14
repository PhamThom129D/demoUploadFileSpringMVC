package com.codegym.demo.service;

import com.codegym.demo.model.Phone;
import com.codegym.demo.model.Phone;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhoneService implements IPhoneService{
    
    private static Map<Integer, Phone> phoneMap;
    static {
        phoneMap = new HashMap<>();
        phoneMap.put(1,new Phone(1,"Iphone14",2000,15, null));
        phoneMap.put(2,new Phone(2,"Iphone15",2000,15,null));
        phoneMap.put(3,new Phone(3,"Iphone13",2000,15,null));
        phoneMap.put(4,new Phone(4,"Iphone12",2000,15,null));
        phoneMap.put(5,new Phone(5,"Iphone11",2000,15,null));
        phoneMap.put(6,new Phone(6,"Iphone10",2000,15,null));
    }
    
    @Override
    public List<Phone> getAllPhone() {
        return new ArrayList<>(phoneMap.values());
    }

    @Override
    public void addPhone(Phone phone) {
        phoneMap.put(phone.getPhoneID(),phone);
    }
}
