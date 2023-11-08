package com.ll;

public class Rq {
    String cmd;
    String action;
    String queryString;

    Rq(String cmd) {
        this.cmd = cmd;

        String[] cmdBits = cmd .split("\\?", 2);
        action = cmdBits[0];
        queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");

        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];
            String[] queryParamStrBits = queryParamStr.split("=");

            String paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];
        }
    }
}
