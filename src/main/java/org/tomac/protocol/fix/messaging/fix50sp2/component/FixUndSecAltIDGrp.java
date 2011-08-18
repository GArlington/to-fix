package org.tomac.protocol.fix.messaging.fix50sp2.component;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixUndSecAltIDGrp
{

	public int noUnderlyingSecurityAltID;
	public UndSecAltIDGrp[] group;

	public void getAll(int noUnderlyingSecurityAltID, ByteBuffer buf) throws FixSessionException {
		this.noUnderlyingSecurityAltID = noUnderlyingSecurityAltID;

		if (noUnderlyingSecurityAltID < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noUnderlyingSecurityAltID) 
			group = new UndSecAltIDGrp[noUnderlyingSecurityAltID];

		for ( int i = 0; i < noUnderlyingSecurityAltID; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noUnderlyingSecurityAltID; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noUnderlyingSecurityAltID; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noUnderlyingSecurityAltID; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noUnderlyingSecurityAltID; i++)
			s += group[i].toString();
		return s;
	}

public class UndSecAltIDGrp implements FixComponent
{

	public byte[] underlyingSecurityAltID;
	public byte[] underlyingSecurityAltIDSource;

	public UndSecAltIDGrp() {
		super();

		underlyingSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		underlyingSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( underlyingSecurityAltID, (byte)0 );
		Utils.fill( underlyingSecurityAltIDSource, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.UNDERLYINGSECURITYALTID_INT) {
				underlyingSecurityAltID = FixUtils.getTagStringValue(value, underlyingSecurityAltID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.UNDERLYINGSECURITYALTIDSOURCE_INT) {
				underlyingSecurityAltIDSource = FixUtils.getTagStringValue(value, underlyingSecurityAltIDSource);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
			if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

			buf.position( lastTagPosition );
			return;

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(underlyingSecurityAltID)) return true;
		if (FixUtils.isSet(underlyingSecurityAltIDSource)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(underlyingSecurityAltID)) FixUtils.putFixTag( out, FixTags.UNDERLYINGSECURITYALTID_INT, underlyingSecurityAltID, 0, Utils.lastIndexTrim(underlyingSecurityAltID, (byte)0) );
		if (FixUtils.isSet(underlyingSecurityAltIDSource)) FixUtils.putFixTag( out, FixTags.UNDERLYINGSECURITYALTIDSOURCE_INT, underlyingSecurityAltIDSource, 0, Utils.lastIndexTrim(underlyingSecurityAltIDSource, (byte)0) );
	}
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = ( byte )0x01;

		String s = "";

			if (FixUtils.isSet(underlyingSecurityAltID)) s += "UnderlyingSecurityAltID(458)=" + new String(underlyingSecurityAltID) + sep;
			if (FixUtils.isSet(underlyingSecurityAltIDSource)) s += "UnderlyingSecurityAltIDSource(459)=" + new String(underlyingSecurityAltIDSource) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof UndSecAltIDGrp)) return false;

			UndSecAltIDGrp msg = (UndSecAltIDGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( underlyingSecurityAltID, msg.underlyingSecurityAltID)) return false;

		if (!Utils.equals( underlyingSecurityAltIDSource, msg.underlyingSecurityAltIDSource)) return false;

		return true;
	}
}
}