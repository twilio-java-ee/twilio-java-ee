/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package com.twilio.ee.faces.component;

import static com.twilio.ee.faces.component.api.util.NounAttributes.method;
import static com.twilio.ee.faces.component.api.util.NounAttributes.sendDigits;
import static com.twilio.ee.faces.component.api.util.NounAttributes.url;
import static com.twilio.ee.faces.component.api.util.NounAttributes.value;
import static com.twilio.ee.faces.component.api.util.TagUtils.addAttribute;
import static com.twilio.ee.faces.component.api.util.TagUtils.addText;
import static com.twilio.ee.faces.component.api.util.TagUtils.end;
import static com.twilio.ee.faces.component.api.util.TagUtils.start;
import static com.twilio.ee.faces.component.api.util.Verbs.Number;
import static com.twilio.ee.faces.component.api.util.Verbs.number;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import com.twilio.ee.faces.component.api.Component;

@FacesComponent(number)
public class Number extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Number.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), sendDigits.name());
		addAttribute(context, getAttributes(), url.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Number.name());
	}

}