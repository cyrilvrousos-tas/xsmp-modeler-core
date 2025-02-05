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
package org.eclipse.xsmp.validation;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xsmp.xcatalogue.Document;
import org.eclipse.xsmp.xcatalogue.NamedElement;
import org.eclipse.xsmp.xcatalogue.Operation;
import org.eclipse.xsmp.xcatalogue.Parameter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

public class SmpNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper
{
  /**
   * {@inheritDoc}
   */
  @Override
  public void checkUniqueNames(Context context, ValidationMessageAcceptor acceptor)
  {
    doCheckUniqueNames(context, acceptor);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean isDuplicate(IEObjectDescription description, IEObjectDescription candidate)
  {

    boolean result;
    final var first = description.getEObjectOrProxy();
    final var second = candidate.getEObjectOrProxy();

    if (first instanceof Document || second instanceof Document)
    {
      result = first instanceof Document && second instanceof Document;
    }
    // 2 namespaces can have the same name except if they are in the same catalogue
    else if (first instanceof NamedElement && second instanceof NamedElement)
    {
      result = description.getEObjectURI().path().equals(candidate.getEObjectURI().path());
    }
    // 2 operation must have different signatures
    else if (first instanceof Operation && second instanceof Operation)
    {
      result = description.getUserData("sig").equals(candidate.getUserData("sig"));
    }
    // parameters inside the same operation must have different names
    else if (first instanceof Parameter && second instanceof Parameter)
    {
      result = first.eContainer() == EcoreUtil.resolve(second, first).eContainer();
    }
    // ignore parameters
    else
    {
      result = !(first instanceof Parameter) && !(second instanceof Parameter);
    }

    return result;
  }
}
