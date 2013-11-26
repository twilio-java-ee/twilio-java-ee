/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package com.twilio.ee.faces.component.api;

import static com.twilio.ee.faces.component.api.util.Constants.FAMILY;
import static com.twilio.ee.faces.component.api.util.Constants.RENDER_TYPE;

import javax.faces.component.UIOutput;

public class Component extends UIOutput {

	@Override
	public String getFamily() {
		return FAMILY;
	}

	@Override
	public String getRendererType() {
		return RENDER_TYPE;
	}

}
