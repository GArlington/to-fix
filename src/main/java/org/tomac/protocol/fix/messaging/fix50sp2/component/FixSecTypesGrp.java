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

public class FixSecTypesGrp
{

	public int noSecurityTypes;
	public SecTypesGrp[] group;

	public void getAll(int noSecurityTypes, ByteBuffer buf) throws FixSessionException {
		this.noSecurityTypes = noSecurityTypes;

		if (noSecurityTypes < 1) throw new FixSessionException("asdasd");
		// this will leak memory if we grow the group
		if (group == null || group.length < noSecurityTypes) {
			group = new SecTypesGrp[noSecurityTypes];

			for ( int i = 0; i < noSecurityTypes; i++ ) group[i] = new SecTypesGrp();
	}

		for ( int i = 0; i < noSecurityTypes; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noSecurityTypes; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noSecurityTypes; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noSecurityTypes; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noSecurityTypes; i++)
			s += group[i].toString();
		return s;
	}

public class SecTypesGrp implements FixComponent
{

	public byte[] securityType;
	public byte[] securitySubType;
	public long product = 0;
	public byte[] cFICode;
	public byte[] transactTime;

	public SecTypesGrp() {
		super();

		securityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		securitySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		cFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( securityType, (byte)0 );
		Utils.fill( securitySubType, (byte)0 );
		product = Long.MAX_VALUE;		
		Utils.fill( cFICode, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.SECURITYTYPE_INT) {
				securityType = FixUtils.getTagStringValue(value, securityType);
				if (!FixMessageInfo.SecurityType.isValid(securityType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + securityType + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.SECURITYSUBTYPE_INT) {
				securitySubType = FixUtils.getTagStringValue(value, securitySubType);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.PRODUCT_INT) {
				product = FixUtils.getTagIntValue( value );
				if (!FixMessageInfo.Product.isValid(product) ) throw new FixSessionException(buf, "Invalid enumerated value(" + product + ") for tag: " + id );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.CFICODE_INT) {
				cFICode = FixUtils.getTagStringValue(value, cFICode);
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.TRANSACTTIME_INT) {
				transactTime = FixUtils.getTagStringValue(value, transactTime);
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
		if (FixUtils.isSet(securityType)) return true;
		if (FixUtils.isSet(securitySubType)) return true;
		if (FixUtils.isSet(product)) return true;
		if (FixUtils.isSet(cFICode)) return true;
		if (FixUtils.isSet(transactTime)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(securityType)) FixUtils.putFixTag( out, FixTags.SECURITYTYPE_INT, securityType, 0, Utils.lastIndexTrim(securityType, (byte)0) );
		if (FixUtils.isSet(securitySubType)) FixUtils.putFixTag( out, FixTags.SECURITYSUBTYPE_INT, securitySubType, 0, Utils.lastIndexTrim(securitySubType, (byte)0) );
		if (FixUtils.isSet(product)) FixUtils.putFixTag( out, FixTags.PRODUCT_INT, product);
		if (FixUtils.isSet(cFICode)) FixUtils.putFixTag( out, FixTags.CFICODE_INT, cFICode, 0, Utils.lastIndexTrim(cFICode, (byte)0) );
		if (FixUtils.isSet(transactTime)) FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
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

			if (FixUtils.isSet(securityType)) s += "SecurityType(167)=" + new String(securityType) + sep;
			if (FixUtils.isSet(securitySubType)) s += "SecuritySubType(762)=" + new String(securitySubType) + sep;
			if (FixUtils.isSet(product)) s += "Product(460)=" + String.valueOf(product) + sep;
			if (FixUtils.isSet(cFICode)) s += "CFICode(461)=" + new String(cFICode) + sep;
			if (FixUtils.isSet(transactTime)) s += "TransactTime(60)=" + new String(transactTime) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof SecTypesGrp)) return false;

			SecTypesGrp msg = (SecTypesGrp) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( securityType, msg.securityType)) return false;

		if (!Utils.equals( securitySubType, msg.securitySubType)) return false;

		if (!( product==msg.product)) return false;

		if (!Utils.equals( cFICode, msg.cFICode)) return false;

		return true;
	}
}
}
