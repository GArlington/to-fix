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


import org.tomac.protocol.fix.messaging.fix50sp2.FixTags;
import org.tomac.protocol.fix.messaging.fix50sp2.FixMessageInfo.*;

public class FixSecondaryPriceLimits implements FixComponent
{

	public long secondaryPriceLimitType = 0;
	public long secondaryLowLimitPrice = 0;
	public long secondaryHighLimitPrice = 0;
	public long secondaryTradingReferencePrice = 0;

	public FixSecondaryPriceLimits() {
		super();

		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		secondaryPriceLimitType = Long.MAX_VALUE;		
		secondaryLowLimitPrice = Long.MAX_VALUE;		
		secondaryHighLimitPrice = Long.MAX_VALUE;		
		secondaryTradingReferencePrice = Long.MAX_VALUE;		
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.SECONDARYPRICELIMITTYPE_INT:
				secondaryPriceLimitType = FixUtils.getTagIntValue( value );
				break;

			case FixTags.SECONDARYLOWLIMITPRICE_INT:
				secondaryLowLimitPrice = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.SECONDARYHIGHLIMITPRICE_INT:
				secondaryHighLimitPrice = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.SECONDARYTRADINGREFERENCEPRICE_INT:
				secondaryTradingReferencePrice = FixUtils.getTagFloatValue(value);
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, new byte[0] );

				buf.position( lastTagPosition );
				return;

			}

			lastTagPosition = buf.position();

		} while ( ( id = FixUtils.getTagId( buf ) ) > 0 );

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		return tag;

	}
	@Override
	public boolean isSet()
	{
		if (FixUtils.isSet(secondaryPriceLimitType)) return true;
		if (FixUtils.isSet(secondaryLowLimitPrice)) return true;
		if (FixUtils.isSet(secondaryHighLimitPrice)) return true;
		if (FixUtils.isSet(secondaryTradingReferencePrice)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(secondaryPriceLimitType)) FixUtils.putFixTag( out, FixTags.SECONDARYPRICELIMITTYPE_INT, secondaryPriceLimitType);
		if (FixUtils.isSet(secondaryLowLimitPrice)) FixUtils.putFixFloatTag( out, FixTags.SECONDARYLOWLIMITPRICE_INT, secondaryLowLimitPrice);
		if (FixUtils.isSet(secondaryHighLimitPrice)) FixUtils.putFixFloatTag( out, FixTags.SECONDARYHIGHLIMITPRICE_INT, secondaryHighLimitPrice);
		if (FixUtils.isSet(secondaryTradingReferencePrice)) FixUtils.putFixFloatTag( out, FixTags.SECONDARYTRADINGREFERENCEPRICE_INT, secondaryTradingReferencePrice);
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

			if (FixUtils.isSet(secondaryPriceLimitType)) s += "SecondaryPriceLimitType(1305)=" + String.valueOf(secondaryPriceLimitType) + sep;
			if (FixUtils.isSet(secondaryLowLimitPrice)) s += "SecondaryLowLimitPrice(1221)=" + String.valueOf(secondaryLowLimitPrice) + sep;
			if (FixUtils.isSet(secondaryHighLimitPrice)) s += "SecondaryHighLimitPrice(1230)=" + String.valueOf(secondaryHighLimitPrice) + sep;
			if (FixUtils.isSet(secondaryTradingReferencePrice)) s += "SecondaryTradingReferencePrice(1240)=" + String.valueOf(secondaryTradingReferencePrice) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecondaryPriceLimits)) return false;

			FixSecondaryPriceLimits msg = (FixSecondaryPriceLimits) o;

		if ( ! super.equals(msg) ) return false;

		if (!( secondaryPriceLimitType==msg.secondaryPriceLimitType)) return false;

		if (!( secondaryLowLimitPrice==msg.secondaryLowLimitPrice)) return false;

		if (!( secondaryHighLimitPrice==msg.secondaryHighLimitPrice)) return false;

		if (!( secondaryTradingReferencePrice==msg.secondaryTradingReferencePrice)) return false;

		return true;
	}
}
