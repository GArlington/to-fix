package org.tomac.protocol.fix.messaging.fix50sp2;

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


import org.tomac.protocol.fix.messaging.fix50sp2.component.FixHopGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRoutingGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLinesOfTextGrp;

public class FixEmail extends FixMessage
{

	public byte[] emailThreadID;
	public byte emailType = (byte)' ';
	public byte[] origTime;
	public byte[] subject;
	public long encodedSubjectLen = 0;
	public byte[] encodedSubject;
	public FixRoutingGrp routingGrp;
	public FixInstrmtGrp instrmtGrp;
	public FixUndInstrmtGrp undInstrmtGrp;
	public FixInstrmtLegGrp instrmtLegGrp;
	public byte[] orderID;
	public byte[] clOrdID;
	public FixLinesOfTextGrp linesOfTextGrp;
	public long rawDataLength = 0;
	public byte[] rawData;

	public FixEmail() {
		super();

		emailThreadID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		origTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		subject = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		encodedSubject = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		routingGrp = new FixRoutingGrp();
		instrmtGrp = new FixInstrmtGrp();
		undInstrmtGrp = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp();
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		linesOfTextGrp = new FixLinesOfTextGrp();
		rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

		msgType = MsgTypes.EMAIL_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( emailThreadID, (byte)0 );
		emailType = Byte.MAX_VALUE;		
		Utils.fill( origTime, (byte)0 );
		Utils.fill( subject, (byte)0 );
		encodedSubjectLen = Long.MAX_VALUE;		
		Utils.fill( encodedSubject, (byte)0 );
		Utils.fill( orderID, (byte)0 );
		Utils.fill( clOrdID, (byte)0 );
		rawDataLength = Long.MAX_VALUE;		
		Utils.fill( rawData, (byte)0 );
		routingGrp.clear();
		instrmtGrp.clear();
		undInstrmtGrp.clear();
		instrmtLegGrp.clear();
		linesOfTextGrp.clear();
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) >= 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.EMAILTHREADID_INT:
				emailThreadID = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, emailThreadID);
				break;

			case FixTags.EMAILTYPE_INT:
				emailType = FixUtils.getTagCharValue(MsgTypes.EMAIL ,id ,value );
				if (!EmailType.isValid(emailType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + emailType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.ORIGTIME_INT:
				origTime = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, origTime);
				break;

			case FixTags.SUBJECT_INT:
				subject = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, subject);
				break;

			case FixTags.ENCODEDSUBJECTLEN_INT:
				encodedSubjectLen = FixUtils.getTagIntValue(MsgTypes.EMAIL ,id ,value );
				break;

			case FixTags.ENCODEDSUBJECT_INT:
				encodedSubject = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, encodedSubject);
				break;

			case FixTags.NOROUTINGIDS_INT:
				routingGrp.noRoutingIDs = FixUtils.getTagIntValue( MsgTypes.EMAIL ,FixTags.NOROUTINGIDS_INT ,value );
				routingGrp.getAll(routingGrp.noRoutingIDs, value );
				break;

			case FixTags.NORELATEDSYM_INT:
				instrmtGrp.noRelatedSym = FixUtils.getTagIntValue( MsgTypes.EMAIL ,FixTags.NORELATEDSYM_INT ,value );
				instrmtGrp.getAll(instrmtGrp.noRelatedSym, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtGrp.noUnderlyings = FixUtils.getTagIntValue( MsgTypes.EMAIL ,FixTags.NOUNDERLYINGS_INT ,value );
				undInstrmtGrp.getAll(undInstrmtGrp.noUnderlyings, value );
				break;

			case FixTags.NOLEGS_INT:
				instrmtLegGrp.noLegs = FixUtils.getTagIntValue( MsgTypes.EMAIL ,FixTags.NOLEGS_INT ,value );
				instrmtLegGrp.getAll(instrmtLegGrp.noLegs, value );
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, orderID);
				break;

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, clOrdID);
				break;

			case FixTags.NOLINESOFTEXT_INT:
				linesOfTextGrp.noLinesOfText = FixUtils.getTagIntValue( MsgTypes.EMAIL ,FixTags.NOLINESOFTEXT_INT ,value );
				linesOfTextGrp.getAll(linesOfTextGrp.noLinesOfText, value );
				break;

			case FixTags.RAWDATALENGTH_INT:
				rawDataLength = FixUtils.getTagIntValue(MsgTypes.EMAIL ,id ,value );
				break;

			case FixTags.RAWDATA_INT:
				rawData = FixUtils.getTagStringValue(MsgTypes.EMAIL ,id ,value, rawData);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.EMAIL ,FixTags.CHECKSUM_INT, value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, FixUtils.getMsgType(msgType) );

				return;

			default:
				throw new FixSessionException(SessionRejectReason.UNDEFINED_TAG, "Unknown tag".getBytes(), id, FixUtils.getMsgType(msgType) );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(emailThreadID) ) return FixTags.EMAILTHREADID_INT;
		if (! FixUtils.isSet(emailType) ) return FixTags.EMAILTYPE_INT;
		if (! FixUtils.isSet(subject) ) return FixTags.SUBJECT_INT;
		if (! linesOfTextGrp.isSet() ) return FixTags.NOLINESOFTEXT_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.EMAIL);

		// encode all fields including the header

		if (FixUtils.isSet(applVerID)) FixUtils.putFixTag( out, FixTags.APPLVERID_INT, applVerID, 0, Utils.lastIndexTrim(applVerID, (byte)0) );
		if (FixUtils.isSet(cstmApplVerID)) FixUtils.putFixTag( out, FixTags.CSTMAPPLVERID_INT, cstmApplVerID, 0, Utils.lastIndexTrim(cstmApplVerID, (byte)0) );
		if (FixUtils.isSet(applExtID)) FixUtils.putFixTag( out, FixTags.APPLEXTID_INT, applExtID);
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(secureDataLen)) FixUtils.putFixTag( out, FixTags.SECUREDATALEN_INT, secureDataLen);
		if (FixUtils.isSet(secureData)) FixUtils.putFixTag( out, FixTags.SECUREDATA_INT, secureData, 0, Utils.lastIndexTrim(secureData, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		if (FixUtils.isSet(senderLocationID)) FixUtils.putFixTag( out, FixTags.SENDERLOCATIONID_INT, senderLocationID, 0, Utils.lastIndexTrim(senderLocationID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(targetLocationID)) FixUtils.putFixTag( out, FixTags.TARGETLOCATIONID_INT, targetLocationID, 0, Utils.lastIndexTrim(targetLocationID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfLocationID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFLOCATIONID_INT, onBehalfOfLocationID, 0, Utils.lastIndexTrim(onBehalfOfLocationID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );
		if (FixUtils.isSet(deliverToLocationID)) FixUtils.putFixTag( out, FixTags.DELIVERTOLOCATIONID_INT, deliverToLocationID, 0, Utils.lastIndexTrim(deliverToLocationID, (byte)0) );
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(xmlDataLen)) FixUtils.putFixTag( out, FixTags.XMLDATALEN_INT, xmlDataLen);
		if (FixUtils.isSet(xmlData)) FixUtils.putFixTag( out, FixTags.XMLDATA_INT, xmlData, 0, Utils.lastIndexTrim(xmlData, (byte)0) );
		if (FixUtils.isSet(messageEncoding)) FixUtils.putFixTag( out, FixTags.MESSAGEENCODING_INT, messageEncoding, 0, Utils.lastIndexTrim(messageEncoding, (byte)0) );
		if (FixUtils.isSet(lastMsgSeqNumProcessed)) FixUtils.putFixTag( out, FixTags.LASTMSGSEQNUMPROCESSED_INT, lastMsgSeqNumProcessed);
		if ( FixUtils.isSet(hopGrp.noHops) )hopGrp.encode( out );

		FixUtils.putFixTag( out, FixTags.EMAILTHREADID_INT, emailThreadID, 0, Utils.lastIndexTrim(emailThreadID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EMAILTYPE_INT, emailType );
		if (FixUtils.isSet(origTime)) FixUtils.putFixTag( out, FixTags.ORIGTIME_INT, origTime);
		FixUtils.putFixTag( out, FixTags.SUBJECT_INT, subject, 0, Utils.lastIndexTrim(subject, (byte)0) );
		if (FixUtils.isSet(encodedSubjectLen)) FixUtils.putFixTag( out, FixTags.ENCODEDSUBJECTLEN_INT, encodedSubjectLen);
		if (FixUtils.isSet(encodedSubject)) FixUtils.putFixTag( out, FixTags.ENCODEDSUBJECT_INT, encodedSubject, 0, Utils.lastIndexTrim(encodedSubject, (byte)0) );
		if (FixUtils.isSet(routingGrp.noRoutingIDs)) routingGrp.encode( out );
		if (FixUtils.isSet(instrmtGrp.noRelatedSym)) instrmtGrp.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(orderID)) FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(linesOfTextGrp.noLinesOfText)) linesOfTextGrp.encode( out );
		if (FixUtils.isSet(rawDataLength)) FixUtils.putFixTag( out, FixTags.RAWDATALENGTH_INT, rawDataLength);
		if (FixUtils.isSet(rawData)) FixUtils.putFixTag( out, FixTags.RAWDATA_INT, rawData, 0, Utils.lastIndexTrim(rawData, (byte)0) );
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.EMAIL) + sep;

		try {
			// print all fields including the header

			if (FixUtils.isSet(applVerID)) s += "ApplVerID(1128)=" + new String(applVerID) + sep;
			if (FixUtils.isSet(cstmApplVerID)) s += "CstmApplVerID(1129)=" + new String(cstmApplVerID) + sep;
			if (FixUtils.isSet(applExtID)) s += "ApplExtID(1156)=" + String.valueOf(applExtID) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(secureDataLen)) s += "SecureDataLen(90)=" + String.valueOf(secureDataLen) + sep;
			if (FixUtils.isSet(secureData)) s += "SecureData(91)=" + new String(secureData) + sep;
			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			if (FixUtils.isSet(senderLocationID)) s += "SenderLocationID(142)=" + new String(senderLocationID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(targetLocationID)) s += "TargetLocationID(143)=" + new String(targetLocationID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(onBehalfOfLocationID)) s += "OnBehalfOfLocationID(144)=" + new String(onBehalfOfLocationID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;
			if (FixUtils.isSet(deliverToLocationID)) s += "DeliverToLocationID(145)=" + new String(deliverToLocationID) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(xmlDataLen)) s += "XmlDataLen(212)=" + String.valueOf(xmlDataLen) + sep;
			if (FixUtils.isSet(xmlData)) s += "XmlData(213)=" + new String(xmlData) + sep;
			if (FixUtils.isSet(messageEncoding)) s += "MessageEncoding(347)=" + new String(messageEncoding) + sep;
			if (FixUtils.isSet(lastMsgSeqNumProcessed)) s += "LastMsgSeqNumProcessed(369)=" + String.valueOf(lastMsgSeqNumProcessed) + sep;
			if (FixUtils.isSet(hopGrp.noHops)) s += hopGrp.toString();

			 s += "EmailThreadID(164)=" + new String(emailThreadID) + sep;
			 s += "EmailType(94)=" + String.valueOf(emailType) + sep;
			if (FixUtils.isSet(origTime)) s += "OrigTime(42)=" + new String(origTime) + sep;
			 s += "Subject(147)=" + new String(subject) + sep;
			if (FixUtils.isSet(encodedSubjectLen)) s += "EncodedSubjectLen(356)=" + String.valueOf(encodedSubjectLen) + sep;
			if (FixUtils.isSet(encodedSubject)) s += "EncodedSubject(357)=" + new String(encodedSubject) + sep;
			if (FixUtils.isSet(routingGrp.noRoutingIDs)) s += routingGrp.toString();
			if (FixUtils.isSet(instrmtGrp.noRelatedSym)) s += instrmtGrp.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(orderID)) s += "OrderID(37)=" + new String(orderID) + sep;
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(linesOfTextGrp.noLinesOfText)) s += linesOfTextGrp.toString();
			if (FixUtils.isSet(rawDataLength)) s += "RawDataLength(95)=" + String.valueOf(rawDataLength) + sep;
			if (FixUtils.isSet(rawData)) s += "RawData(96)=" + new String(rawData) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixEmail)) return false;

			FixEmail msg = (FixEmail) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( emailThreadID, msg.emailThreadID)) return false;

		if (!( emailType==msg.emailType)) return false;

		if (!Utils.equals( subject, msg.subject)) return false;

		if (!( encodedSubjectLen==msg.encodedSubjectLen)) return false;

		if (!Utils.equals( encodedSubject, msg.encodedSubject)) return false;

		if (!routingGrp.equals(msg.routingGrp)) return false;

		if (!instrmtGrp.equals(msg.instrmtGrp)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!linesOfTextGrp.equals(msg.linesOfTextGrp)) return false;

		if (!( rawDataLength==msg.rawDataLength)) return false;

		if (!Utils.equals( rawData, msg.rawData)) return false;

		return true;
	}
}
