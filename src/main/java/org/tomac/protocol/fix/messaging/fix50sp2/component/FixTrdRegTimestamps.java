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


import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;
import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;

public class FixTrdRegTimestamps
{

	public int noTrdRegTimestamps;
	public TrdRegTimestamps[] group;

	public void getAll(int noTrdRegTimestamps, ByteBuffer buf) throws FixSessionException {
		this.noTrdRegTimestamps = noTrdRegTimestamps;

		if (noTrdRegTimestamps < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noTrdRegTimestamps) 
			group = new TrdRegTimestamps[noTrdRegTimestamps];

		for ( int i = 0; i < noTrdRegTimestamps; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noTrdRegTimestamps; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noTrdRegTimestamps; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noTrdRegTimestamps; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noTrdRegTimestamps; i++)
			s += group[i].toString();
		return s;
	}

public class TrdRegTimestamps implements FixComponent
{

	public byte[] trdRegTimestamp;
	public long trdRegTimestampType = 0;
	public byte[] trdRegTimestampOrigin;
	public byte[] deskType;
	public long deskTypeSource = 0;
	public byte[] deskOrderHandlingInst;

	public TrdRegTimestamps() {
		super();

		trdRegTimestamp = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		trdRegTimestampOrigin = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		deskType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		deskOrderHandlingInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( trdRegTimestamp, (byte)0 );
		trdRegTimestampType = Long.MAX_VALUE;		
		Utils.fill( trdRegTimestampOrigin, (byte)0 );
		Utils.fill( deskType, (byte)0 );
		deskTypeSource = Long.MAX_VALUE;		
		Utils.fill( deskOrderHandlingInst, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.TRDREGTIMESTAMP_INT) {
				trdRegTimestamp = FixUtils.getTagStringValue(value, trdRegTimestamp);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRDREGTIMESTAMPTYPE_INT) {
				trdRegTimestampType = FixUtils.getTagIntValue( value );
				if (!TrdRegTimestampType.isValid(trdRegTimestampType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + trdRegTimestampType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRDREGTIMESTAMPORIGIN_INT) {
				trdRegTimestampOrigin = FixUtils.getTagStringValue(value, trdRegTimestampOrigin);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DESKTYPE_INT) {
				deskType = FixUtils.getTagStringValue(value, deskType);
				if (!DeskType.isValid(deskType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + deskType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DESKTYPESOURCE_INT) {
				deskTypeSource = FixUtils.getTagIntValue( value );
				if (!DeskTypeSource.isValid(deskTypeSource) ) throw new FixSessionException(buf, "Invalid enumerated value(" + deskTypeSource + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DESKORDERHANDLINGINST_INT) {
				deskOrderHandlingInst = FixUtils.getTagStringValue(value, deskOrderHandlingInst);
				if (!DeskOrderHandlingInst.isValid(deskOrderHandlingInst) ) throw new FixSessionException(buf, "Invalid enumerated value(" + deskOrderHandlingInst + ") for tag: " + id );
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
		if (FixUtils.isSet(trdRegTimestamp)) return true;
		if (FixUtils.isSet(trdRegTimestampType)) return true;
		if (FixUtils.isSet(trdRegTimestampOrigin)) return true;
		if (FixUtils.isSet(deskType)) return true;
		if (FixUtils.isSet(deskTypeSource)) return true;
		if (FixUtils.isSet(deskOrderHandlingInst)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(trdRegTimestamp)) FixUtils.putFixTag( out, FixTags.TRDREGTIMESTAMP_INT, trdRegTimestamp);
		if (FixUtils.isSet(trdRegTimestampType)) FixUtils.putFixTag( out, FixTags.TRDREGTIMESTAMPTYPE_INT, trdRegTimestampType);
		if (FixUtils.isSet(trdRegTimestampOrigin)) FixUtils.putFixTag( out, FixTags.TRDREGTIMESTAMPORIGIN_INT, trdRegTimestampOrigin, 0, Utils.lastIndexTrim(trdRegTimestampOrigin, (byte)0) );
		if (FixUtils.isSet(deskType)) FixUtils.putFixTag( out, FixTags.DESKTYPE_INT, deskType, 0, Utils.lastIndexTrim(deskType, (byte)0) );
		if (FixUtils.isSet(deskTypeSource)) FixUtils.putFixTag( out, FixTags.DESKTYPESOURCE_INT, deskTypeSource);
		if (FixUtils.isSet(deskOrderHandlingInst)) FixUtils.putFixTag( out, FixTags.DESKORDERHANDLINGINST_INT, deskOrderHandlingInst, 0, Utils.lastIndexTrim(deskOrderHandlingInst, (byte)0) );
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

			if (FixUtils.isSet(trdRegTimestamp)) s += "TrdRegTimestamp(769)=" + new String(trdRegTimestamp) + sep;
			if (FixUtils.isSet(trdRegTimestampType)) s += "TrdRegTimestampType(770)=" + String.valueOf(trdRegTimestampType) + sep;
			if (FixUtils.isSet(trdRegTimestampOrigin)) s += "TrdRegTimestampOrigin(771)=" + new String(trdRegTimestampOrigin) + sep;
			if (FixUtils.isSet(deskType)) s += "DeskType(1033)=" + new String(deskType) + sep;
			if (FixUtils.isSet(deskTypeSource)) s += "DeskTypeSource(1034)=" + String.valueOf(deskTypeSource) + sep;
			if (FixUtils.isSet(deskOrderHandlingInst)) s += "DeskOrderHandlingInst(1035)=" + new String(deskOrderHandlingInst) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TrdRegTimestamps)) return false;

			TrdRegTimestamps msg = (TrdRegTimestamps) o;

		if ( ! super.equals(msg) ) return false;

		if (!( trdRegTimestampType==msg.trdRegTimestampType)) return false;

		if (!Utils.equals( trdRegTimestampOrigin, msg.trdRegTimestampOrigin)) return false;

		if (!Utils.equals( deskType, msg.deskType)) return false;

		if (!( deskTypeSource==msg.deskTypeSource)) return false;

		if (!Utils.equals( deskOrderHandlingInst, msg.deskOrderHandlingInst)) return false;

		return true;
	}
}
}
