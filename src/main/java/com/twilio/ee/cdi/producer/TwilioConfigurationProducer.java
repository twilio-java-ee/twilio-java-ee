/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.twilio.ee.cdi.producer;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import com.twilio.ee.cdi.doers.CallReporter;
import com.twilio.ee.cdi.doers.Caller;
import com.twilio.ee.cdi.doers.MsgReporter;
import com.twilio.ee.cdi.doers.Sender;
import com.twilio.ee.cdi.extension.TwilioManager;
import com.twilio.ee.cdi.extension.util.Account;
import com.twilio.ee.cdi.producer.util.ELUtils;
import com.twilio.ee.inject.configuration.TwilioAccount;
import com.twilio.ee.inject.configuration.TwilioAccountSid;
import com.twilio.ee.inject.configuration.TwilioAuthToken;
import com.twilio.ee.inject.configuration.TwilioConnectAppSid;
import com.twilio.ee.inject.configuration.TwilioNumber;

public class TwilioConfigurationProducer implements Serializable
{

   private static final long serialVersionUID = 1L;
   @Inject
   FacesContext facesContext;

   @Inject
   TwilioManager twilioManager;

   @Produces
   @TwilioConnectAppSid
   public String getTwilioConnectAppSid(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioConnectAppSid.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.equals("default"))
            return twilioManager.getApplicationSid();
         else
         {
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               Account twilioAccount = twilioManager.getAccount(accountName);
               if (twilioAccount != null)
                  return twilioAccount.getApplicationSid();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioNumber
   public String getTwilioNumber(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioNumber.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.equals("default"))
            return twilioManager.getTwilioNumber();
         else
         {
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               Account twilioAccount = twilioManager.getAccount(accountName);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioNumber();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccountSid
   public String getTwilioAccountSid(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccountSid.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return twilioManager.getTwilioSid();
         else
         {
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               Account account = twilioManager.getAccount(accountName);
               if (account != null)
                  return account.getTwilioSid();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAuthToken
   public String getTwilioAuthToken(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAuthToken.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return twilioManager.getTwilioToken();
         else
         {
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               Account account = twilioManager.getAccount(accountName);
               if (account != null)
                  return account.getTwilioToken();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccount
   public Account getTwilioAccount(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccount.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return twilioManager.getDefaultAccount();
         else
         {
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
               return twilioManager.getAccount(accountName);
         }
      }
      return null;
   }

   @Produces
   @TwilioAccount
   public Caller getTwilioCaller(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccount.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return new Caller(twilioManager.getDefaultAccount().getTwilioNumber(), twilioManager.getDefaultAccount()
                     .getTwilioSid(), twilioManager.getDefaultAccount().getTwilioToken());
         else
         {
            Account account;
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               account = twilioManager.getAccount(accountName);
               if (account != null)
                  return new Caller(account.getTwilioNumber(), account
                           .getTwilioSid(), account.getTwilioToken());
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccount
   public Sender getTwilioSender(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccount.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return new Sender(twilioManager.getDefaultAccount().getTwilioNumber(), twilioManager.getDefaultAccount()
                     .getTwilioSid(), twilioManager.getDefaultAccount().getTwilioToken());
         else
         {
            Account account;
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               account = twilioManager.getAccount(accountName);
               if (account != null)
                  return new Sender(account.getTwilioNumber(), account
                           .getTwilioSid(), account.getTwilioToken());
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccount
   public MsgReporter getMsgReporter(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccount.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return new MsgReporter(twilioManager
                     .getDefaultAccount()
                     .getTwilioSid(), twilioManager.getDefaultAccount().getTwilioToken());
         else
         {
            Account account;
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               account = twilioManager.getAccount(accountName);
               if (account != null)
                  return new MsgReporter(account
                           .getTwilioSid(), account.getTwilioToken());
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccount
   public CallReporter getCallReporter(InjectionPoint injectionPoint)
   {
      String accountName = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccount.class).accountName();
      if (twilioManager != null)
      {
         if (accountName == null || accountName.isEmpty() || accountName.toLowerCase().equals("default"))
            return new CallReporter(twilioManager
                     .getDefaultAccount()
                     .getTwilioSid(), twilioManager.getDefaultAccount().getTwilioToken());
         else
         {
            Account account;
            if (ELUtils.isElExpression(accountName))
            {
               accountName = ELUtils.resolveElExpression(accountName, facesContext);
            }
            if (accountName != null)
            {
               account = twilioManager.getAccount(accountName);
               if (account != null)
                  return new CallReporter(account
                           .getTwilioSid(), account.getTwilioToken());
            }
         }
      }
      return null;
   }
}
