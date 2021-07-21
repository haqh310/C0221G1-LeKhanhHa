package com.example.service.impl;

import com.example.service.IService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements IService {
    @Override
    public int exchange(int usd, int rate) {
        return usd*rate;
    }
}
