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
package org.immunogenomics.gl.imgt.db.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the ALIGNMENT_REFERENCE database table.
 *
 */
@Entity
@Table(name="ALIGNMENT_REFERENCE")
public class AlignmentReference implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name="ALIGNMENT_REFERENCE_ALIGNMENTREFERENCEIID_GENERATOR", sequenceName="SEQ_ALIGNMENT_REFERENCE")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALIGNMENT_REFERENCE_ALIGNMENTREFERENCEIID_GENERATOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ALIGNMENT_REFERENCE_IID", unique=true, nullable=false, precision=9)
	private long alignmentReferenceIid;

    @Temporal( TemporalType.DATE)
	@Column(name="CREATE_DTE", nullable=false)
	private Date createDte;

    @Temporal( TemporalType.DATE)
	@Column(name="LAST_UPDATE_DTE", nullable=false)
	private Date lastUpdateDte;

	@Column(name="LAST_UPDATE_USER_ID", nullable=false, length=10)
	private String lastUpdateUserId;

	@Column(name="REFERENCE_ALLELE_NAME", length=50)
	private String referenceAlleleName;

	//bi-directional many-to-one association to Sequence
    @ManyToOne
	@JoinColumn(name="SEQUENCE_IID", nullable=false)
	private Sequence sequence;

    public AlignmentReference() {
    }

	public long getAlignmentReferenceIid() {
		return this.alignmentReferenceIid;
	}

	public void setAlignmentReferenceIid(long alignmentReferenceIid) {
		this.alignmentReferenceIid = alignmentReferenceIid;
	}

	public Date getCreateDte() {
		return this.createDte;
	}

	public void setCreateDte(Date createDte) {
		this.createDte = createDte;
	}

	public Date getLastUpdateDte() {
		return this.lastUpdateDte;
	}

	public void setLastUpdateDte(Date lastUpdateDte) {
		this.lastUpdateDte = lastUpdateDte;
	}

	public String getLastUpdateUserId() {
		return this.lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getReferenceAlleleName() {
		return this.referenceAlleleName;
	}

	public void setReferenceAlleleName(String referenceAlleleName) {
		this.referenceAlleleName = referenceAlleleName;
	}

	public Sequence getSequence() {
		return this.sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

}