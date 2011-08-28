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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNestedParties3;

public class FixPreAllocMlegGrp
{

	public int noAllocs;
	public PreAllocMlegGrp[] group;

	public void getAll(int noAllocs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noAllocs = noAllocs;

		if (noAllocs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noAllocs ).getBytes(), FixTags.NOALLOCS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noAllocs) {
			group = new PreAllocMlegGrp[noAllocs];

			for ( int i = 0; i < noAllocs; i++ ) group[i] = new PreAllocMlegGrp();
	}

		for ( int i = 0; i < noAllocs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noAllocs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noAllocs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noAllocs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPreAllocMlegGrp)) return false;

		FixPreAllocMlegGrp msg = (FixPreAllocMlegGrp) o;

		for (int i = 0; i<noAllocs; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noAllocs; i++)
			s += group[i].toString();
		return s;
	}

public class PreAllocMlegGrp implements FixComponent
{

	public byte[] allocAccount;
	public long allocAcctIDSource = 0;
	public byte[] allocSettlCurrency;
	public byte[] individualAllocID;
	public FixNestedParties3 nestedParties3;
	public long allocQty = 0;

	public PreAllocMlegGrp() {
		super();

		allocAccount = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		allocSettlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		individualAllocID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		nestedParties3 = new FixNestedParties3();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( allocAccount, (byte)0 );
		allocAcctIDSource = Long.MAX_VALUE;		
		Utils.fill( allocSettlCurrency, (byte)0 );
		Utils.fill( individualAllocID, (byte)0 );
		allocQty = Long.MAX_VALUE;		
		nestedParties3.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.ALLOCACCOUNT_INT) {
				allocAccount = FixUtils.getTagStringValue(null ,id ,value, allocAccount);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCACCTIDSOURCE_INT) {
				allocAcctIDSource = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCSETTLCURRENCY_INT) {
				allocSettlCurrency = FixUtils.getTagStringValue(null ,id ,value, allocSettlCurrency);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.INDIVIDUALALLOCID_INT) {
				individualAllocID = FixUtils.getTagStringValue(null ,id ,value, individualAllocID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NONESTED3PARTYIDS_INT) {
				int noNested3PartyIDs;
				noNested3PartyIDs = FixUtils.getTagIntValue(null ,id ,value );
				nestedParties3.getAll(noNested3PartyIDs, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.ALLOCQTY_INT) {
				allocQty = FixUtils.getTagFloatValue(null ,id ,value);
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
		if (FixUtils.isSet(allocAccount)) return true;
		if (FixUtils.isSet(allocAcctIDSource)) return true;
		if (FixUtils.isSet(allocSettlCurrency)) return true;
		if (FixUtils.isSet(individualAllocID)) return true;
		if (FixUtils.isSet(nestedParties3.noNested3PartyIDs)) return true;
		if (FixUtils.isSet(allocQty)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(allocAccount)) FixUtils.putFixTag( out, FixTags.ALLOCACCOUNT_INT, allocAccount, 0, Utils.lastIndexTrim(allocAccount, (byte)0) );
		if (FixUtils.isSet(allocAcctIDSource)) FixUtils.putFixTag( out, FixTags.ALLOCACCTIDSOURCE_INT, allocAcctIDSource);
		if (FixUtils.isSet(allocSettlCurrency)) FixUtils.putFixTag( out, FixTags.ALLOCSETTLCURRENCY_INT, allocSettlCurrency, 0, Utils.lastIndexTrim(allocSettlCurrency, (byte)0) );
		if (FixUtils.isSet(individualAllocID)) FixUtils.putFixTag( out, FixTags.INDIVIDUALALLOCID_INT, individualAllocID, 0, Utils.lastIndexTrim(individualAllocID, (byte)0) );
		if (FixUtils.isSet(nestedParties3.noNested3PartyIDs)) nestedParties3.encode( out );
		if (FixUtils.isSet(allocQty)) FixUtils.putFixFloatTag( out, FixTags.ALLOCQTY_INT, allocQty);
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

			if (FixUtils.isSet(allocAccount)) s += "AllocAccount(79)=" + new String(allocAccount) + sep;
			if (FixUtils.isSet(allocAcctIDSource)) s += "AllocAcctIDSource(661)=" + String.valueOf(allocAcctIDSource) + sep;
			if (FixUtils.isSet(allocSettlCurrency)) s += "AllocSettlCurrency(736)=" + new String(allocSettlCurrency) + sep;
			if (FixUtils.isSet(individualAllocID)) s += "IndividualAllocID(467)=" + new String(individualAllocID) + sep;
			if (FixUtils.isSet(nestedParties3.noNested3PartyIDs)) s += nestedParties3.toString();
			if (FixUtils.isSet(allocQty)) s += "AllocQty(80)=" + String.valueOf(allocQty) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof PreAllocMlegGrp)) return false;

			PreAllocMlegGrp msg = (PreAllocMlegGrp) o;

		if (!Utils.equals( allocAccount, msg.allocAccount)) return false;

		if (!( allocAcctIDSource==msg.allocAcctIDSource)) return false;

		if (!Utils.equals( allocSettlCurrency, msg.allocSettlCurrency)) return false;

		if (!Utils.equals( individualAllocID, msg.individualAllocID)) return false;

		if (!nestedParties3.equals(msg.nestedParties3)) return false;

		if (!( allocQty==msg.allocQty)) return false;

		return true;
	}
}
}
