/*

    gl-imgt-db  IMGT/HLA database persistence domain and data access objects for the gl project.
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
package org.immunogenomics.gl.imgt.db.dto;

import org.immunogenomics.gl.imgt.db.model.Allele;

/**
 * @author Adrienne N. Walts (awalts) <awalts@nmdp.org> Operational Bioinformatics, National Marrow Donor Program
 *
 */
public class IncompleteAlleleDto {

	private Allele partialAllele;
	private Allele extensionAllele;
	/**
	 * @return the partialAllele
	 */
	public Allele getPartialAllele() {
		return partialAllele;
	}
	/**
	 * @param partialAllele the partialAllele to set
	 */
	public void setPartialAllele(Allele partialAllele) {
		this.partialAllele = partialAllele;
	}
	/**
	 * @return the extensionAllele
	 */
	public Allele getExtensionAllele() {
		return extensionAllele;
	}
	/**
	 * @param extensionAllele the extensionAllele to set
	 */
	public void setExtensionAllele(Allele extensionAllele) {
		this.extensionAllele = extensionAllele;
	}

} // end class
