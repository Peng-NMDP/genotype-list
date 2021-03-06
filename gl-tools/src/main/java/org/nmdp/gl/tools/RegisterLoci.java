/*

    gl-tools  Genotype list tools.
    Copyright (c) 2012-2015 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.fsf.org/licensing/licenses/lgpl.html
    > http://www.opensource.org/licenses/lgpl-license.php

*/
package org.nmdp.gl.tools;

import java.io.File;

import org.nmdp.gl.client.GlClient;
import org.nmdp.gl.client.GlClientException;

import com.google.inject.Injector;
import com.google.inject.Key;

/**
 * Register loci task.
 */
public final class RegisterLoci extends AbstractRegisterTask {

    /**
     * Create a new register loci task.
     *
     * @param glstringFile glstring file
     * @param identifierFile identifier file
     * @param client gl client, must not be null
     */
    public RegisterLoci(final File glstringFile, final File identifierFile, final GlClient client) {
        super(glstringFile, identifierFile, client);
    }

    @Override
    protected String register(String glstring) throws GlClientException {
        return client.registerLocus(glstring);
    }

    /**
     * Main.
     *
     * @param args command line arguments
     */
    public static final void main(final String[] args) {
        Injector injector = init("gl-register-loci", args);
        File glstringFile = injector.getInstance(Key.get(File.class, GlstringFile.class));
        File identifierFile = injector.getInstance(Key.get(File.class, IdentifierFile.class));
        GlClient client = injector.getInstance(GlClient.class);

        new RegisterLoci(glstringFile, identifierFile, client).run();
    }
}
