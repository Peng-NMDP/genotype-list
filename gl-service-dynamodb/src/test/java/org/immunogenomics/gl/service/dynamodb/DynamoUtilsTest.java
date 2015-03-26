/*

    gl-service-dynamodb  Implementation of persistent cache for gl-service using DynamoDB.
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
package org.immunogenomics.gl.service.dynamodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.immunogenomics.gl.service.dynamodb.DynamoUtils.hash;
import static org.immunogenomics.gl.service.dynamodb.DynamoUtils.deserialize;
import static org.immunogenomics.gl.service.dynamodb.DynamoUtils.serialize;

import org.junit.Test;

import org.immunogenomics.gl.Locus;

/**
 * Unit test for DynamoUtils.
 */
public final class DynamoUtilsTest {

    @Test(expected=NullPointerException.class)
    public void testHashNull() {
        hash(null);
    }

    @Test
    public void testHashEmpty() {
        assertNotNull(hash(""));
    }

    @Test
    public void testHash() {
        byte[] bytes = hash("HLA-A*01:01:01:01/HLA-A*01:01:01:02");
        assertNotNull(bytes);
        assertTrue(bytes.length > 0);
    }

    @Test
    public void testSerialize() {
        assertNotNull(serialize(new Locus("http://immunogenomics.org/locus/0", "HLA-A")));
    }

    @Test
    public void testDeserialize() {
        byte[] bytes = serialize(new Locus("http://immunogenomics.org/locus/0", "HLA-A"));
        Locus locus = (Locus) deserialize(bytes);
        assertNotNull(locus);
        assertEquals("http://immunogenomics.org/locus/0", locus.getId());
        assertEquals("HLA-A", locus.getGlstring());
    }
}