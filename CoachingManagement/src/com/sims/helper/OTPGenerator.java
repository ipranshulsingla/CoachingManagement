package com.sims.helper;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OTPGenerator {
	public static String generateOTP(){
		StringBuilder generatedOTP = new StringBuilder();
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate 20 integers 0..20
            for (int i = 0; i <6; i++) {
                generatedOTP.append(number.nextInt(9));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("OTP Generated:"+generatedOTP);
        return generatedOTP.toString();
	}
}
