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

public class FixCompIDReqGrp
{

	public int noCompIDs;
	public CompIDReqGrp[] group;

	public void getAll(int noCompIDs, ByteBuffer buf) throws FixSessionException {
		this.noCompIDs = noCompIDs;

		if (noCompIDs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noCompIDs) {
			group = new CompIDReqGrp[noCompIDs];

			for ( int i = 0; i < noCompIDs; i++ ) group[i] = new CompIDReqGrp();
	}

		for ( int i = 0; i < noCompIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noCompIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noCompIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noCompIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noCompIDs; i++)
			s += group[i].toString();
		return s;
	}

public class CompIDReqGrp implements FixComponent
{

	public byte[] refCompID;
	public byte[] refSubID;
	public byte[] locationID;
	public byte[] deskID;

	public CompIDReqGrp() {
		super();

		refCompID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		refSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		locationID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		deskID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( refCompID, (byte)0 );
		Utils.fill( refSubID, (byte)0 );
		Utils.fill( locationID, (byte)0 );
		Utils.fill( deskID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.REFCOMPID_INT) {
				refCompID = FixUtils.getTagStringValue(value, refCompID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.REFSUBID_INT) {
				refSubID = FixUtils.getTagStringValue(value, refSubID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LOCATIONID_INT) {
				locationID = FixUtils.getTagStringValue(value, locationID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.DESKID_INT) {
				deskID = FixUtils.getTagStringValue(value, deskID);
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
		if (FixUtils.isSet(refCompID)) return true;
		if (FixUtils.isSet(refSubID)) return true;
		if (FixUtils.isSet(locationID)) return true;
		if (FixUtils.isSet(deskID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(refCompID)) FixUtils.putFixTag( out, FixTags.REFCOMPID_INT, refCompID, 0, Utils.lastIndexTrim(refCompID, (byte)0) );
		if (FixUtils.isSet(refSubID)) FixUtils.putFixTag( out, FixTags.REFSUBID_INT, refSubID, 0, Utils.lastIndexTrim(refSubID, (byte)0) );
		if (FixUtils.isSet(locationID)) FixUtils.putFixTag( out, FixTags.LOCATIONID_INT, locationID, 0, Utils.lastIndexTrim(locationID, (byte)0) );
		if (FixUtils.isSet(deskID)) FixUtils.putFixTag( out, FixTags.DESKID_INT, deskID, 0, Utils.lastIndexTrim(deskID, (byte)0) );
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

			if (FixUtils.isSet(refCompID)) s += "RefCompID(930)=" + new String(refCompID) + sep;
			if (FixUtils.isSet(refSubID)) s += "RefSubID(931)=" + new String(refSubID) + sep;
			if (FixUtils.isSet(locationID)) s += "LocationID(283)=" + new String(locationID) + sep;
			if (FixUtils.isSet(deskID)) s += "DeskID(284)=" + new String(deskID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof CompIDReqGrp)) return false;

			CompIDReqGrp msg = (CompIDReqGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( refCompID, msg.refCompID)) return false;

		if (!Utils.equals( refSubID, msg.refSubID)) return false;

		if (!Utils.equals( locationID, msg.locationID)) return false;

		if (!Utils.equals( deskID, msg.deskID)) return false;

		return true;
	}
}
}
