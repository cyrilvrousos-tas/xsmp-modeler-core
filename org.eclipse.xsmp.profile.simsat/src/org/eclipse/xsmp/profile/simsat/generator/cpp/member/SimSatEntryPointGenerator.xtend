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
package org.eclipse.xsmp.profile.simsat.generator.cpp.member

import org.eclipse.xsmp.generator.cpp.IncludeAcceptor
import org.eclipse.xsmp.generator.cpp.member.EntryPointGenerator
import org.eclipse.xsmp.xcatalogue.EntryPoint
import org.eclipse.xsmp.xcatalogue.NamedElementWithMembers

class SimSatEntryPointGenerator extends EntryPointGenerator {

    protected override collectIncludes(IncludeAcceptor acceptor) {
        super.collectIncludes(acceptor)
        acceptor.mdkSource("esa/ecss/smp/cdk/EntryPoint.h")
    }

    override initialize(NamedElementWithMembers container, EntryPoint element, boolean useGenPattern) {
        '''
            // EntryPoint: «element.name»
            «element.name» { new ::esa::ecss::smp::cdk::EntryPoint( "«element.name»",  «element.description()»,  this, simulator, &«container.name(useGenPattern)»::_«element.name») }
        '''
    }

    override construct(NamedElementWithMembers container, EntryPoint element, boolean useGenPattern) {
        '''
            if (!this->GetEntryPoint("«element.name»"))
            {
                // Use existing implementation to manage Entry Points
                this->AddEntryPoint(«element.name»);
            }
            else
            {
                Log(Smp::Services::ILogger::LMK_Error, "EntryPoint «element.name» redeclared");
            }
        '''
    }
}
