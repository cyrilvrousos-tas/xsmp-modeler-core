/*******************************************************************************
* Copyright (C) 2020-2023 THALES ALENIA SPACE FRANCE.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
******************************************************************************/
package org.eclipse.xsmp.formatting2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsmp.xcatalogue.Assembly;
import org.eclipse.xsmp.xcatalogue.Connection;
import org.eclipse.xtext.formatting2.IFormattableDocument;

public class XsmpasbFormatter extends XsmpcoreFormatter {

	protected void format(Assembly assembly, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (EObject eObject : assembly.getMember()) {
			doc.format(eObject);
		}
	}

	protected void format(Connection connection, IFormattableDocument doc) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		doc.format(connection.getOutput());
		doc.format(connection.getInput());
	}
	
	// TODO: implement for Setter, Instance, Namespace, Factory, Simulator, Path
}
