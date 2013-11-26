/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package com.twilio.ee.faces.component;

import static com.twilio.ee.faces.component.api.util.NounAttributes.action;
import static com.twilio.ee.faces.component.api.util.NounAttributes.finishOnKey;
import static com.twilio.ee.faces.component.api.util.NounAttributes.maxLength;
import static com.twilio.ee.faces.component.api.util.NounAttributes.method;
import static com.twilio.ee.faces.component.api.util.NounAttributes.playBeep;
import static com.twilio.ee.faces.component.api.util.NounAttributes.timeout;
import static com.twilio.ee.faces.component.api.util.NounAttributes.transcribe;
import static com.twilio.ee.faces.component.api.util.NounAttributes.transcribeCallback;
import static com.twilio.ee.faces.component.api.util.TagUtils.addAttribute;
import static com.twilio.ee.faces.component.api.util.TagUtils.end;
import static com.twilio.ee.faces.component.api.util.TagUtils.start;
import static com.twilio.ee.faces.component.api.util.Verbs.Record;
import static com.twilio.ee.faces.component.api.util.Verbs.record;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.twilio.ee.faces.component.api.Component;

@FacesComponent(record)
public class Record extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Record.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), finishOnKey.name());
		addAttribute(context, getAttributes(), maxLength.name());
		addAttribute(context, getAttributes(), transcribe.name());
		addAttribute(context, getAttributes(), transcribeCallback.name());
		addAttribute(context, getAttributes(), playBeep.name());
		end(context, Record.name());
	}

}