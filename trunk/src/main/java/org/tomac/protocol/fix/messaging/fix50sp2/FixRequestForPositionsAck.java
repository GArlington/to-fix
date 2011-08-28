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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;

public class FixRequestForPositionsAck extends FixMessage
{

	public byte[] posMaintRptID;
	public byte[] posReqID;
	public long totalNumPosReports = 0;
	public boolean unsolicitedIndicator = false;
	public long posReqResult = 0;
	public long posReqStatus = 0;
	public long posReqType = 0;
	public byte matchStatus = (byte)' ';
	public byte[] clearingBusinessDate;
	public byte subscriptionRequestType = (byte)' ';
	public byte[] settlSessID;
	public byte[] settlSessSubID;
	public byte[] settlCurrency;
	public FixParties parties;
	public byte[] account;
	public long acctIDSource = 0;
	public long accountType = 0;
	public FixInstrument instrument;
	public byte[] currency;
	public FixInstrmtLegGrp instrmtLegGrp;
	public FixUndInstrmtGrp undInstrmtGrp;
	public long responseTransportType = 0;
	public byte[] responseDestination;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public FixRequestForPositionsAck() {
		super();

		posMaintRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		posReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlCurrency = new byte[FixUtils.CURRENCY_LENGTH];
		parties = new FixParties();
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		instrument = new FixInstrument();
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		instrmtLegGrp = new FixInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp();
		responseDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

		msgType = MsgTypes.REQUESTFORPOSITIONSACK_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( posMaintRptID, (byte)0 );
		Utils.fill( posReqID, (byte)0 );
		totalNumPosReports = Long.MAX_VALUE;		
		unsolicitedIndicator = false;		
		posReqResult = Long.MAX_VALUE;		
		posReqStatus = Long.MAX_VALUE;		
		posReqType = Long.MAX_VALUE;		
		matchStatus = Byte.MAX_VALUE;		
		Utils.fill( clearingBusinessDate, (byte)0 );
		subscriptionRequestType = Byte.MAX_VALUE;		
		Utils.fill( settlSessID, (byte)0 );
		Utils.fill( settlSessSubID, (byte)0 );
		Utils.fill( settlCurrency, (byte)0 );
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
		accountType = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		responseTransportType = Long.MAX_VALUE;		
		Utils.fill( responseDestination, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		parties.clear();
		instrument.clear();
		instrmtLegGrp.clear();
		undInstrmtGrp.clear();
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

			case FixTags.POSMAINTRPTID_INT:
				posMaintRptID = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, posMaintRptID);
				break;

			case FixTags.POSREQID_INT:
				posReqID = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, posReqID);
				break;

			case FixTags.TOTALNUMPOSREPORTS_INT:
				totalNumPosReports = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				break;

			case FixTags.UNSOLICITEDINDICATOR_INT:
				unsolicitedIndicator = FixUtils.getTagBooleanValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!UnsolicitedIndicator.isValid(unsolicitedIndicator) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + unsolicitedIndicator + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.POSREQRESULT_INT:
				posReqResult = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!PosReqResult.isValid(posReqResult) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + posReqResult + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.POSREQSTATUS_INT:
				posReqStatus = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!PosReqStatus.isValid(posReqStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + posReqStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.POSREQTYPE_INT:
				posReqType = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!PosReqType.isValid(posReqType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + posReqType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MATCHSTATUS_INT:
				matchStatus = FixUtils.getTagCharValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!MatchStatus.isValid(matchStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + matchStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.CLEARINGBUSINESSDATE_INT:
				clearingBusinessDate = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, clearingBusinessDate);
				break;

			case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:
				subscriptionRequestType = FixUtils.getTagCharValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!SubscriptionRequestType.isValid(subscriptionRequestType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + subscriptionRequestType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SETTLSESSID_INT:
				settlSessID = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, settlSessID);
				if (!SettlSessID.isValid(settlSessID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + settlSessID + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SETTLSESSSUBID_INT:
				settlSessSubID = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, settlSessSubID);
				break;

			case FixTags.SETTLCURRENCY_INT:
				settlCurrency = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, settlCurrency);
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( MsgTypes.REQUESTFORPOSITIONSACK ,FixTags.NOPARTYIDS_INT ,value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.ACCOUNT_INT:
				account = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, account);
				break;

			case FixTags.ACCTIDSOURCE_INT:
				acctIDSource = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!AcctIDSource.isValid(acctIDSource) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + acctIDSource + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.ACCOUNTTYPE_INT:
				accountType = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!AccountType.isValid(accountType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + accountType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SYMBOL_INT:
				instrument.getAll(FixTags.SYMBOL_INT, value );
				break;

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, currency);
				break;

			case FixTags.NOLEGS_INT:
				instrmtLegGrp.noLegs = FixUtils.getTagIntValue( MsgTypes.REQUESTFORPOSITIONSACK ,FixTags.NOLEGS_INT ,value );
				instrmtLegGrp.getAll(instrmtLegGrp.noLegs, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtGrp.noUnderlyings = FixUtils.getTagIntValue( MsgTypes.REQUESTFORPOSITIONSACK ,FixTags.NOUNDERLYINGS_INT ,value );
				undInstrmtGrp.getAll(undInstrmtGrp.noUnderlyings, value );
				break;

			case FixTags.RESPONSETRANSPORTTYPE_INT:
				responseTransportType = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				if (!ResponseTransportType.isValid(responseTransportType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + responseTransportType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.RESPONSEDESTINATION_INT:
				responseDestination = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, responseDestination);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, text);
				break;

			case FixTags.ENCODEDTEXTLEN_INT:
				encodedTextLen = FixUtils.getTagIntValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value );
				break;

			case FixTags.ENCODEDTEXT_INT:
				encodedText = FixUtils.getTagStringValue(MsgTypes.REQUESTFORPOSITIONSACK ,id ,value, encodedText);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.REQUESTFORPOSITIONSACK ,FixTags.CHECKSUM_INT, value );

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
		if (! FixUtils.isSet(posMaintRptID) ) return FixTags.POSMAINTRPTID_INT;
		if (! FixUtils.isSet(posReqResult) ) return FixTags.POSREQRESULT_INT;
		if (! FixUtils.isSet(posReqStatus) ) return FixTags.POSREQSTATUS_INT;
		if (! parties.isSet() ) return FixTags.NOPARTYIDS_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.REQUESTFORPOSITIONSACK);

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

		FixUtils.putFixTag( out, FixTags.POSMAINTRPTID_INT, posMaintRptID, 0, Utils.lastIndexTrim(posMaintRptID, (byte)0) );
		if (FixUtils.isSet(posReqID)) FixUtils.putFixTag( out, FixTags.POSREQID_INT, posReqID, 0, Utils.lastIndexTrim(posReqID, (byte)0) );
		if (FixUtils.isSet(totalNumPosReports)) FixUtils.putFixTag( out, FixTags.TOTALNUMPOSREPORTS_INT, totalNumPosReports);
		if (FixUtils.isSet(unsolicitedIndicator)) FixUtils.putFixTag( out, FixTags.UNSOLICITEDINDICATOR_INT, unsolicitedIndicator?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.POSREQRESULT_INT, posReqResult);
		FixUtils.putFixTag( out, FixTags.POSREQSTATUS_INT, posReqStatus);
		if (FixUtils.isSet(posReqType)) FixUtils.putFixTag( out, FixTags.POSREQTYPE_INT, posReqType);
		if (FixUtils.isSet(matchStatus)) FixUtils.putFixTag( out, FixTags.MATCHSTATUS_INT, matchStatus );
		if (FixUtils.isSet(clearingBusinessDate)) FixUtils.putFixTag( out, FixTags.CLEARINGBUSINESSDATE_INT, clearingBusinessDate);
		if (FixUtils.isSet(subscriptionRequestType)) FixUtils.putFixTag( out, FixTags.SUBSCRIPTIONREQUESTTYPE_INT, subscriptionRequestType );
		if (FixUtils.isSet(settlSessID)) FixUtils.putFixTag( out, FixTags.SETTLSESSID_INT, settlSessID, 0, Utils.lastIndexTrim(settlSessID, (byte)0) );
		if (FixUtils.isSet(settlSessSubID)) FixUtils.putFixTag( out, FixTags.SETTLSESSSUBID_INT, settlSessSubID, 0, Utils.lastIndexTrim(settlSessSubID, (byte)0) );
		if (FixUtils.isSet(settlCurrency)) FixUtils.putFixTag( out, FixTags.SETTLCURRENCY_INT, settlCurrency, 0, Utils.lastIndexTrim(settlCurrency, (byte)0) );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
		if (FixUtils.isSet(accountType)) FixUtils.putFixTag( out, FixTags.ACCOUNTTYPE_INT, accountType);
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(responseTransportType)) FixUtils.putFixTag( out, FixTags.RESPONSETRANSPORTTYPE_INT, responseTransportType);
		if (FixUtils.isSet(responseDestination)) FixUtils.putFixTag( out, FixTags.RESPONSEDESTINATION_INT, responseDestination, 0, Utils.lastIndexTrim(responseDestination, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.REQUESTFORPOSITIONSACK) + sep;

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

			 s += "PosMaintRptID(721)=" + new String(posMaintRptID) + sep;
			if (FixUtils.isSet(posReqID)) s += "PosReqID(710)=" + new String(posReqID) + sep;
			if (FixUtils.isSet(totalNumPosReports)) s += "TotalNumPosReports(727)=" + String.valueOf(totalNumPosReports) + sep;
			if (FixUtils.isSet(unsolicitedIndicator)) s += "UnsolicitedIndicator(325)=" + String.valueOf(unsolicitedIndicator) + sep;
			 s += "PosReqResult(728)=" + String.valueOf(posReqResult) + sep;
			 s += "PosReqStatus(729)=" + String.valueOf(posReqStatus) + sep;
			if (FixUtils.isSet(posReqType)) s += "PosReqType(724)=" + String.valueOf(posReqType) + sep;
			if (FixUtils.isSet(matchStatus)) s += "MatchStatus(573)=" + String.valueOf(matchStatus) + sep;
			if (FixUtils.isSet(clearingBusinessDate)) s += "ClearingBusinessDate(715)=" + new String(clearingBusinessDate) + sep;
			if (FixUtils.isSet(subscriptionRequestType)) s += "SubscriptionRequestType(263)=" + String.valueOf(subscriptionRequestType) + sep;
			if (FixUtils.isSet(settlSessID)) s += "SettlSessID(716)=" + new String(settlSessID) + sep;
			if (FixUtils.isSet(settlSessSubID)) s += "SettlSessSubID(717)=" + new String(settlSessSubID) + sep;
			if (FixUtils.isSet(settlCurrency)) s += "SettlCurrency(120)=" + new String(settlCurrency) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
			if (FixUtils.isSet(accountType)) s += "AccountType(581)=" + String.valueOf(accountType) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(responseTransportType)) s += "ResponseTransportType(725)=" + String.valueOf(responseTransportType) + sep;
			if (FixUtils.isSet(responseDestination)) s += "ResponseDestination(726)=" + new String(responseDestination) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRequestForPositionsAck)) return false;

			FixRequestForPositionsAck msg = (FixRequestForPositionsAck) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( posMaintRptID, msg.posMaintRptID)) return false;

		if (!Utils.equals( posReqID, msg.posReqID)) return false;

		if (!( totalNumPosReports==msg.totalNumPosReports)) return false;

		if (!( unsolicitedIndicator==msg.unsolicitedIndicator)) return false;

		if (!( posReqResult==msg.posReqResult)) return false;

		if (!( posReqStatus==msg.posReqStatus)) return false;

		if (!( posReqType==msg.posReqType)) return false;

		if (!( matchStatus==msg.matchStatus)) return false;

		if (!( subscriptionRequestType==msg.subscriptionRequestType)) return false;

		if (!Utils.equals( settlSessID, msg.settlSessID)) return false;

		if (!Utils.equals( settlSessSubID, msg.settlSessSubID)) return false;

		if (!Utils.equals( settlCurrency, msg.settlCurrency)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		if (!( accountType==msg.accountType)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!( responseTransportType==msg.responseTransportType)) return false;

		if (!Utils.equals( responseDestination, msg.responseDestination)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
