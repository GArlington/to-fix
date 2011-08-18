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

public class FixExecAllocGrp
{

	public int noExecs;
	public ExecAllocGrp[] group;

	public void getAll(int noExecs, ByteBuffer buf) throws FixSessionException {
		this.noExecs = noExecs;

		if (noExecs < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noExecs) 
			group = new ExecAllocGrp[noExecs];

		for ( int i = 0; i < noExecs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noExecs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noExecs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noExecs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noExecs; i++)
			s += group[i].toString();
		return s;
	}

public class ExecAllocGrp implements FixComponent
{

	public long lastQty = 0;
	public byte[] execID;
	public byte[] secondaryExecID;
	public long lastPx = 0;
	public long lastParPx = 0;
	public byte lastCapacity = (byte)' ';
	public byte[] tradeID;
	public byte[] firmTradeID;

	public ExecAllocGrp() {
		super();

		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		firmTradeID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		lastQty = Long.MAX_VALUE;		
		Utils.fill( execID, (byte)0 );
		Utils.fill( secondaryExecID, (byte)0 );
		lastPx = Long.MAX_VALUE;		
		lastParPx = Long.MAX_VALUE;		
		lastCapacity = Byte.MAX_VALUE;		
		Utils.fill( tradeID, (byte)0 );
		Utils.fill( firmTradeID, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LASTQTY_INT) {
				lastQty = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.EXECID_INT) {
				execID = FixUtils.getTagStringValue(value, execID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECONDARYEXECID_INT) {
				secondaryExecID = FixUtils.getTagStringValue(value, secondaryExecID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LASTPX_INT) {
				lastPx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LASTPARPX_INT) {
				lastParPx = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LASTCAPACITY_INT) {
				lastCapacity = FixUtils.getTagCharValue( value );
				if (!FixMessageInfo.LastCapacity.isValid(lastCapacity) ) throw new FixSessionException(buf, "Invalid enumerated value(" + lastCapacity + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRADEID_INT) {
				tradeID = FixUtils.getTagStringValue(value, tradeID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.FIRMTRADEID_INT) {
				firmTradeID = FixUtils.getTagStringValue(value, firmTradeID);
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
		if (FixUtils.isSet(lastQty)) return true;
		if (FixUtils.isSet(execID)) return true;
		if (FixUtils.isSet(secondaryExecID)) return true;
		if (FixUtils.isSet(lastPx)) return true;
		if (FixUtils.isSet(lastParPx)) return true;
		if (FixUtils.isSet(lastCapacity)) return true;
		if (FixUtils.isSet(tradeID)) return true;
		if (FixUtils.isSet(firmTradeID)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(lastQty)) FixUtils.putFixFloatTag( out, FixTags.LASTQTY_INT, lastQty);
		if (FixUtils.isSet(execID)) FixUtils.putFixTag( out, FixTags.EXECID_INT, execID, 0, Utils.lastIndexTrim(execID, (byte)0) );
		if (FixUtils.isSet(secondaryExecID)) FixUtils.putFixTag( out, FixTags.SECONDARYEXECID_INT, secondaryExecID, 0, Utils.lastIndexTrim(secondaryExecID, (byte)0) );
		if (FixUtils.isSet(lastPx)) FixUtils.putFixFloatTag( out, FixTags.LASTPX_INT, lastPx);
		if (FixUtils.isSet(lastParPx)) FixUtils.putFixFloatTag( out, FixTags.LASTPARPX_INT, lastParPx);
		if (FixUtils.isSet(lastCapacity)) FixUtils.putFixTag( out, FixTags.LASTCAPACITY_INT, lastCapacity );
		if (FixUtils.isSet(tradeID)) FixUtils.putFixTag( out, FixTags.TRADEID_INT, tradeID, 0, Utils.lastIndexTrim(tradeID, (byte)0) );
		if (FixUtils.isSet(firmTradeID)) FixUtils.putFixTag( out, FixTags.FIRMTRADEID_INT, firmTradeID, 0, Utils.lastIndexTrim(firmTradeID, (byte)0) );
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

			if (FixUtils.isSet(lastQty)) s += "LastQty(32)=" + String.valueOf(lastQty) + sep;
			if (FixUtils.isSet(execID)) s += "ExecID(17)=" + new String(execID) + sep;
			if (FixUtils.isSet(secondaryExecID)) s += "SecondaryExecID(527)=" + new String(secondaryExecID) + sep;
			if (FixUtils.isSet(lastPx)) s += "LastPx(31)=" + String.valueOf(lastPx) + sep;
			if (FixUtils.isSet(lastParPx)) s += "LastParPx(669)=" + String.valueOf(lastParPx) + sep;
			if (FixUtils.isSet(lastCapacity)) s += "LastCapacity(29)=" + String.valueOf(lastCapacity) + sep;
			if (FixUtils.isSet(tradeID)) s += "TradeID(1003)=" + new String(tradeID) + sep;
			if (FixUtils.isSet(firmTradeID)) s += "FirmTradeID(1041)=" + new String(firmTradeID) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof ExecAllocGrp)) return false;

			ExecAllocGrp msg = (ExecAllocGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!( lastQty==msg.lastQty)) return false;

		if (!Utils.equals( execID, msg.execID)) return false;

		if (!Utils.equals( secondaryExecID, msg.secondaryExecID)) return false;

		if (!( lastPx==msg.lastPx)) return false;

		if (!( lastParPx==msg.lastParPx)) return false;

		if (!( lastCapacity==msg.lastCapacity)) return false;

		if (!Utils.equals( tradeID, msg.tradeID)) return false;

		if (!Utils.equals( firmTradeID, msg.firmTradeID)) return false;

		return true;
	}
}
}
