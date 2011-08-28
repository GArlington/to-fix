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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndlyInstrumentPtysSubGrp;

public class FixUndlyInstrumentParties
{

	public int noUndlyInstrumentParties;
	public UndlyInstrumentParties[] group;

	public void getAll(int noUndlyInstrumentParties, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noUndlyInstrumentParties = noUndlyInstrumentParties;

		if (noUndlyInstrumentParties < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noUndlyInstrumentParties ).getBytes(), FixTags.NOUNDLYINSTRUMENTPARTIES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noUndlyInstrumentParties) {
			group = new UndlyInstrumentParties[noUndlyInstrumentParties];

			for ( int i = 0; i < noUndlyInstrumentParties; i++ ) group[i] = new UndlyInstrumentParties();
	}

		for ( int i = 0; i < noUndlyInstrumentParties; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noUndlyInstrumentParties; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noUndlyInstrumentParties; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noUndlyInstrumentParties; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUndlyInstrumentParties)) return false;

		FixUndlyInstrumentParties msg = (FixUndlyInstrumentParties) o;

		for (int i = 0; i<noUndlyInstrumentParties; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noUndlyInstrumentParties; i++)
			s += group[i].toString();
		return s;
	}

public class UndlyInstrumentParties implements FixComponent
{

	public byte[] underlyingInstrumentPartyID;
	public byte underlyingInstrumentPartyIDSource = (byte)' ';
	public long underlyingInstrumentPartyRole = 0;
	public FixUndlyInstrumentPtysSubGrp undlyInstrumentPtysSubGrp;

	public UndlyInstrumentParties() {
		super();

		underlyingInstrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		undlyInstrumentPtysSubGrp = new FixUndlyInstrumentPtysSubGrp();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( underlyingInstrumentPartyID, (byte)0 );
		underlyingInstrumentPartyIDSource = Byte.MAX_VALUE;		
		underlyingInstrumentPartyRole = Long.MAX_VALUE;		
		undlyInstrumentPtysSubGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.UNDERLYINGINSTRUMENTPARTYID_INT) {
				underlyingInstrumentPartyID = FixUtils.getTagStringValue(null ,id ,value, underlyingInstrumentPartyID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.UNDERLYINGINSTRUMENTPARTYIDSOURCE_INT) {
				underlyingInstrumentPartyIDSource = FixUtils.getTagCharValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.UNDERLYINGINSTRUMENTPARTYROLE_INT) {
				underlyingInstrumentPartyRole = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOUNDLYINSTRUMENTPARTYSUBIDS_INT) {
				int noUndlyInstrumentPartySubIDs;
				noUndlyInstrumentPartySubIDs = FixUtils.getTagIntValue(null ,id ,value );
				undlyInstrumentPtysSubGrp.getAll(noUndlyInstrumentPartySubIDs, buf);
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
		if (FixUtils.isSet(underlyingInstrumentPartyID)) return true;
		if (FixUtils.isSet(underlyingInstrumentPartyIDSource)) return true;
		if (FixUtils.isSet(underlyingInstrumentPartyRole)) return true;
		if (FixUtils.isSet(undlyInstrumentPtysSubGrp.noUndlyInstrumentPartySubIDs)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(underlyingInstrumentPartyID)) FixUtils.putFixTag( out, FixTags.UNDERLYINGINSTRUMENTPARTYID_INT, underlyingInstrumentPartyID, 0, Utils.lastIndexTrim(underlyingInstrumentPartyID, (byte)0) );
		if (FixUtils.isSet(underlyingInstrumentPartyIDSource)) FixUtils.putFixTag( out, FixTags.UNDERLYINGINSTRUMENTPARTYIDSOURCE_INT, underlyingInstrumentPartyIDSource );
		if (FixUtils.isSet(underlyingInstrumentPartyRole)) FixUtils.putFixTag( out, FixTags.UNDERLYINGINSTRUMENTPARTYROLE_INT, underlyingInstrumentPartyRole);
		if (FixUtils.isSet(undlyInstrumentPtysSubGrp.noUndlyInstrumentPartySubIDs)) undlyInstrumentPtysSubGrp.encode( out );
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

			if (FixUtils.isSet(underlyingInstrumentPartyID)) s += "UnderlyingInstrumentPartyID(1059)=" + new String(underlyingInstrumentPartyID) + sep;
			if (FixUtils.isSet(underlyingInstrumentPartyIDSource)) s += "UnderlyingInstrumentPartyIDSource(1060)=" + String.valueOf(underlyingInstrumentPartyIDSource) + sep;
			if (FixUtils.isSet(underlyingInstrumentPartyRole)) s += "UnderlyingInstrumentPartyRole(1061)=" + String.valueOf(underlyingInstrumentPartyRole) + sep;
			if (FixUtils.isSet(undlyInstrumentPtysSubGrp.noUndlyInstrumentPartySubIDs)) s += undlyInstrumentPtysSubGrp.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof UndlyInstrumentParties)) return false;

			UndlyInstrumentParties msg = (UndlyInstrumentParties) o;

		if (!Utils.equals( underlyingInstrumentPartyID, msg.underlyingInstrumentPartyID)) return false;

		if (!( underlyingInstrumentPartyIDSource==msg.underlyingInstrumentPartyIDSource)) return false;

		if (!( underlyingInstrumentPartyRole==msg.underlyingInstrumentPartyRole)) return false;

		if (!undlyInstrumentPtysSubGrp.equals(msg.undlyInstrumentPtysSubGrp)) return false;

		return true;
	}
}
}
