package com.example.introo001;

public class otpVerification {
    public static boolean checkOTP(int enteredOTP, int generatedOTP) {
        if (enteredOTP == generatedOTP) {
            return true;
        } else {
            return false;
        }
    }
}