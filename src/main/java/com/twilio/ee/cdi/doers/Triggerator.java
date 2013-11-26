package com.twilio.ee.cdi.doers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.twilio.ee.cdi.doers.simple.SimpleTriggerator;
import com.twilio.ee.inject.configuration.TwilioAccountSid;
import com.twilio.ee.inject.configuration.TwilioAuthToken;

@Named
@RequestScoped
public class Triggerator extends SimpleTriggerator
{

   @Inject
   public Triggerator(@TwilioAccountSid String accountSid, @TwilioAuthToken String authToken)
   {
      super(accountSid, authToken);
   }

   public Triggerator()
   {
   }

}