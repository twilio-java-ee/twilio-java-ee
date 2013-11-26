/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.twilio.ee.cdi.event;

public class StatusCallbackEvent
{
   private String callSid;
   private String accountSid;
   private String from;
   private String to;
   private String callStatus;
   private String apiVersion;
   private String direction;
   private String forwardedFrom;
   private String callerName;

   public StatusCallbackEvent()
   {
   }

   public StatusCallbackEvent(String callSid, String accountSid, String from,
            String to, String callStatus, String apiVersion, String direction,
            String forwardedFrom, String callerName)
   {
      this.callSid = callSid;
      this.accountSid = accountSid;
      this.from = from;
      this.to = to;
      this.callStatus = callStatus;
      this.apiVersion = apiVersion;
      this.direction = direction;
      this.forwardedFrom = forwardedFrom;
      this.callerName = callerName;
   }

   @Override
   public String toString()
   {
      return "StatusCallbackEvent: [" +
               ((callSid != null && !callSid.isEmpty()) ? " callSid=" + callSid : "")
              +((accountSid != null && !accountSid.isEmpty()) ? " accountSid=" + accountSid : "") 
              +((from != null && !from.isEmpty()) ? " from=" + from : "") 
              +((to != null && !to.isEmpty()) ? " to=" + to : "") 
              +((callStatus != null && !callStatus.isEmpty()) ? " callStatus=" + callStatus : "") 
              +((apiVersion != null && !apiVersion.isEmpty()) ?" apiVersion=" + apiVersion : "") 
              +((direction != null && !direction.isEmpty()) ? " direction=" + direction : "") 
              +((forwardedFrom != null && !forwardedFrom.isEmpty()) ? " forwardedFrom=" + forwardedFrom : "") 
              +((callerName != null && !callerName.isEmpty()) ? " callerName=" + callerName : "")
              +"]";
   }

   public String getCallSid()
   {
      return callSid;
   }

   public void setCallSid(String callSid)
   {
      this.callSid = callSid;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public void setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
   }

   public String getFrom()
   {
      return from;
   }

   public void setFrom(String from)
   {
      this.from = from;
   }

   public String getTo()
   {
      return to;
   }

   public void setTo(String to)
   {
      this.to = to;
   }

   public String getCallStatus()
   {
      return callStatus;
   }

   public void setCallStatus(String callStatus)
   {
      this.callStatus = callStatus;
   }

   public String getApiVersion()
   {
      return apiVersion;
   }

   public void setApiVersion(String apiVersion)
   {
      this.apiVersion = apiVersion;
   }

   public String getDirection()
   {
      return direction;
   }

   public void setDirection(String direction)
   {
      this.direction = direction;
   }

   public String getForwardedFrom()
   {
      return forwardedFrom;
   }

   public void setForwardedFrom(String forwardedFrom)
   {
      this.forwardedFrom = forwardedFrom;
   }

   public String getCallerName()
   {
      return callerName;
   }

   public void setCallerName(String callerName)
   {
      this.callerName = callerName;
   }

}
