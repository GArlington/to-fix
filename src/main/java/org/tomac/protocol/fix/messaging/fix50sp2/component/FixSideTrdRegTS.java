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

public class FixSideTrdRegTS
{

	public int noSideTrdRegTS;
	public SideTrdRegTS[] group;

	public void getAll(int noSideTrdRegTS, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noSideTrdRegTS = noSideTrdRegTS;

		if (noSideTrdRegTS < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noSideTrdRegTS ).getBytes(), FixTags.NOSIDETRDREGTS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noSideTrdRegTS) {
			group = new SideTrdRegTS[noSideTrdRegTS];

			for ( int i = 0; i < noSideTrdRegTS; i++ ) group[i] = new SideTrdRegTS();
	}

		for ( int i = 0; i < noSideTrdRegTS; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noSideTrdRegTS; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noSideTrdRegTS; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noSideTrdRegTS; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noSideTrdRegTS; i++)
			s += group[i].toString();
		return s;
	}

public class SideTrdRegTS implements FixComponent
{

	public byte[] sideTrdRegTimestamp;
	public long sideTrdRegTimestampType = 0;
	public byte[] sideTrdRegTimestampSrc;

	public SideTrdRegTS() {
		super();

		sideTrdRegTimestamp = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		sideTrdRegTimestampSrc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( sideTrdRegTimestamp, (byte)0 );
		sideTrdRegTimestampType = Long.MAX_VALUE;		
		Utils.fill( sideTrdRegTimestampSrc, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SIDETRDREGTIMESTAMP_INT) {
				sideTrdRegTimestamp = FixUtils.getTagStringValue(value, sideTrdRegTimestamp);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDETRDREGTIMESTAMPTYPE_INT) {
				sideTrdRegTimestampType = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SIDETRDREGTIMESTAMPSRC_INT) {
				sideTrdRegTimestampSrc = FixUtils.getTagStringValue(value, sideTrdRegTimestampSrc);
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
		if (FixUtils.isSet(sideTrdRegTimestamp)) return true;
		if (FixUtils.isSet(sideTrdRegTimestampType)) return true;
		if (FixUtils.isSet(sideTrdRegTimestampSrc)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(sideTrdRegTimestamp)) FixUtils.putFixTag( out, FixTags.SIDETRDREGTIMESTAMP_INT, sideTrdRegTimestamp);
		if (FixUtils.isSet(sideTrdRegTimestampType)) FixUtils.putFixTag( out, FixTags.SIDETRDREGTIMESTAMPTYPE_INT, sideTrdRegTimestampType);
		if (FixUtils.isSet(sideTrdRegTimestampSrc)) FixUtils.putFixTag( out, FixTags.SIDETRDREGTIMESTAMPSRC_INT, sideTrdRegTimestampSrc, 0, Utils.lastIndexTrim(sideTrdRegTimestampSrc, (byte)0) );
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

			if (FixUtils.isSet(sideTrdRegTimestamp)) s += "SideTrdRegTimestamp(1012)=" + new String(sideTrdRegTimestamp) + sep;
			if (FixUtils.isSet(sideTrdRegTimestampType)) s += "SideTrdRegTimestampType(1013)=" + String.valueOf(sideTrdRegTimestampType) + sep;
			if (FixUtils.isSet(sideTrdRegTimestampSrc)) s += "SideTrdRegTimestampSrc(1014)=" + new String(sideTrdRegTimestampSrc) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SideTrdRegTS)) return false;

			SideTrdRegTS msg = (SideTrdRegTS) o;

		if ( ! super.equals(msg) ) return false;

		if (!( sideTrdRegTimestampType==msg.sideTrdRegTimestampType)) return false;

		if (!Utils.equals( sideTrdRegTimestampSrc, msg.sideTrdRegTimestampSrc)) return false;

		return true;
	}
}
}
