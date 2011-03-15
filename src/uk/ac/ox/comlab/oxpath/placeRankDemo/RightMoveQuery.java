/*
 * Copyright (c)2011, DIADEM Team
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the DIADEM team nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DIADEM Team BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * 
 */
package uk.ac.ox.comlab.oxpath.placeRankDemo;

/**
 * Class for objects encoding Right Move queries 
 * @author AndrewJSel
 *
 */
public class RightMoveQuery implements SiteQuery {

	/**
	 * Basic Constuctor for Right Move Query
	 * @param iBeds number of beds 
	 * @param iMaxRent maximum rent
	 * @param isFurn is Furnished
	 * @param isLong is available longterm
	 */
	public RightMoveQuery(int iBeds, RightMoveRentPrice iMaxRent, boolean isFurn, boolean isLong) {
		this.beds = iBeds;
		this.maxRent = iMaxRent;
		this.isFurnished = isFurn;
		this.isLongterm = isLong;
	}
	
	/* (non-Javadoc)
	 * @see uk.ac.ox.comlab.oxpath.placeRankDemo.SiteQuery#getOXPath(java.lang.String)
	 */
	/**
	 * Method for returning OXPath expression for this object, given a specific postcode
	 * @param postcode post code for query
	 * @return OXPath expression from this object for the given postcode
	 */
	@Override
	public String getOXPath(String postcode) {
		StringBuilder sb = new StringBuilder();
		sb.append("path={<http://www.rightmove.co.uk>/}/descendant::field()[1]/{\"");
		sb.append(postcode);
		sb.append("\"}/following::input#rent/{click/}//select#minBedrooms/{\"");
		sb.append(this.beds);
		sb.append("\"/}//select#maxPrice/{\"");
		sb.append(this.maxRent.toString());
		sb.append("/}//input[@id='submit']/{click/}/(//a[.#='next']/{click/})*//ol#summaries/li");
		if (this.isFurnished||this.isLongterm) {
			sb.append("[descendant::a[.#='More details']/{click/}//div#propertydetails");
			if (this.isFurnished) sb.append("[.#='Furnished']");
			if (this.isLongterm) sb.append("[not(.#='Short term')]");
			sb.append("]:<property=(.)>;");
		}
		return sb.toString();
	}

	//instance fields
	/**
	 * Number of beds (private instance field)
	 */
	private int beds;
	/**
	 * Maximum Rent (private instance field)
	 */
	private RightMoveRentPrice maxRent;
	/**
	 * Is Furnished (private instance field)
	 */
	boolean isFurnished;
	/**
	 * Is Longterm (private instance field)
	 */
	boolean isLongterm;
	
}