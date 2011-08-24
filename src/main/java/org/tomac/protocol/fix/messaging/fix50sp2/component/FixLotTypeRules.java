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

public class FixLotTypeRules
{

	public int noLotTypeRules;
	public LotTypeRules[] group;

	public void getAll(int noLotTypeRules, ByteBuffer buf) throws FixSessionException {
		this.noLotTypeRules = noLotTypeRules;

		if (noLotTypeRules < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noLotTypeRules ).getBytes(), FixTags.NOLOTTYPERULES_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noLotTypeRules) {
			group = new LotTypeRules[noLotTypeRules];

			for ( int i = 0; i < noLotTypeRules; i++ ) group[i] = new LotTypeRules();
	}

		for ( int i = 0; i < noLotTypeRules; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noLotTypeRules; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noLotTypeRules; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noLotTypeRules; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLotTypeRules; i++)
			s += group[i].toString();
		return s;
	}

public class LotTypeRules implements FixComponent
{

	public byte lotType = (byte)' ';
	public long minLotSize = 0;

	public LotTypeRules() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		lotType = Byte.MAX_VALUE;		
		minLotSize = Long.MAX_VALUE;		
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LOTTYPE_INT) {
				lotType = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.LotType.isValid(lotType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + lotType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.MINLOTSIZE_INT) {
				minLotSize = FixUtils.getTagFloatValue(value);
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
		if (FixUtils.isSet(lotType)) return true;
		if (FixUtils.isSet(minLotSize)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(lotType)) FixUtils.putFixTag( out, FixTags.LOTTYPE_INT, lotType );
		if (FixUtils.isSet(minLotSize)) FixUtils.putFixFloatTag( out, FixTags.MINLOTSIZE_INT, minLotSize);
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

			if (FixUtils.isSet(lotType)) s += "LotType(1093)=" + String.valueOf(lotType) + sep;
			if (FixUtils.isSet(minLotSize)) s += "MinLotSize(1231)=" + String.valueOf(minLotSize) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof LotTypeRules)) return false;

			LotTypeRules msg = (LotTypeRules) o;

		if ( ! super.equals(msg) ) return false;

		if (!( lotType==msg.lotType)) return false;

		if (!( minLotSize==msg.minLotSize)) return false;

		return true;
	}
}
}
