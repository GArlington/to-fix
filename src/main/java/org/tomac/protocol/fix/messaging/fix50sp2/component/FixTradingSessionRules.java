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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixOrdTypeRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTimeInForceRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixExecInstRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixMatchRules;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixMarketDataFeedTypes;

public class FixTradingSessionRules implements FixComponent
{

	public FixOrdTypeRules ordTypeRules;
	public FixTimeInForceRules timeInForceRules;
	public FixExecInstRules execInstRules;
	public FixMatchRules matchRules;
	public FixMarketDataFeedTypes marketDataFeedTypes;

	public FixTradingSessionRules() {
		super();

		ordTypeRules = new FixOrdTypeRules();
		timeInForceRules = new FixTimeInForceRules();
		execInstRules = new FixExecInstRules();
		matchRules = new FixMatchRules();
		marketDataFeedTypes = new FixMarketDataFeedTypes();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		ordTypeRules.clear();
		timeInForceRules.clear();
		execInstRules.clear();
		matchRules.clear();
		marketDataFeedTypes.clear();
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.NOORDTYPERULES_INT:
				ordTypeRules.noOrdTypeRules = FixUtils.getTagIntValue( value );
				ordTypeRules.getAll(ordTypeRules.noOrdTypeRules, value );
				break;

			case FixTags.NOTIMEINFORCERULES_INT:
				timeInForceRules.noTimeInForceRules = FixUtils.getTagIntValue( value );
				timeInForceRules.getAll(timeInForceRules.noTimeInForceRules, value );
				break;

			case FixTags.NOEXECINSTRULES_INT:
				execInstRules.noExecInstRules = FixUtils.getTagIntValue( value );
				execInstRules.getAll(execInstRules.noExecInstRules, value );
				break;

			case FixTags.NOMATCHRULES_INT:
				matchRules.noMatchRules = FixUtils.getTagIntValue( value );
				matchRules.getAll(matchRules.noMatchRules, value );
				break;

			case FixTags.NOMDFEEDTYPES_INT:
				marketDataFeedTypes.noMDFeedTypes = FixUtils.getTagIntValue( value );
				marketDataFeedTypes.getAll(marketDataFeedTypes.noMDFeedTypes, value );
				break;

			// we will always endup with unknown tag, unread and return to upper layer in hierarchy
			default:
				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

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
		if (FixUtils.isSet(ordTypeRules.noOrdTypeRules)) return true;
		if (FixUtils.isSet(timeInForceRules.noTimeInForceRules)) return true;
		if (FixUtils.isSet(execInstRules.noExecInstRules)) return true;
		if (FixUtils.isSet(matchRules.noMatchRules)) return true;
		if (FixUtils.isSet(marketDataFeedTypes.noMDFeedTypes)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(ordTypeRules.noOrdTypeRules)) ordTypeRules.encode( out );
		if (FixUtils.isSet(timeInForceRules.noTimeInForceRules)) timeInForceRules.encode( out );
		if (FixUtils.isSet(execInstRules.noExecInstRules)) execInstRules.encode( out );
		if (FixUtils.isSet(matchRules.noMatchRules)) matchRules.encode( out );
		if (FixUtils.isSet(marketDataFeedTypes.noMDFeedTypes)) marketDataFeedTypes.encode( out );
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

			if (FixUtils.isSet(ordTypeRules.noOrdTypeRules)) s += ordTypeRules.toString();
			if (FixUtils.isSet(timeInForceRules.noTimeInForceRules)) s += timeInForceRules.toString();
			if (FixUtils.isSet(execInstRules.noExecInstRules)) s += execInstRules.toString();
			if (FixUtils.isSet(matchRules.noMatchRules)) s += matchRules.toString();
			if (FixUtils.isSet(marketDataFeedTypes.noMDFeedTypes)) s += marketDataFeedTypes.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTradingSessionRules)) return false;

			FixTradingSessionRules msg = (FixTradingSessionRules) o;

		if ( ! super.equals(msg) ) return false;

		if (!ordTypeRules.equals(msg.ordTypeRules)) return false;

		if (!timeInForceRules.equals(msg.timeInForceRules)) return false;

		if (!execInstRules.equals(msg.execInstRules)) return false;

		if (!matchRules.equals(msg.matchRules)) return false;

		if (!marketDataFeedTypes.equals(msg.marketDataFeedTypes)) return false;

		return true;
	}
}
