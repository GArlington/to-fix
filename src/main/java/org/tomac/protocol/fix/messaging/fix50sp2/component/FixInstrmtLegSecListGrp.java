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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentLeg;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLegStipulations;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLegBenchmarkCurveData;

public class FixInstrmtLegSecListGrp
{

	public int noLegs;
	public InstrmtLegSecListGrp[] group;

	public void getAll(int noLegs, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noLegs = noLegs;

		if (noLegs < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noLegs ).getBytes(), FixTags.NOLEGS_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noLegs) {
			group = new InstrmtLegSecListGrp[noLegs];

			for ( int i = 0; i < noLegs; i++ ) group[i] = new InstrmtLegSecListGrp();
	}

		for ( int i = 0; i < noLegs; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noLegs; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noLegs; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noLegs; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noLegs; i++)
			s += group[i].toString();
		return s;
	}

public class InstrmtLegSecListGrp implements FixComponent
{

	public FixInstrumentLeg instrumentLeg;
	public long legSwapType = 0;
	public byte legSettlType = (byte)' ';
	public FixLegStipulations legStipulations;
	public FixLegBenchmarkCurveData legBenchmarkCurveData;

	public InstrmtLegSecListGrp() {
		super();

		instrumentLeg = new FixInstrumentLeg();
		legStipulations = new FixLegStipulations();
		legBenchmarkCurveData = new FixLegBenchmarkCurveData();
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		legSwapType = Long.MAX_VALUE;		
		legSettlType = Byte.MAX_VALUE;		
		instrumentLeg.clear();
		legStipulations.clear();
		legBenchmarkCurveData.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.LEGSYMBOL_INT) {
				instrumentLeg.getAll(FixTags.LEGSYMBOL_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSWAPTYPE_INT) {
				legSwapType = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.LegSwapType.isValid(legSwapType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + legSwapType + ") for tag").getBytes(), id, new byte[0] );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGSETTLTYPE_INT) {
				legSettlType = FixUtils.getTagCharValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NOLEGSTIPULATIONS_INT) {
				legStipulations.getAll(FixTags.NOLEGSTIPULATIONS_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.LEGBENCHMARKCURVECURRENCY_INT) {
				legBenchmarkCurveData.getAll(FixTags.LEGBENCHMARKCURVECURRENCY_INT, buf);
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
		if (FixUtils.isSet(instrumentLeg.legSymbol)) return true;
		if (FixUtils.isSet(legSwapType)) return true;
		if (FixUtils.isSet(legSettlType)) return true;
		if (FixUtils.isSet(legStipulations.noLegStipulations)) return true;
		if (FixUtils.isSet(legBenchmarkCurveData.legBenchmarkCurveCurrency)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(instrumentLeg.legSymbol)) instrumentLeg.encode( out );
		if (FixUtils.isSet(legSwapType)) FixUtils.putFixTag( out, FixTags.LEGSWAPTYPE_INT, legSwapType);
		if (FixUtils.isSet(legSettlType)) FixUtils.putFixTag( out, FixTags.LEGSETTLTYPE_INT, legSettlType );
		if (FixUtils.isSet(legStipulations.noLegStipulations)) legStipulations.encode( out );
		if (FixUtils.isSet(legBenchmarkCurveData.legBenchmarkCurveCurrency)) legBenchmarkCurveData.encode( out );
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

			if (FixUtils.isSet(instrumentLeg.legSymbol)) s += instrumentLeg.toString();
			if (FixUtils.isSet(legSwapType)) s += "LegSwapType(690)=" + String.valueOf(legSwapType) + sep;
			if (FixUtils.isSet(legSettlType)) s += "LegSettlType(587)=" + String.valueOf(legSettlType) + sep;
			if (FixUtils.isSet(legStipulations.noLegStipulations)) s += legStipulations.toString();
			if (FixUtils.isSet(legBenchmarkCurveData.legBenchmarkCurveCurrency)) s += legBenchmarkCurveData.toString();
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof InstrmtLegSecListGrp)) return false;

			InstrmtLegSecListGrp msg = (InstrmtLegSecListGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!instrumentLeg.equals(msg.instrumentLeg)) return false;

		if (!( legSwapType==msg.legSwapType)) return false;

		if (!( legSettlType==msg.legSettlType)) return false;

		if (!legStipulations.equals(msg.legStipulations)) return false;

		if (!legBenchmarkCurveData.equals(msg.legBenchmarkCurveData)) return false;

		return true;
	}
}
}
