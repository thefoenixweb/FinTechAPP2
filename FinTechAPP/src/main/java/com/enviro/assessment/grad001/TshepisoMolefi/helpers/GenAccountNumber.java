package com.enviro.assessment.grad001.TshepisoMolefi.helpers;

import java.util.Random;

public class GenAccountNumber {

	//GENERATES ACCOUNT NUMBER
    public static int generateAccountNumber(){
        int accountNumber;
        Random random = new Random();
        int bound = 1000;
        accountNumber = bound * random.nextInt(bound);
        return accountNumber;
    }
 
}
