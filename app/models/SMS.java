package models;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

public class SMS {

	/* Twilio REST API version */
	public static final String ACCOUNTSID = "AC5c733fe172ab43d08178f9aa5e979850";
	public static final String AUTHTOKEN = "217c825505803b7bddd0d5a04f8ec80b";
	public static final String FROM = "+13472526144";

	public void sendMessage(String toNumber, String msg) {

		/* Instantiate a new Twilio Rest Client */
		TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);

		// Get the account and call factory class
		Account acct = client.getAccount();

		SmsFactory smsFactory = acct.getSmsFactory();
		// build map of server admins

		// build map of post parameters
		Map<String, String> params = new HashMap<String, String>();
		params.put("From", FROM);
		params.put("To", toNumber);
		params.put("Body", msg);
		try {
			// send an sms a call
			// ( This makes a POST request to the SMS/Messages resource)
			Sms sms = smsFactory.create(params);
			System.out.println("Success sending SMS: " + sms.getSid());
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
	}


}