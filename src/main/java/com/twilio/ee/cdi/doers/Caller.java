/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.twilio.ee.cdi.doers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.twilio.ee.cdi.doers.simple.SimpleCaller;
import com.twilio.ee.inject.configuration.TwilioAccountSid;
import com.twilio.ee.inject.configuration.TwilioAuthToken;
import com.twilio.ee.inject.configuration.TwilioNumber;

@Named
@RequestScoped
public class Caller extends SimpleCaller
{

   @Inject
   public Caller(@TwilioNumber String from,
            @TwilioAccountSid String accountSid, @TwilioAuthToken String authToken)
   {
      super(from, accountSid, authToken);
   }

   public Caller()
   {
   }
}
