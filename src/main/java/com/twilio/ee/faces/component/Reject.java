/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ package com.twilio.ee.faces.component;

import static com.twilio.ee.faces.component.api.util.NounAttributes.reason;
import static com.twilio.ee.faces.component.api.util.TagUtils.addAttribute;
import static com.twilio.ee.faces.component.api.util.TagUtils.end;
import static com.twilio.ee.faces.component.api.util.TagUtils.start;
import static com.twilio.ee.faces.component.api.util.Verbs.Reject;
import static com.twilio.ee.faces.component.api.util.Verbs.reject;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.twilio.ee.faces.component.api.Component;

@FacesComponent(reject)
public class Reject extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Reject.name());
		addAttribute(context, getAttributes(), reason.name());
		end(context, Reject.name());
	}

}