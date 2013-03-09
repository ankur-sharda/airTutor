package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.SMS;

public class SMSTest {

    @Test
    public void sendSimpleSMS(){

        SMS sms = new SMS();
        sms.sendMessage("+61401823812","What's up");

        sms.sendMessage("+61404264314","What's up");

        sms.sendMessage("+61411018924","What's up");

        sms.sendMessage("+61448814544","What's up");

        sms.sendMessage("+61421311106","What's up");
    }

}