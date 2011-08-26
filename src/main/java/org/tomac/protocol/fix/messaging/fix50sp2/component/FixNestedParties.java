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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNstdPtysSubGrp;

public class FixNestedParties
{

	public int noNestedPartyIDs;
	public NestedParties[] group;

	public void getAll(int noNestedPartyIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noNestedPartyIDs = noNestedPartyIDs;

		if (noNestedPartyIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noNestedPartyIDs ).getBytes(), FixTags.NONESTEDPARTYIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noNestedPartyIDs) {
			group = new NestedParties[noNestedPartyIDs];

			for ( int i = 0; i < noNestedPartyIDs; i++ ) group[i] = new NestedParties();
	}

		for ( int i = 0; i < noNestedPartyIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNestedPartyIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNestedPartyIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNestedPartyIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNestedPartyIDs; i++)
			s += group[i].toString();
		return s;
	}

public class NestedParties implements FixComponent
{

	public byte[] nestedPartyID;
	public byte nestedPartyIDSource = (byte)' ';
	public long nestedPartyRole = 0;
	public FixNstdPtysSubGrp nstdPtysSubGrp;

	public NestedParties() {
		super();

		nestedPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nstdPtysSubGrp = new FixNstdPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( nestedPartyID, (byte)0 );
		nestedPartyIDSource = Byte.MAX_VALUE;		
		nestedPartyRole = Long.MAX_VALUE;		
		nstdPtysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NESTEDPARTYID_INT) {
				nestedPartyID = FixUtils.getTagStringValue(value, nestedPartyID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTEDPARTYIDSOURCE_INT) {
				nestedPartyIDSource = FixUtils.getTagCharValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTEDPARTYROLE_INT) {
				nestedPartyRole = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTEDPARTYSUBIDS_INT) {
				nstdPtysSubGrp.getAll(FixTags.NONESTEDPARTYSUBIDS_INT, buf);
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
		if (FixUtils.isSet(nestedPartyID)) return true;
		if (FixUtils.isSet(nestedPartyIDSource)) return true;
		if (FixUtils.isSet(nestedPartyRole)) return true;
		if (FixUtils.isSet(nstdPtysSubGrp.noNestedPartySubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(nestedPartyID)) FixUtils.putFixTag( out, FixTags.NESTEDPARTYID_INT, nestedPartyID, 0, Utils.lastIndexTrim(nestedPartyID, (byte)0) );
		if (FixUtils.isSet(nestedPartyIDSource)) FixUtils.putFixTag( out, FixTags.NESTEDPARTYIDSOURCE_INT, nestedPartyIDSource );
		if (FixUtils.isSet(nestedPartyRole)) FixUtils.putFixTag( out, FixTags.NESTEDPARTYROLE_INT, nestedPartyRole);
		if (FixUtils.isSet(nstdPtysSubGrp.noNestedPartySubIDs)) nstdPtysSubGrp.encode( out );
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

			if (FixUtils.isSet(nestedPartyID)) s += "NestedPartyID(524)=" + new String(nestedPartyID) + sep;
			if (FixUtils.isSet(nestedPartyIDSource)) s += "NestedPartyIDSource(525)=" + String.valueOf(nestedPartyIDSource) + sep;
			if (FixUtils.isSet(nestedPartyRole)) s += "NestedPartyRole(538)=" + String.valueOf(nestedPartyRole) + sep;
			if (FixUtils.isSet(nstdPtysSubGrp.noNestedPartySubIDs)) s += nstdPtysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NestedParties)) return false;

			NestedParties msg = (NestedParties) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( nestedPartyID, msg.nestedPartyID)) return false;

		if (!( nestedPartyIDSource==msg.nestedPartyIDSource)) return false;

		if (!( nestedPartyRole==msg.nestedPartyRole)) return false;

		if (!nstdPtysSubGrp.equals(msg.nstdPtysSubGrp)) return false;

		return true;
	}
}
}
