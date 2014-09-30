/*

    gl-ambiguity-service-spark  Implementation of a RESTful genotype list ambiguity service using Spark.
    Copyright (c) 2012-2014 National Marrow Donor Program (NMDP)

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
package org.immunogenomics.gl.ambiguity.spark;

import static org.junit.Assert.assertNotNull;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import org.immunogenomics.gl.ambiguity.AmbiguityService2;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Unit test for SparkAmbiguityServiceModule.
 */
public final class SparkAmbiguityServiceModuleTest {
    private SparkAmbiguityServiceModule ambiguityServiceModule;

    @Mock
    private AmbiguityService2 ambiguityService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ambiguityServiceModule = new SparkAmbiguityServiceModule();
    }

    @Test
    public void testConstructor() {
        assertNotNull(ambiguityServiceModule);
    }

    @Test
    public void testAmbiguityServiceModule() {
        Injector injector = Guice.createInjector(ambiguityServiceModule, new TestModule());
        assertNotNull(injector);
    }

    /**
     * Test module.
     */
    private class TestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(AmbiguityService2.class).toInstance(ambiguityService);
        }
    }
}
