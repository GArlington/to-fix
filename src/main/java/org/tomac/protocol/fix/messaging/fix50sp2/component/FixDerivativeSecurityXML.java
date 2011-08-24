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

public class FixDerivativeSecurityXML implements FixComponent
{

	public long derivativeSecurityXMLLen = 0;
	public byte[] derivativeSecurityXML;
	public byte[] derivativeSecurityXMLSchema;

	public FixDerivativeSecurityXML() {
		super();

		derivativeSecurityXML = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		derivativeSecurityXMLSchema = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		derivativeSecurityXMLLen = Long.MAX_VALUE;		
		Utils.fill( derivativeSecurityXML, (byte)0 );
		Utils.fill( derivativeSecurityXMLSchema, (byte)0 );
	}

	public void getAll(int id, ByteBuffer buf) throws FixSessionException
	{

		int startTagPosition = buf.position();

		int lastTagPosition = buf.position();
		do {
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.DERIVATIVESECURITYXMLLEN_INT:
				derivativeSecurityXMLLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.DERIVATIVESECURITYXML_INT:
				derivativeSecurityXML = FixUtils.getTagStringValue(value, derivativeSecurityXML);
				break;

			case FixTags.DERIVATIVESECURITYXMLSCHEMA_INT:
				derivativeSecurityXMLSchema = FixUtils.getTagStringValue(value, derivativeSecurityXMLSchema);
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
		if (FixUtils.isSet(derivativeSecurityXMLLen)) return true;
		if (FixUtils.isSet(derivativeSecurityXML)) return true;
		if (FixUtils.isSet(derivativeSecurityXMLSchema)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(derivativeSecurityXMLLen)) FixUtils.putFixTag( out, FixTags.DERIVATIVESECURITYXMLLEN_INT, derivativeSecurityXMLLen);
		if (FixUtils.isSet(derivativeSecurityXML)) FixUtils.putFixTag( out, FixTags.DERIVATIVESECURITYXML_INT, derivativeSecurityXML, 0, Utils.lastIndexTrim(derivativeSecurityXML, (byte)0) );
		if (FixUtils.isSet(derivativeSecurityXMLSchema)) FixUtils.putFixTag( out, FixTags.DERIVATIVESECURITYXMLSCHEMA_INT, derivativeSecurityXMLSchema, 0, Utils.lastIndexTrim(derivativeSecurityXMLSchema, (byte)0) );
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

			if (FixUtils.isSet(derivativeSecurityXMLLen)) s += "DerivativeSecurityXMLLen(1282)=" + String.valueOf(derivativeSecurityXMLLen) + sep;
			if (FixUtils.isSet(derivativeSecurityXML)) s += "DerivativeSecurityXML(1283)=" + new String(derivativeSecurityXML) + sep;
			if (FixUtils.isSet(derivativeSecurityXMLSchema)) s += "DerivativeSecurityXMLSchema(1284)=" + new String(derivativeSecurityXMLSchema) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityXML)) return false;

			FixDerivativeSecurityXML msg = (FixDerivativeSecurityXML) o;

		if ( ! super.equals(msg) ) return false;

		if (!( derivativeSecurityXMLLen==msg.derivativeSecurityXMLLen)) return false;

		if (!Utils.equals( derivativeSecurityXML, msg.derivativeSecurityXML)) return false;

		if (!Utils.equals( derivativeSecurityXMLSchema, msg.derivativeSecurityXMLSchema)) return false;

		return true;
	}
}
