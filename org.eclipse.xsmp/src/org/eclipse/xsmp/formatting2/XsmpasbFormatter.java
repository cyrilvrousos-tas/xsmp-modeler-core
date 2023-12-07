/*******************************************************************************
* Copyright (C) 2020-2022 THALES ALENIA SPACE FRANCE.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
******************************************************************************/
package org.eclipse.xsmp.formatting2;

import org.eclipse.xsmp.xcatalogue.Assembly;
import org.eclipse.xsmp.xcatalogue.Instance;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;

public class XsmpasbFormatter extends AbstractJavaFormatter {

	protected void format(Assembly assembly, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Instance instance : assembly.getInstances()) {
			doc.format(instance);
		}
	}
	
}
