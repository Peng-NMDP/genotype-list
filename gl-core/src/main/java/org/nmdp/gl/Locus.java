/*

    gl-core  Core interfaces and classes for the gl project.
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
package org.nmdp.gl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.concurrent.Immutable;

/**
 * A locus identifies a genomic location at which alleles may be defined. The locus representation
 * in GL String format must not contain any of the following characters: '<code>*</code>',
 * '<code>/</code>', '<code>~</code>', '<code>+</code>', '<code>|</code>',
 * or '<code>^</code>'.
 */
@Immutable
public final class Locus extends GlResource implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String glstring;


    /**
     * Create a new locus with the specified identifier and glstring.
     *
     * @param id identifier for this locus, must not be null
     * @param glstring representation of this locus in GL String format, must not be null
     */
    public Locus(final String id, final String glstring) {
        super(id);
        checkNotNull(glstring, "glstring must not be null");
        this.glstring = glstring;
    }


    @Override
    public String getGlstring() {
        return glstring;
    }

    @Override
    public String toString() {
        return glstring;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGlstring());
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Locus)) {
            return false;
        }
        Locus locus = (Locus) o;
        return Objects.equals(getId(), locus.getId())
            && Objects.equals(getGlstring(), locus.getGlstring());
    }
}
