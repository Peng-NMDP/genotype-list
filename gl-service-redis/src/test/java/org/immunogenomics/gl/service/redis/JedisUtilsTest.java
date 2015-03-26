/*

    gl-service-redis  Implementation of persistent cache for gl-service using Redis+jedis.
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
package org.immunogenomics.gl.service.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.immunogenomics.gl.service.redis.JedisUtils.encode;
import static org.immunogenomics.gl.service.redis.JedisUtils.deserialize;
import static org.immunogenomics.gl.service.redis.JedisUtils.serialize;

import org.junit.Test;

import org.immunogenomics.gl.Locus;

/**
 * Unit test for JedisUtils.
 */
public final class JedisUtilsTest {

    @Test
    public void testEncode() {
        assertNotNull(encode("http://immunogenomics.org/locus/0"));
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