package org.eclipse.xsmp.ui;

import org.eclipse.xsmp.ui.internal.XsmpActivator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Injector;

public class Xsmpasb2ExecutableExtensionFactory extends XsmpasbExecutableExtensionFactory
{
  @Override
  protected Bundle getBundle()
  {
    return FrameworkUtil.getBundle(XsmpcatUIPlugin.class);
  }
  

  @Override
  protected Injector getInjector()
  {
    final var activator = XsmpcatUIPlugin.getInstance();
    return activator != null ? activator.getInjector(XsmpActivator.ORG_ECLIPSE_XSMP_XSMPASB) : null;
  }

}
