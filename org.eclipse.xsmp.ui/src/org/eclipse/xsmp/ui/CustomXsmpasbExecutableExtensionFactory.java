/*******************************************************************************
* Copyright (C) 2024 THALES ALENIA SPACE FRANCE.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License 2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
******************************************************************************/
package org.eclipse.xsmp.ui;

import org.eclipse.xsmp.ui.internal.XsmpActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Injector;

public class CustomXsmpasbExecutableExtensionFactory extends XsmpasbExecutableExtensionFactory
{
  @Override
  protected Bundle getBundle()
  {
    return FrameworkUtil.getBundle(XsmpUIPlugin.class);
  }

  @Override
  protected Injector getInjector()
  {
    final var activator = XsmpUIPlugin.getInstance();
    return activator != null ? activator.getInjector(XsmpActivator.ORG_ECLIPSE_XSMP_XSMPASB) : null;
  }

}