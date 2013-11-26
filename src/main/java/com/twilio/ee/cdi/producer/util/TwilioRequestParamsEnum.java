/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.twilio.ee.cdi.producer.util;

public enum TwilioRequestParamsEnum
{
   AccountSid,
   ApiVersion,
   ApplicationSid,
   Body,
   Caller,
   CallerName,
   CallSid,
   CallStatus,

   DialSipCallId,
   DialSipResponseCode,
   DialSipHeader,
   DialSipHeader_,
   Digits,
   Direction,
   ForwardedFrom,
   From,
   FromCity,
   FromCountry,
   FromState,
   FromZip,

   MediaContentType,
   MediaContentTypes,
   MediaUrl,
   MediaUrls,
   MessageSid,

   NumMedia,

   PhoneNumber,

   RecordingDuration,
   RecordingSid,
   RecordingUrl,

   SipCallId,
   SipHeader,
   SmsSid,
   SmsStatus,

   To,
   ToCountry,
   ToCity,
   ToState,
   ToZip,
   TranscriptionSid,
   TranscriptionText,
   TranscriptionStatus,
   TranscriptionUrl;

   public String toProperty()
   {
      return Character.toLowerCase(
               this.name().charAt(0)) + (this.name().length() > 1 ? this.name().substring(1) : "");
   }
}
