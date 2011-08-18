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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUnderlyingLegInstrument;

public class FixTradeCapLegUnderlyingsGrp
{

	public int noOfLegUnderlyings;
	public TradeCapLegUnderlyingsGrp[] group;

	public void getAll(int noOfLegUnderlyings, ByteBuffer buf) throws FixSessionException {
		this.noOfLegUnderlyings = noOfLegUnderlyings;

		if (noOfLegUnderlyings < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noOfLegUnderlyings) 
			group = new TradeCapLegUnderlyingsGrp[noOfLegUnderlyings];

		for ( int i = 0; i < noOfLegUnderlyings; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noOfLegUnderlyings; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noOfLegUnderlyings; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noOfLegUnderlyings; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noOfLegUnderlyings; i++)
			s += group[i].toString();
		return s;
	}

public class TradeCapLegUnderlyingsGrp implements FixComponent
{

	public FixUnderlyingLegInstrument underlyingLegInstrument;

	public TradeCapLegUnderlyingsGrp() {
		super();

		underlyingLegInstrument = new FixUnderlyingLegInstrument();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		underlyingLegInstrument.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.UNDERLYINGLEGSYMBOL_INT) {
				underlyingLegInstrument.getAll(FixTags.UNDERLYINGLEGSYMBOL_INT, buf);
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
		if (FixUtils.isSet(underlyingLegInstrument.underlyingLegSymbol)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(underlyingLegInstrument.underlyingLegSymbol)) underlyingLegInstrument.encode( out );
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

			if (FixUtils.isSet(underlyingLegInstrument.underlyingLegSymbol)) s += underlyingLegInstrument.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof TradeCapLegUnderlyingsGrp)) return false;

			TradeCapLegUnderlyingsGrp msg = (TradeCapLegUnderlyingsGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!underlyingLegInstrument.equals(msg.underlyingLegInstrument)) return false;

		return true;
	}
}
}
