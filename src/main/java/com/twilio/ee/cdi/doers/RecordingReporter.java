package com.twilio.ee.cdi.doers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.twilio.ee.cdi.doers.simple.SimpleRecordingReporter;
import com.twilio.ee.inject.configuration.TwilioAccountSid;
import com.twilio.ee.inject.configuration.TwilioAuthToken;

@Named
@RequestScoped
public class RecordingReporter extends SimpleRecordingReporter
{

   @Inject
   public RecordingReporter(@TwilioAccountSid String accountSid, @TwilioAuthToken String authToken)
   {
      super(accountSid, authToken);
   }

   public RecordingReporter()
   {
   }

}
