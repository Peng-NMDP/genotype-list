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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * Unit test for GenotypeList.
 */
public final class GenotypeListTest {
    private final Locus locus = new Locus("http://immunogenomics.org/locus/0", "HLA-A");
    private final Allele allele0 = new Allele("http://immunogenomics.org/allele/0", "A00001", "HLA-A*01:01:01:01", locus);
    private final Allele allele1 = new Allele("http://immunogenomics.org/allele/1", "A00002", "HLA-A*02:01:01:01", locus);
    private final AlleleList alleleList0 = new AlleleList("http://immunogenomics.org/allele-list/0", ImmutableList.of(allele0));
    private final AlleleList alleleList1 = new AlleleList("http://immunogenomics.org/allele-list/1", ImmutableList.of(allele1));
    private final Haplotype haplotype0 = new Haplotype("http://immunogenomics.org/haplotype/0", alleleList0);
    private final Haplotype haplotype1 = new Haplotype("http://immunogenomics.org/haplotype/1", alleleList1);
    private final List<Haplotype> haplotypes = ImmutableList.of(haplotype0, haplotype1);
    private final Genotype genotype0 = new Genotype("http://immunogenomics.org/genotype/0", haplotypes);
    private final Genotype genotype1 = new Genotype("http://immunogenomics.org/genotype/1", haplotypes);
    private final List<Genotype> empty = Collections.emptyList();
    private final List<Genotype> single = ImmutableList.of(genotype0);
    private final List<Genotype> genotypes = ImmutableList.of(genotype0, genotype1);

    @Test(expected=NullPointerException.class)
    public void testConstructorNullIdentifierGenotype() {
        new GenotypeList(null, genotype0);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullGenotype() {
        new GenotypeList("http://immunogenomics.org/genotype-list/0", (Genotype) null);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullIdentifierGenotypes() {
        new GenotypeList(null, genotypes);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullGenotypes() {
        new GenotypeList("http://immunogenomics.org/genotype-list/0", (List<Genotype>) null);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorNullGenotypeInGenotypeList() {
        List<Genotype> genotypesContainingNull = new ArrayList<Genotype>();
        genotypesContainingNull.add(genotype0);
        genotypesContainingNull.add(null);
        new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypesContainingNull);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorEmptyGenotypes() {
        new GenotypeList("http://immunogenomics.org/genotype-list/0", empty);
    }

    @Test
    public void testConstructorSingleGenotypes() {
        GenotypeList genotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/0", single);
        assertEquals(single, genotypeList.getGenotypes());
    }

    @Test
    public void testId() {
        GenotypeList genotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);
        assertEquals("http://immunogenomics.org/genotype-list/0", genotypeList.getId());
    }

    @Test
    public void testGlstring() {
        GenotypeList genotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);
        assertEquals("HLA-A*01:01:01:01+HLA-A*02:01:01:01|HLA-A*01:01:01:01+HLA-A*02:01:01:01", genotypeList.getGlstring());
    }

    @Test
    public void testGenotype() {
        GenotypeList genotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotype0);
        assertEquals(1, genotypeList.getGenotypes().size());
        assertTrue(genotypeList.getGenotypes().contains(genotype0));
    }

    @Test
    public void testGenotypes() {
        GenotypeList genotypeList = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);
        assertEquals(genotypes, genotypeList.getGenotypes());
    }

    @Test
    public void testHashCode() {
        GenotypeList a = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);
        GenotypeList sameA = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);

        assertEquals(a.hashCode(), sameA.hashCode());
    }

    @Test
    public void testEquals() {
        GenotypeList a = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);
        GenotypeList altA = new GenotypeList("http://alt.immunogenomics.org/genotype-list/0", genotypes);
        GenotypeList differentGlstring = new GenotypeList("http://immunogenomics.org/genotype-list/0", single);
        GenotypeList sameA = new GenotypeList("http://immunogenomics.org/genotype-list/0", genotypes);
        GenotypeList b = new GenotypeList("http://immunogenomics.org/genotype-list/1", single);

        assertFalse(a.equals(null));
        assertFalse(a.equals(new Object()));
        assertTrue(a.equals(a));
        assertFalse(a.equals(b));
        assertFalse(a.equals(altA));
        assertFalse(a.equals(differentGlstring));
        assertTrue(a.equals(sameA));
    }
}
