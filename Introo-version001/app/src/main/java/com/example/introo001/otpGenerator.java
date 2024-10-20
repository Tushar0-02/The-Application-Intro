package com.example.introo001;
import com.google.android.gms.common.api.Response;

import java.security.SecureRandom;

public class otpGenerator {
    public static int numericOTP(int length) {
        SecureRandom secureRandom = new SecureRandom();
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;
        return secureRandom.nextInt((max - min) + 1) + min;
    }
}

