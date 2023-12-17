package com.enviro.assessment.grad001.TshepisoMolefi.helpers;

import java.util.UUID;

public class Token {

	//GENERATES TOKEN
    public static String generateToken(){
        String token = UUID.randomUUID().toString();
        return token;
    }
}
