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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSettlPtysSubGrp;

public class FixSettlParties
{

	public int noSettlPartyIDs;
	public SettlParties[] group;

	public void getAll(int noSettlPartyIDs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noSettlPartyIDs = noSettlPartyIDs;

		if (noSettlPartyIDs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noSettlPartyIDs ).getBytes(), FixTags.NOSETTLPARTYIDS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noSettlPartyIDs) {
			group = new SettlParties[noSettlPartyIDs];

			for ( int i = 0; i < noSettlPartyIDs; i++ ) group[i] = new SettlParties();
	}

		for ( int i = 0; i < noSettlPartyIDs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noSettlPartyIDs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noSettlPartyIDs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noSettlPartyIDs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlParties)) return false;

		FixSettlParties msg = (FixSettlParties) o;

		for (int i = 0; i<noSettlPartyIDs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noSettlPartyIDs; i++)
			s += group[i].toString();
		return s;
	}

public class SettlParties implements FixComponent
{

	public byte[] settlPartyID;
	public byte settlPartyIDSource = (byte)' ';
	public long settlPartyRole = 0;
	public FixSettlPtysSubGrp settlPtysSubGrp;

	public SettlParties() {
		super();

		settlPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlPtysSubGrp = new FixSettlPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( settlPartyID, (byte)0 );
		settlPartyIDSource = Byte.MAX_VALUE;		
		settlPartyRole = Long.MAX_VALUE;		
		settlPtysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SETTLPARTYID_INT) {
				settlPartyID = FixUtils.getTagStringValue(null ,id ,value, settlPartyID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLPARTYIDSOURCE_INT) {
				settlPartyIDSource = FixUtils.getTagCharValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SETTLPARTYROLE_INT) {
				settlPartyRole = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOSETTLPARTYSUBIDS_INT) {
				int noSettlPartySubIDs;
				noSettlPartySubIDs = FixUtils.getTagIntValue(null ,id ,value );
				settlPtysSubGrp.getAll(noSettlPartySubIDs, buf);
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
		if (FixUtils.isSet(settlPartyID)) return true;
		if (FixUtils.isSet(settlPartyIDSource)) return true;
		if (FixUtils.isSet(settlPartyRole)) return true;
		if (FixUtils.isSet(settlPtysSubGrp.noSettlPartySubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(settlPartyID)) FixUtils.putFixTag( out, FixTags.SETTLPARTYID_INT, settlPartyID, 0, Utils.lastIndexTrim(settlPartyID, (byte)0) );
		if (FixUtils.isSet(settlPartyIDSource)) FixUtils.putFixTag( out, FixTags.SETTLPARTYIDSOURCE_INT, settlPartyIDSource );
		if (FixUtils.isSet(settlPartyRole)) FixUtils.putFixTag( out, FixTags.SETTLPARTYROLE_INT, settlPartyRole);
		if (FixUtils.isSet(settlPtysSubGrp.noSettlPartySubIDs)) settlPtysSubGrp.encode( out );
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

			if (FixUtils.isSet(settlPartyID)) s += "SettlPartyID(782)=" + new String(settlPartyID) + sep;
			if (FixUtils.isSet(settlPartyIDSource)) s += "SettlPartyIDSource(783)=" + String.valueOf(settlPartyIDSource) + sep;
			if (FixUtils.isSet(settlPartyRole)) s += "SettlPartyRole(784)=" + String.valueOf(settlPartyRole) + sep;
			if (FixUtils.isSet(settlPtysSubGrp.noSettlPartySubIDs)) s += settlPtysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SettlParties)) return false;

			SettlParties msg = (SettlParties) o;

		if (!Utils.equals( settlPartyID, msg.settlPartyID)) return false;

		if (!( settlPartyIDSource==msg.settlPartyIDSource)) return false;

		if (!( settlPartyRole==msg.settlPartyRole)) return false;

		if (!settlPtysSubGrp.equals(msg.settlPtysSubGrp)) return false;

		return true;
	}
}
}
