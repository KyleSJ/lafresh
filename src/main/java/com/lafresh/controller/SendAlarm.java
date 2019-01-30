package com.lafresh.controller;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class SendAlarm {
  public void send(String status) {
    String api_key = "NCSIZ8UFKKGXUPCV";
    String api_secret = "SF8Z3RMVM56LWD9GWIXEKTWKHQI8I5RO";
    Message coolsms = new Message(api_key, api_secret);
    String number2 = "01033740924";

    HashMap<String, String> values = new HashMap<>();
    values.put("to", number2);
    values.put("from", "01066251025");
    values.put("type", "SMS");
    values.put("text", "Test Message : " + status);
    values.put("app_version", "JAVA SDK v1.2");

    try {

      JSONObject obj2 = (JSONObject) coolsms.send(values);
      System.out.println(obj2.toString());

    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}
