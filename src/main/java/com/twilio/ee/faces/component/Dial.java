/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package com.twilio.ee.faces.component;

import static com.twilio.ee.faces.component.api.util.NounAttributes.action;
import static com.twilio.ee.faces.component.api.util.NounAttributes.callerId;
import static com.twilio.ee.faces.component.api.util.NounAttributes.hangupOnStar;
import static com.twilio.ee.faces.component.api.util.NounAttributes.method;
import static com.twilio.ee.faces.component.api.util.NounAttributes.record;
import static com.twilio.ee.faces.component.api.util.NounAttributes.timeLimit;
import static com.twilio.ee.faces.component.api.util.NounAttributes.timeout;
import static com.twilio.ee.faces.component.api.util.NounAttributes.value;
import static com.twilio.ee.faces.component.api.util.TagUtils.addAttribute;
import static com.twilio.ee.faces.component.api.util.TagUtils.addText;
import static com.twilio.ee.faces.component.api.util.TagUtils.end;
import static com.twilio.ee.faces.component.api.util.TagUtils.start;
import static com.twilio.ee.faces.component.api.util.Verbs.Dial;
import static com.twilio.ee.faces.component.api.util.Verbs.dial;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.twilio.ee.faces.component.api.Component;

@FacesComponent(dial)
public class Dial extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Dial.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), hangupOnStar.name());
		addAttribute(context, getAttributes(), timeLimit.name());
		addAttribute(context, getAttributes(), callerId.name());
		addAttribute(context, getAttributes(), record.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Dial.name());
	}

}