/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.twilio.ee.cdi.producer;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import com.twilio.ee.cdi.doers.Client;
import com.twilio.ee.cdi.producer.util.ELUtils;
import com.twilio.ee.inject.capability.TwilioCapabilityToken;

public class TwilioCapabilityProducer implements Serializable
{
   Logger logger = Logger.getLogger(getClass().getName());
   private static final long serialVersionUID = 1L;

   @Inject
   FacesContext facesContext;

   @Inject
   Client twilioClient;

   /**
    * 
    * @return the token usable in javascript code
    * @param injectionPoint : you can use a resolvable expression like #{loginController.username}" or simple string
    *           like 'client'
    */
   @Produces
   @TwilioCapabilityToken
   public String getTwilioCapabilityToken(InjectionPoint injectionPoint)
   {
      String client = injectionPoint.getAnnotated()
               .getAnnotation(TwilioCapabilityToken.class).client();
      if (client == null)
         return "";
      if (ELUtils.isElExpression(client))
      {
         client = ELUtils.resolveElExpression(client, facesContext);
      }
      return twilioClient.generateToken(client);
   }
}
