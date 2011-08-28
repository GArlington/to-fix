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

public class FixNestedInstrumentAttribute
{

	public int noNestedInstrAttrib;
	public NestedInstrumentAttribute[] group;

	public void getAll(int noNestedInstrAttrib, ByteBuffer buf) throws FixSessionException, FixGarbledException {
		this.noNestedInstrAttrib = noNestedInstrAttrib;

		if (noNestedInstrAttrib < 1) throw new FixSessionException(SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, ("Incorrect num in group count " + noNestedInstrAttrib ).getBytes(), FixTags.NONESTEDINSTRATTRIB_INT, new byte[0]);
		// this will leak memory if we grow the group
		if (group == null || group.length < noNestedInstrAttrib) {
			group = new NestedInstrumentAttribute[noNestedInstrAttrib];

			for ( int i = 0; i < noNestedInstrAttrib; i++ ) group[i] = new NestedInstrumentAttribute();
	}

		for ( int i = 0; i < noNestedInstrAttrib; i++ ) 
			group[i].getAllGroup(buf);
	}

	public void clear() {
		for (int i = 0; i<noNestedInstrAttrib; i++)
			group[i].clear();
	}
	public void encode(ByteBuffer out) {
		for (int i = 0; i<noNestedInstrAttrib; i++)
			group[i].encode(out);
	}
	public boolean isSet() {
		for (int i = 0; i<noNestedInstrAttrib; i++)
			if (group[i].isSet()) return true;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedInstrumentAttribute)) return false;

		FixNestedInstrumentAttribute msg = (FixNestedInstrumentAttribute) o;

		for (int i = 0; i<noNestedInstrAttrib; i++)
			if (!group[i].equals(msg.group[i])) return false;
		return true;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i<noNestedInstrAttrib; i++)
			s += group[i].toString();
		return s;
	}

public class NestedInstrumentAttribute implements FixComponent
{

	public long nestedInstrAttribType = 0;
	public byte[] nestedInstrAttribValue;

	public NestedInstrumentAttribute() {
		super();

		nestedInstrAttribValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		nestedInstrAttribType = Long.MAX_VALUE;		
		Utils.fill( nestedInstrAttribValue, (byte)0 );
	}

	public void getAllGroup(ByteBuffer buf) throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		int id = FixUtils.getTagId( buf );
		int lastTagPosition = buf.position();
			ByteBuffer value;

			value = buf;

			if(id == FixTags.NESTEDINSTRATTRIBTYPE_INT) {
				nestedInstrAttribType = FixUtils.getTagIntValue(null ,id ,value );
				lastTagPosition = buf.position();

				id = FixUtils.getTagId( buf );
			}

			if(id == FixTags.NESTEDINSTRATTRIBVALUE_INT) {
				nestedInstrAttribValue = FixUtils.getTagStringValue(null ,id ,value, nestedInstrAttribValue);
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
		if (FixUtils.isSet(nestedInstrAttribType)) return true;
		if (FixUtils.isSet(nestedInstrAttribValue)) return true;
		return false;
	}
	@Override
	public void encode( ByteBuffer out )
	{
		if (FixUtils.isSet(nestedInstrAttribType)) FixUtils.putFixTag( out, FixTags.NESTEDINSTRATTRIBTYPE_INT, nestedInstrAttribType);
		if (FixUtils.isSet(nestedInstrAttribValue)) FixUtils.putFixTag( out, FixTags.NESTEDINSTRATTRIBVALUE_INT, nestedInstrAttribValue, 0, Utils.lastIndexTrim(nestedInstrAttribValue, (byte)0) );
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

			if (FixUtils.isSet(nestedInstrAttribType)) s += "NestedInstrAttribType(1210)=" + String.valueOf(nestedInstrAttribType) + sep;
			if (FixUtils.isSet(nestedInstrAttribValue)) s += "NestedInstrAttribValue(1211)=" + new String(nestedInstrAttribValue) + sep;
		return s;

	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof NestedInstrumentAttribute)) return false;

			NestedInstrumentAttribute msg = (NestedInstrumentAttribute) o;

		if (!( nestedInstrAttribType==msg.nestedInstrAttribType)) return false;

		if (!Utils.equals( nestedInstrAttribValue, msg.nestedInstrAttribValue)) return false;

		return true;
	}
}
}
