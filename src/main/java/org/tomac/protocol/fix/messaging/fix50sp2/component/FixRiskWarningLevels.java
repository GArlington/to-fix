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

public class FixRiskWarningLevels
{

	public int noRiskWarningLevels;
	public RiskWarningLevels[] group;

	public void getAll(int noRiskWarningLevels, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noRiskWarningLevels = noRiskWarningLevels;

		if (noRiskWarningLevels < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noRiskWarningLevels ).getBytes(), FixTags.NORISKWARNINGLEVELS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noRiskWarningLevels) {
			group = new RiskWarningLevels[noRiskWarningLevels];

			for ( int i = 0; i < noRiskWarningLevels; i++ ) group[i] = new RiskWarningLevels();
	}

		for ( int i = 0; i < noRiskWarningLevels; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRiskWarningLevels; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRiskWarningLevels; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRiskWarningLevels; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRiskWarningLevels; i++)
			s += group[i].toString();
		return s;
	}

public class RiskWarningLevels implements FixComponent
{

	public long riskWarningLevelPercent = 0;
	public byte[] riskWarningLevelName;

	public RiskWarningLevels() {
		super();

		riskWarningLevelName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		riskWarningLevelPercent = Long.MAX_VALUE;		
		Utils.fill( riskWarningLevelName, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RISKWARNINGLEVELPERCENT_INT) {
				riskWarningLevelPercent = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKWARNINGLEVELNAME_INT) {
				riskWarningLevelName = FixUtils.getTagStringValue(value, riskWarningLevelName);
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
		if (FixUtils.isSet(riskWarningLevelPercent)) return true;
		if (FixUtils.isSet(riskWarningLevelName)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(riskWarningLevelPercent)) FixUtils.putFixFloatTag( out, FixTags.RISKWARNINGLEVELPERCENT_INT, riskWarningLevelPercent);
		if (FixUtils.isSet(riskWarningLevelName)) FixUtils.putFixTag( out, FixTags.RISKWARNINGLEVELNAME_INT, riskWarningLevelName, 0, Utils.lastIndexTrim(riskWarningLevelName, (byte)0) );
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

			if (FixUtils.isSet(riskWarningLevelPercent)) s += "RiskWarningLevelPercent(1560)=" + String.valueOf(riskWarningLevelPercent) + sep;
			if (FixUtils.isSet(riskWarningLevelName)) s += "RiskWarningLevelName(1561)=" + new String(riskWarningLevelName) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RiskWarningLevels)) return false;

			RiskWarningLevels msg = (RiskWarningLevels) o;

		if ( ! super.equals(msg) ) return false;

		if (!( riskWarningLevelPercent==msg.riskWarningLevelPercent)) return false;

		if (!Utils.equals( riskWarningLevelName, msg.riskWarningLevelName)) return false;

		return true;
	}
}
}
