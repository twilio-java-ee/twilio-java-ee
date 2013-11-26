package com.twilio.ee.cdi.doers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.twilio.ee.cdi.doers.simple.SimpleTranscriptionReporter;
import com.twilio.ee.inject.configuration.TwilioAccountSid;
import com.twilio.ee.inject.configuration.TwilioAuthToken;

@Named
@RequestScoped
public class TranscriptionReporter extends SimpleTranscriptionReporter
{

   @Inject
   public TranscriptionReporter(@TwilioAccountSid String accountSid, @TwilioAuthToken String authToken)
   {
      super(accountSid, authToken);
   }

   public TranscriptionReporter()
   {
   }

}