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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRiskSecAltIDGrp;

public class FixRiskInstrumentScope
{

	public int noRiskInstruments;
	public RiskInstrumentScope[] group;

	public void getAll(int noRiskInstruments, ByteBuffer buf) throws FixSessionException {
		this.noRiskInstruments = noRiskInstruments;

		if (noRiskInstruments < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group.length < noRiskInstruments) 
			group = new RiskInstrumentScope[noRiskInstruments];

		for ( int i = 0; i < noRiskInstruments; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noRiskInstruments; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noRiskInstruments; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noRiskInstruments; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noRiskInstruments; i++)
			s += group[i].toString();
		return s;
	}

public class RiskInstrumentScope implements FixComponent
{

	public long riskInstrumentOperator = 0;
	public byte[] riskSymbol;
	public byte[] riskSymbolSfx;
	public byte[] riskSecurityID;
	public byte[] riskSecurityIDSource;
	public FixRiskSecAltIDGrp riskSecAltIDGrp;
	public long riskProduct = 0;
	public byte[] riskProductComplex;
	public byte[] riskSecurityGroup;
	public byte[] riskCFICode;
	public byte[] riskSecurityType;
	public byte[] riskSecuritySubType;
	public byte[] riskMaturityMonthYear;
	public byte[] riskMaturityTime;
	public byte[] riskRestructuringType;
	public byte[] riskSeniority;
	public long riskPutOrCall = 0;
	public boolean riskFlexibleIndicator = false;
	public long riskCouponRate = 0;
	public byte[] riskSecurityExchange;
	public byte[] riskSecurityDesc;
	public long riskEncodedSecurityDescLen = 0;
	public byte[] riskEncodedSecurityDesc;
	public byte[] riskInstrumentSettlType;
	public long riskInstrumentMultiplier = 0;

	public RiskInstrumentScope() {
		super();

		riskSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecAltIDGrp = new FixRiskSecAltIDGrp();
		riskProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		riskInstrumentSettlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		riskInstrumentOperator = Long.MAX_VALUE;		
		Utils.fill( riskSymbol, (byte)0 );
		Utils.fill( riskSymbolSfx, (byte)0 );
		Utils.fill( riskSecurityID, (byte)0 );
		Utils.fill( riskSecurityIDSource, (byte)0 );
		riskProduct = Long.MAX_VALUE;		
		Utils.fill( riskProductComplex, (byte)0 );
		Utils.fill( riskSecurityGroup, (byte)0 );
		Utils.fill( riskCFICode, (byte)0 );
		Utils.fill( riskSecurityType, (byte)0 );
		Utils.fill( riskSecuritySubType, (byte)0 );
		Utils.fill( riskMaturityMonthYear, (byte)0 );
		Utils.fill( riskMaturityTime, (byte)0 );
		Utils.fill( riskRestructuringType, (byte)0 );
		Utils.fill( riskSeniority, (byte)0 );
		riskPutOrCall = Long.MAX_VALUE;		
		riskFlexibleIndicator = false;		
		riskCouponRate = Long.MAX_VALUE;		
		Utils.fill( riskSecurityExchange, (byte)0 );
		Utils.fill( riskSecurityDesc, (byte)0 );
		riskEncodedSecurityDescLen = Long.MAX_VALUE;		
		Utils.fill( riskEncodedSecurityDesc, (byte)0 );
		Utils.fill( riskInstrumentSettlType, (byte)0 );
		riskInstrumentMultiplier = Long.MAX_VALUE;		
		riskSecAltIDGrp.clear();
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.RISKINSTRUMENTOPERATOR_INT) {
				riskInstrumentOperator = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.RiskInstrumentOperator.isValid(riskInstrumentOperator) ) throw new FixSessionException(buf, "Invalid enumerated value(" + riskInstrumentOperator + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSYMBOL_INT) {
				riskSymbol = FixUtils.getTagStringValue(value, riskSymbol);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSYMBOLSFX_INT) {
				riskSymbolSfx = FixUtils.getTagStringValue(value, riskSymbolSfx);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYID_INT) {
				riskSecurityID = FixUtils.getTagStringValue(value, riskSecurityID);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYIDSOURCE_INT) {
				riskSecurityIDSource = FixUtils.getTagStringValue(value, riskSecurityIDSource);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NORISKSECURITYALTID_INT) {
				riskSecAltIDGrp.getAll(FixTags.NORISKSECURITYALTID_INT, buf);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKPRODUCT_INT) {
				riskProduct = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKPRODUCTCOMPLEX_INT) {
				riskProductComplex = FixUtils.getTagStringValue(value, riskProductComplex);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYGROUP_INT) {
				riskSecurityGroup = FixUtils.getTagStringValue(value, riskSecurityGroup);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKCFICODE_INT) {
				riskCFICode = FixUtils.getTagStringValue(value, riskCFICode);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYTYPE_INT) {
				riskSecurityType = FixUtils.getTagStringValue(value, riskSecurityType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYSUBTYPE_INT) {
				riskSecuritySubType = FixUtils.getTagStringValue(value, riskSecuritySubType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKMATURITYMONTHYEAR_INT) {
				riskMaturityMonthYear = FixUtils.getTagStringValue(value, riskMaturityMonthYear);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKMATURITYTIME_INT) {
				riskMaturityTime = FixUtils.getTagStringValue(value, riskMaturityTime);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKRESTRUCTURINGTYPE_INT) {
				riskRestructuringType = FixUtils.getTagStringValue(value, riskRestructuringType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSENIORITY_INT) {
				riskSeniority = FixUtils.getTagStringValue(value, riskSeniority);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKPUTORCALL_INT) {
				riskPutOrCall = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKFLEXIBLEINDICATOR_INT) {
				riskFlexibleIndicator = FixUtils.getTagBooleanValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKCOUPONRATE_INT) {
				riskCouponRate = FixUtils.getTagFloatValue(value);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYEXCHANGE_INT) {
				riskSecurityExchange = FixUtils.getTagStringValue(value, riskSecurityExchange);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKSECURITYDESC_INT) {
				riskSecurityDesc = FixUtils.getTagStringValue(value, riskSecurityDesc);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKENCODEDSECURITYDESCLEN_INT) {
				riskEncodedSecurityDescLen = FixUtils.getTagIntValue( value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKENCODEDSECURITYDESC_INT) {
				riskEncodedSecurityDesc = FixUtils.getTagStringValue(value, riskEncodedSecurityDesc);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKINSTRUMENTSETTLTYPE_INT) {
				riskInstrumentSettlType = FixUtils.getTagStringValue(value, riskInstrumentSettlType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.RISKINSTRUMENTMULTIPLIER_INT) {
				riskInstrumentMultiplier = FixUtils.getTagFloatValue(value);
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
		if (FixUtils.isSet(riskInstrumentOperator)) return true;
		if (FixUtils.isSet(riskSymbol)) return true;
		if (FixUtils.isSet(riskSymbolSfx)) return true;
		if (FixUtils.isSet(riskSecurityID)) return true;
		if (FixUtils.isSet(riskSecurityIDSource)) return true;
		if (FixUtils.isSet(riskSecAltIDGrp.noRiskSecurityAltID)) return true;
		if (FixUtils.isSet(riskProduct)) return true;
		if (FixUtils.isSet(riskProductComplex)) return true;
		if (FixUtils.isSet(riskSecurityGroup)) return true;
		if (FixUtils.isSet(riskCFICode)) return true;
		if (FixUtils.isSet(riskSecurityType)) return true;
		if (FixUtils.isSet(riskSecuritySubType)) return true;
		if (FixUtils.isSet(riskMaturityMonthYear)) return true;
		if (FixUtils.isSet(riskMaturityTime)) return true;
		if (FixUtils.isSet(riskRestructuringType)) return true;
		if (FixUtils.isSet(riskSeniority)) return true;
		if (FixUtils.isSet(riskPutOrCall)) return true;
		if (FixUtils.isSet(riskFlexibleIndicator)) return true;
		if (FixUtils.isSet(riskCouponRate)) return true;
		if (FixUtils.isSet(riskSecurityExchange)) return true;
		if (FixUtils.isSet(riskSecurityDesc)) return true;
		if (FixUtils.isSet(riskEncodedSecurityDescLen)) return true;
		if (FixUtils.isSet(riskEncodedSecurityDesc)) return true;
		if (FixUtils.isSet(riskInstrumentSettlType)) return true;
		if (FixUtils.isSet(riskInstrumentMultiplier)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(riskInstrumentOperator)) FixUtils.putFixTag( out, FixTags.RISKINSTRUMENTOPERATOR_INT, riskInstrumentOperator);
		if (FixUtils.isSet(riskSymbol)) FixUtils.putFixTag( out, FixTags.RISKSYMBOL_INT, riskSymbol, 0, Utils.lastIndexTrim(riskSymbol, (byte)0) );
		if (FixUtils.isSet(riskSymbolSfx)) FixUtils.putFixTag( out, FixTags.RISKSYMBOLSFX_INT, riskSymbolSfx, 0, Utils.lastIndexTrim(riskSymbolSfx, (byte)0) );
		if (FixUtils.isSet(riskSecurityID)) FixUtils.putFixTag( out, FixTags.RISKSECURITYID_INT, riskSecurityID, 0, Utils.lastIndexTrim(riskSecurityID, (byte)0) );
		if (FixUtils.isSet(riskSecurityIDSource)) FixUtils.putFixTag( out, FixTags.RISKSECURITYIDSOURCE_INT, riskSecurityIDSource, 0, Utils.lastIndexTrim(riskSecurityIDSource, (byte)0) );
		if (FixUtils.isSet(riskSecAltIDGrp.noRiskSecurityAltID)) riskSecAltIDGrp.encode( out );
		if (FixUtils.isSet(riskProduct)) FixUtils.putFixTag( out, FixTags.RISKPRODUCT_INT, riskProduct);
		if (FixUtils.isSet(riskProductComplex)) FixUtils.putFixTag( out, FixTags.RISKPRODUCTCOMPLEX_INT, riskProductComplex, 0, Utils.lastIndexTrim(riskProductComplex, (byte)0) );
		if (FixUtils.isSet(riskSecurityGroup)) FixUtils.putFixTag( out, FixTags.RISKSECURITYGROUP_INT, riskSecurityGroup, 0, Utils.lastIndexTrim(riskSecurityGroup, (byte)0) );
		if (FixUtils.isSet(riskCFICode)) FixUtils.putFixTag( out, FixTags.RISKCFICODE_INT, riskCFICode, 0, Utils.lastIndexTrim(riskCFICode, (byte)0) );
		if (FixUtils.isSet(riskSecurityType)) FixUtils.putFixTag( out, FixTags.RISKSECURITYTYPE_INT, riskSecurityType, 0, Utils.lastIndexTrim(riskSecurityType, (byte)0) );
		if (FixUtils.isSet(riskSecuritySubType)) FixUtils.putFixTag( out, FixTags.RISKSECURITYSUBTYPE_INT, riskSecuritySubType, 0, Utils.lastIndexTrim(riskSecuritySubType, (byte)0) );
		if (FixUtils.isSet(riskMaturityMonthYear)) FixUtils.putFixTag( out, FixTags.RISKMATURITYMONTHYEAR_INT, riskMaturityMonthYear);
		if (FixUtils.isSet(riskMaturityTime)) FixUtils.putFixTag( out, FixTags.RISKMATURITYTIME_INT, riskMaturityTime);
		if (FixUtils.isSet(riskRestructuringType)) FixUtils.putFixTag( out, FixTags.RISKRESTRUCTURINGTYPE_INT, riskRestructuringType, 0, Utils.lastIndexTrim(riskRestructuringType, (byte)0) );
		if (FixUtils.isSet(riskSeniority)) FixUtils.putFixTag( out, FixTags.RISKSENIORITY_INT, riskSeniority, 0, Utils.lastIndexTrim(riskSeniority, (byte)0) );
		if (FixUtils.isSet(riskPutOrCall)) FixUtils.putFixTag( out, FixTags.RISKPUTORCALL_INT, riskPutOrCall);
		if (FixUtils.isSet(riskFlexibleIndicator)) FixUtils.putFixTag( out, FixTags.RISKFLEXIBLEINDICATOR_INT, riskFlexibleIndicator?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(riskCouponRate)) FixUtils.putFixFloatTag( out, FixTags.RISKCOUPONRATE_INT, riskCouponRate);
		if (FixUtils.isSet(riskSecurityExchange)) FixUtils.putFixTag( out, FixTags.RISKSECURITYEXCHANGE_INT, riskSecurityExchange, 0, Utils.lastIndexTrim(riskSecurityExchange, (byte)0) );
		if (FixUtils.isSet(riskSecurityDesc)) FixUtils.putFixTag( out, FixTags.RISKSECURITYDESC_INT, riskSecurityDesc, 0, Utils.lastIndexTrim(riskSecurityDesc, (byte)0) );
		if (FixUtils.isSet(riskEncodedSecurityDescLen)) FixUtils.putFixTag( out, FixTags.RISKENCODEDSECURITYDESCLEN_INT, riskEncodedSecurityDescLen);
		if (FixUtils.isSet(riskEncodedSecurityDesc)) FixUtils.putFixTag( out, FixTags.RISKENCODEDSECURITYDESC_INT, riskEncodedSecurityDesc, 0, Utils.lastIndexTrim(riskEncodedSecurityDesc, (byte)0) );
		if (FixUtils.isSet(riskInstrumentSettlType)) FixUtils.putFixTag( out, FixTags.RISKINSTRUMENTSETTLTYPE_INT, riskInstrumentSettlType, 0, Utils.lastIndexTrim(riskInstrumentSettlType, (byte)0) );
		if (FixUtils.isSet(riskInstrumentMultiplier)) FixUtils.putFixFloatTag( out, FixTags.RISKINSTRUMENTMULTIPLIER_INT, riskInstrumentMultiplier);
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

			if (FixUtils.isSet(riskInstrumentOperator)) s += "RiskInstrumentOperator(1535)=" + String.valueOf(riskInstrumentOperator) + sep;
			if (FixUtils.isSet(riskSymbol)) s += "RiskSymbol(1536)=" + new String(riskSymbol) + sep;
			if (FixUtils.isSet(riskSymbolSfx)) s += "RiskSymbolSfx(1537)=" + new String(riskSymbolSfx) + sep;
			if (FixUtils.isSet(riskSecurityID)) s += "RiskSecurityID(1538)=" + new String(riskSecurityID) + sep;
			if (FixUtils.isSet(riskSecurityIDSource)) s += "RiskSecurityIDSource(1539)=" + new String(riskSecurityIDSource) + sep;
			if (FixUtils.isSet(riskSecAltIDGrp.noRiskSecurityAltID)) s += riskSecAltIDGrp.toString();
			if (FixUtils.isSet(riskProduct)) s += "RiskProduct(1543)=" + String.valueOf(riskProduct) + sep;
			if (FixUtils.isSet(riskProductComplex)) s += "RiskProductComplex(1544)=" + new String(riskProductComplex) + sep;
			if (FixUtils.isSet(riskSecurityGroup)) s += "RiskSecurityGroup(1545)=" + new String(riskSecurityGroup) + sep;
			if (FixUtils.isSet(riskCFICode)) s += "RiskCFICode(1546)=" + new String(riskCFICode) + sep;
			if (FixUtils.isSet(riskSecurityType)) s += "RiskSecurityType(1547)=" + new String(riskSecurityType) + sep;
			if (FixUtils.isSet(riskSecuritySubType)) s += "RiskSecuritySubType(1548)=" + new String(riskSecuritySubType) + sep;
			if (FixUtils.isSet(riskMaturityMonthYear)) s += "RiskMaturityMonthYear(1549)=" + new String(riskMaturityMonthYear) + sep;
			if (FixUtils.isSet(riskMaturityTime)) s += "RiskMaturityTime(1550)=" + new String(riskMaturityTime) + sep;
			if (FixUtils.isSet(riskRestructuringType)) s += "RiskRestructuringType(1551)=" + new String(riskRestructuringType) + sep;
			if (FixUtils.isSet(riskSeniority)) s += "RiskSeniority(1552)=" + new String(riskSeniority) + sep;
			if (FixUtils.isSet(riskPutOrCall)) s += "RiskPutOrCall(1553)=" + String.valueOf(riskPutOrCall) + sep;
			if (FixUtils.isSet(riskFlexibleIndicator)) s += "RiskFlexibleIndicator(1554)=" + String.valueOf(riskFlexibleIndicator) + sep;
			if (FixUtils.isSet(riskCouponRate)) s += "RiskCouponRate(1555)=" + String.valueOf(riskCouponRate) + sep;
			if (FixUtils.isSet(riskSecurityExchange)) s += "RiskSecurityExchange(1616)=" + new String(riskSecurityExchange) + sep;
			if (FixUtils.isSet(riskSecurityDesc)) s += "RiskSecurityDesc(1556)=" + new String(riskSecurityDesc) + sep;
			if (FixUtils.isSet(riskEncodedSecurityDescLen)) s += "RiskEncodedSecurityDescLen(1620)=" + String.valueOf(riskEncodedSecurityDescLen) + sep;
			if (FixUtils.isSet(riskEncodedSecurityDesc)) s += "RiskEncodedSecurityDesc(1621)=" + new String(riskEncodedSecurityDesc) + sep;
			if (FixUtils.isSet(riskInstrumentSettlType)) s += "RiskInstrumentSettlType(1557)=" + new String(riskInstrumentSettlType) + sep;
			if (FixUtils.isSet(riskInstrumentMultiplier)) s += "RiskInstrumentMultiplier(1558)=" + String.valueOf(riskInstrumentMultiplier) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof RiskInstrumentScope)) return false;

			RiskInstrumentScope msg = (RiskInstrumentScope) o;

		if ( ! super.equals(msg) ) return false;

		if (!( riskInstrumentOperator==msg.riskInstrumentOperator)) return false;

		if (!Utils.equals( riskSymbol, msg.riskSymbol)) return false;

		if (!Utils.equals( riskSymbolSfx, msg.riskSymbolSfx)) return false;

		if (!Utils.equals( riskSecurityID, msg.riskSecurityID)) return false;

		if (!Utils.equals( riskSecurityIDSource, msg.riskSecurityIDSource)) return false;

		if (!riskSecAltIDGrp.equals(msg.riskSecAltIDGrp)) return false;

		if (!( riskProduct==msg.riskProduct)) return false;

		if (!Utils.equals( riskProductComplex, msg.riskProductComplex)) return false;

		if (!Utils.equals( riskSecurityGroup, msg.riskSecurityGroup)) return false;

		if (!Utils.equals( riskCFICode, msg.riskCFICode)) return false;

		if (!Utils.equals( riskSecurityType, msg.riskSecurityType)) return false;

		if (!Utils.equals( riskSecuritySubType, msg.riskSecuritySubType)) return false;

		if (!Utils.equals( riskMaturityMonthYear, msg.riskMaturityMonthYear)) return false;

		if (!Utils.equals( riskRestructuringType, msg.riskRestructuringType)) return false;

		if (!Utils.equals( riskSeniority, msg.riskSeniority)) return false;

		if (!( riskPutOrCall==msg.riskPutOrCall)) return false;

		if (!( riskFlexibleIndicator==msg.riskFlexibleIndicator)) return false;

		if (!( riskCouponRate==msg.riskCouponRate)) return false;

		if (!Utils.equals( riskSecurityExchange, msg.riskSecurityExchange)) return false;

		if (!Utils.equals( riskSecurityDesc, msg.riskSecurityDesc)) return false;

		if (!( riskEncodedSecurityDescLen==msg.riskEncodedSecurityDescLen)) return false;

		if (!Utils.equals( riskEncodedSecurityDesc, msg.riskEncodedSecurityDesc)) return false;

		if (!Utils.equals( riskInstrumentSettlType, msg.riskInstrumentSettlType)) return false;

		if (!( riskInstrumentMultiplier==msg.riskInstrumentMultiplier)) return false;

		return true;
	}
}
}
