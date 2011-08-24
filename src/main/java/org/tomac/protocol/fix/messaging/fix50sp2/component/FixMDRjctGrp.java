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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.SessionRejectReason;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixMDRjctGrp
{

	public int noAltMDSource;
	public MDRjctGrp[] group;

	public void getAll(int noAltMDSource, ByteBuffer buf) throws FixSessionException {
		this.noAltMDSource = noAltMDSource;

		if (noAltMDSource < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noAltMDSource ).getBytes(), FixTags.NOALTMDSOURCE_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noAltMDSource) {
			group = new MDRjctGrp[noAltMDSource];

			for ( int i = 0; i < noAltMDSource; i++ ) group[i] = new MDRjctGrp();
	}

		for ( int i = 0; i < noAltMDSource; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noAltMDSource; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noAltMDSource; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noAltMDSource; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noAltMDSource; i++)
			s += group[i].toString();
		return s;
	}

public class MDRjctGrp implements FixComponent
{

	public byte[] altMDSourceID;

	public MDRjctGrp() {
		super();

		altMDSourceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( altMDSourceID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.ALTMDSOURCEID_INT) {
				altMDSourceID = FixUtils.getTagStringValue(value, altMDSourceID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

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
		if (FixUtils.isSet(altMDSourceID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(altMDSourceID)) FixUtils.putFixTag( out, FixTags.ALTMDSOURCEID_INT, altMDSourceID, 0, Utils.lastIndexTrim(altMDSourceID, (byte)0) );
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

			if (FixUtils.isSet(altMDSourceID)) s += "AltMDSourceID(817)=" + new String(altMDSourceID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof MDRjctGrp)) return false;

			MDRjctGrp msg = (MDRjctGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( altMDSourceID, msg.altMDSourceID)) return false;

		return true;
	}
}
}
