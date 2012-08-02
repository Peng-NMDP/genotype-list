/*

    gl-core  Core interfaces and classes for the gl project.
    Copyright (c) 2012 National Marrow Donor Program (NMDP)

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
package org.immunogenomics.gl;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import javax.annotation.concurrent.Immutable;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * A genotype list is an unordered collection of one or more genotypes representing genotypic
 * ambiguity separated in GL String format by the character '<code>|</code>'.
 */
@Immutable
public final class GenotypeList extends GlResource implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String glstring;
    private final List<Genotype> genotypes;


    /**
     * Create a new genotype list with the specified identifier and genotype.
     *
     * @param id identifier for this genotype list, must not be null
     * @param genotype genotype for this genotype list, must not be null
     */
    public GenotypeList(final String id, final Genotype genotype) {
        this(id, ImmutableList.of(genotype));
    }

    /**
     * Create a new genotype list with the specified identifier and list of genotypes.
     *
     * @param id identifier for this genotype list, must not be null
     * @param genotypes list of genotypes for this genotype list, must not be null,
     *    must contain at least one genotype, and must not contain any null genotypes
     */
    public GenotypeList(final String id, final List<Genotype> genotypes) {
        super(id);
        checkNotNull(genotypes, "genotypes must not be null");
        if (genotypes.isEmpty()) {
            throw new IllegalArgumentException("genotypes must contain at least one genotype");
        }
        this.genotypes = ImmutableList.copyOf(genotypes);
        this.glstring = Joiner.on("|").join(this.genotypes);
    }


    @Override
    public String getGlstring() {
        return glstring;
    }

    /**
     * Return the list of genotypes for this genotype list.
     *
     * @return the list of genotypes for this genotype list
     */
    public List<Genotype> getGenotypes() {
        return genotypes;
    }

    @Override
    public String toString() {
        return glstring;
    }
}