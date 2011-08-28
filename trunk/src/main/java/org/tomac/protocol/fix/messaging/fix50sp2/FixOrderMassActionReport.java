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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixAffectedOrdGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNotAffectedOrdersGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTargetParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUnderlyingInstrument;

public class FixOrderMassActionReport extends FixMessage
{

	public byte[] clOrdID;
	public byte[] secondaryClOrdID;
	public byte[] massActionReportID;
	public long massActionType = 0;
	public long massActionScope = 0;
	public long massActionResponse = 0;
	public long massActionRejectReason = 0;
	public long totalAffectedOrders = 0;
	public FixAffectedOrdGrp affectedOrdGrp;
	public FixNotAffectedOrdersGrp notAffectedOrdersGrp;
	public byte[] marketID;
	public byte[] marketSegmentID;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public FixParties parties;
	public FixTargetParties targetParties;
	public FixInstrument instrument;
	public FixUnderlyingInstrument underlyingInstrument;
	public byte side = (byte)' ';
	public byte[] transactTime;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public FixOrderMassActionReport() {
		super();

		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		massActionReportID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		affectedOrdGrp = new FixAffectedOrdGrp();
		notAffectedOrdersGrp = new FixNotAffectedOrdersGrp();
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		parties = new FixParties();
		targetParties = new FixTargetParties();
		instrument = new FixInstrument();
		underlyingInstrument = new FixUnderlyingInstrument();
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

		msgType = MsgTypes.ORDERMASSACTIONREPORT_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( secondaryClOrdID, (byte)0 );
		Utils.fill( massActionReportID, (byte)0 );
		massActionType = Long.MAX_VALUE;		
		massActionScope = Long.MAX_VALUE;		
		massActionResponse = Long.MAX_VALUE;		
		massActionRejectReason = Long.MAX_VALUE;		
		totalAffectedOrders = Long.MAX_VALUE;		
		Utils.fill( marketID, (byte)0 );
		Utils.fill( marketSegmentID, (byte)0 );
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		side = Byte.MAX_VALUE;		
		Utils.fill( transactTime, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		affectedOrdGrp.clear();
		notAffectedOrdersGrp.clear();
		parties.clear();
		targetParties.clear();
		instrument.clear();
		underlyingInstrument.clear();
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

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, clOrdID);
				break;

			case FixTags.SECONDARYCLORDID_INT:
				secondaryClOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, secondaryClOrdID);
				break;

			case FixTags.MASSACTIONREPORTID_INT:
				massActionReportID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, massActionReportID);
				break;

			case FixTags.MASSACTIONTYPE_INT:
				massActionType = FixUtils.getTagIntValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				if (!MassActionType.isValid(massActionType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + massActionType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MASSACTIONSCOPE_INT:
				massActionScope = FixUtils.getTagIntValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				if (!MassActionScope.isValid(massActionScope) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + massActionScope + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MASSACTIONRESPONSE_INT:
				massActionResponse = FixUtils.getTagIntValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				if (!MassActionResponse.isValid(massActionResponse) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + massActionResponse + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MASSACTIONREJECTREASON_INT:
				massActionRejectReason = FixUtils.getTagIntValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				if (!MassActionRejectReason.isValid(massActionRejectReason) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + massActionRejectReason + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TOTALAFFECTEDORDERS_INT:
				totalAffectedOrders = FixUtils.getTagIntValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				break;

			case FixTags.NOAFFECTEDORDERS_INT:
				affectedOrdGrp.noAffectedOrders = FixUtils.getTagIntValue( MsgTypes.ORDERMASSACTIONREPORT ,FixTags.NOAFFECTEDORDERS_INT ,value );
				affectedOrdGrp.getAll(affectedOrdGrp.noAffectedOrders, value );
				break;

			case FixTags.NONOTAFFECTEDORDERS_INT:
				notAffectedOrdersGrp.noNotAffectedOrders = FixUtils.getTagIntValue( MsgTypes.ORDERMASSACTIONREPORT ,FixTags.NONOTAFFECTEDORDERS_INT ,value );
				notAffectedOrdersGrp.getAll(notAffectedOrdersGrp.noNotAffectedOrders, value );
				break;

			case FixTags.MARKETID_INT:
				marketID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, marketID);
				break;

			case FixTags.MARKETSEGMENTID_INT:
				marketSegmentID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, marketSegmentID);
				break;

			case FixTags.TRADINGSESSIONID_INT:
				tradingSessionID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, tradingSessionID);
				if (!TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionID + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRADINGSESSIONSUBID_INT:
				tradingSessionSubID = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, tradingSessionSubID);
				if (!TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionSubID + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( MsgTypes.ORDERMASSACTIONREPORT ,FixTags.NOPARTYIDS_INT ,value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.NOTARGETPARTYIDS_INT:
				targetParties.noTargetPartyIDs = FixUtils.getTagIntValue( MsgTypes.ORDERMASSACTIONREPORT ,FixTags.NOTARGETPARTYIDS_INT ,value );
				targetParties.getAll(targetParties.noTargetPartyIDs, value );
				break;

			case FixTags.SYMBOL_INT:
				instrument.getAll(FixTags.SYMBOL_INT, value );
				break;

			case FixTags.UNDERLYINGSYMBOL_INT:
				underlyingInstrument.getAll(FixTags.UNDERLYINGSYMBOL_INT, value );
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				if (!Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, transactTime);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, text);
				break;

			case FixTags.ENCODEDTEXTLEN_INT:
				encodedTextLen = FixUtils.getTagIntValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value );
				break;

			case FixTags.ENCODEDTEXT_INT:
				encodedText = FixUtils.getTagStringValue(MsgTypes.ORDERMASSACTIONREPORT ,id ,value, encodedText);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.ORDERMASSACTIONREPORT ,FixTags.CHECKSUM_INT, value );

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
		if (! FixUtils.isSet(massActionReportID) ) return FixTags.MASSACTIONREPORTID_INT;
		if (! FixUtils.isSet(massActionType) ) return FixTags.MASSACTIONTYPE_INT;
		if (! FixUtils.isSet(massActionScope) ) return FixTags.MASSACTIONSCOPE_INT;
		if (! FixUtils.isSet(massActionResponse) ) return FixTags.MASSACTIONRESPONSE_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.ORDERMASSACTIONREPORT);

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

		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(secondaryClOrdID)) FixUtils.putFixTag( out, FixTags.SECONDARYCLORDID_INT, secondaryClOrdID, 0, Utils.lastIndexTrim(secondaryClOrdID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MASSACTIONREPORTID_INT, massActionReportID, 0, Utils.lastIndexTrim(massActionReportID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MASSACTIONTYPE_INT, massActionType);
		FixUtils.putFixTag( out, FixTags.MASSACTIONSCOPE_INT, massActionScope);
		FixUtils.putFixTag( out, FixTags.MASSACTIONRESPONSE_INT, massActionResponse);
		if (FixUtils.isSet(massActionRejectReason)) FixUtils.putFixTag( out, FixTags.MASSACTIONREJECTREASON_INT, massActionRejectReason);
		if (FixUtils.isSet(totalAffectedOrders)) FixUtils.putFixTag( out, FixTags.TOTALAFFECTEDORDERS_INT, totalAffectedOrders);
		if (FixUtils.isSet(affectedOrdGrp.noAffectedOrders)) affectedOrdGrp.encode( out );
		if (FixUtils.isSet(notAffectedOrdersGrp.noNotAffectedOrders)) notAffectedOrdersGrp.encode( out );
		if (FixUtils.isSet(marketID)) FixUtils.putFixTag( out, FixTags.MARKETID_INT, marketID, 0, Utils.lastIndexTrim(marketID, (byte)0) );
		if (FixUtils.isSet(marketSegmentID)) FixUtils.putFixTag( out, FixTags.MARKETSEGMENTID_INT, marketSegmentID, 0, Utils.lastIndexTrim(marketSegmentID, (byte)0) );
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(targetParties.noTargetPartyIDs)) targetParties.encode( out );
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) underlyingInstrument.encode( out );
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(transactTime)) FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.ORDERMASSACTIONREPORT) + sep;

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

			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(secondaryClOrdID)) s += "SecondaryClOrdID(526)=" + new String(secondaryClOrdID) + sep;
			 s += "MassActionReportID(1369)=" + new String(massActionReportID) + sep;
			 s += "MassActionType(1373)=" + String.valueOf(massActionType) + sep;
			 s += "MassActionScope(1374)=" + String.valueOf(massActionScope) + sep;
			 s += "MassActionResponse(1375)=" + String.valueOf(massActionResponse) + sep;
			if (FixUtils.isSet(massActionRejectReason)) s += "MassActionRejectReason(1376)=" + String.valueOf(massActionRejectReason) + sep;
			if (FixUtils.isSet(totalAffectedOrders)) s += "TotalAffectedOrders(533)=" + String.valueOf(totalAffectedOrders) + sep;
			if (FixUtils.isSet(affectedOrdGrp.noAffectedOrders)) s += affectedOrdGrp.toString();
			if (FixUtils.isSet(notAffectedOrdersGrp.noNotAffectedOrders)) s += notAffectedOrdersGrp.toString();
			if (FixUtils.isSet(marketID)) s += "MarketID(1301)=" + new String(marketID) + sep;
			if (FixUtils.isSet(marketSegmentID)) s += "MarketSegmentID(1300)=" + new String(marketSegmentID) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(targetParties.noTargetPartyIDs)) s += targetParties.toString();
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) s += underlyingInstrument.toString();
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(transactTime)) s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderMassActionReport)) return false;

			FixOrderMassActionReport msg = (FixOrderMassActionReport) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( secondaryClOrdID, msg.secondaryClOrdID)) return false;

		if (!Utils.equals( massActionReportID, msg.massActionReportID)) return false;

		if (!( massActionType==msg.massActionType)) return false;

		if (!( massActionScope==msg.massActionScope)) return false;

		if (!( massActionResponse==msg.massActionResponse)) return false;

		if (!( massActionRejectReason==msg.massActionRejectReason)) return false;

		if (!( totalAffectedOrders==msg.totalAffectedOrders)) return false;

		if (!affectedOrdGrp.equals(msg.affectedOrdGrp)) return false;

		if (!notAffectedOrdersGrp.equals(msg.notAffectedOrdersGrp)) return false;

		if (!Utils.equals( marketID, msg.marketID)) return false;

		if (!Utils.equals( marketSegmentID, msg.marketSegmentID)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!targetParties.equals(msg.targetParties)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
