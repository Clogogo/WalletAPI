package com.example.wallet.Utilities;

public class Converter {


    public Integer convertFromInteger(Integer amount) {
        return (int) (amount * 0.00001);
    }

    public Integer convertToInteger(Integer amount) {
        return amount * 10000;
    }
}
