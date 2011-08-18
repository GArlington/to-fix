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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixExecCollGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTrdCollGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixFinancingDetails;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtCollGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixTrdRegTimestamps;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixMiscFeesGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSpreadOrBenchmarkCurveData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStipulations;

public class FixCollateralRequest extends FixMessage
{

	public byte[] collReqID;
	public long collAsgnReason = 0;
	public byte[] transactTime;
	public byte[] expireTime;
	public FixParties parties;
	public byte[] account;
	public long accountType = 0;
	public byte[] clOrdID;
	public byte[] orderID;
	public byte[] secondaryOrderID;
	public byte[] secondaryClOrdID;
	public FixExecCollGrp execCollGrp;
	public FixTrdCollGrp trdCollGrp;
	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public byte[] settlDate;
	public long quantity = 0;
	public long qtyType = 0;
	public byte[] currency;
	public FixInstrmtLegGrp instrmtLegGrp;
	public FixUndInstrmtCollGrp undInstrmtCollGrp;
	public long marginExcess = 0;
	public long totalNetValue = 0;
	public long cashOutstanding = 0;
	public FixTrdRegTimestamps trdRegTimestamps;
	public byte side = (byte)' ';
	public FixMiscFeesGrp miscFeesGrp;
	public long price = 0;
	public long priceType = 0;
	public long accruedInterestAmt = 0;
	public long endAccruedInterestAmt = 0;
	public long startCash = 0;
	public long endCash = 0;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixStipulations stipulations;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public byte[] settlSessID;
	public byte[] settlSessSubID;
	public byte[] clearingBusinessDate;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;

	public FixCollateralRequest() {
		super();

		collReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		parties = new FixParties();
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryOrderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		execCollGrp = new FixExecCollGrp();
		trdCollGrp = new FixTrdCollGrp();
		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		instrmtLegGrp = new FixInstrmtLegGrp();
		undInstrmtCollGrp = new FixUndInstrmtCollGrp();
		trdRegTimestamps = new FixTrdRegTimestamps();
		miscFeesGrp = new FixMiscFeesGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		stipulations = new FixStipulations();
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlSessID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		settlSessSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

		msgType = MsgTypes.COLLATERALREQUEST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( collReqID, (byte)0 );
		collAsgnReason = Long.MAX_VALUE;		
		Utils.fill( transactTime, (byte)0 );
		Utils.fill( expireTime, (byte)0 );
		Utils.fill( account, (byte)0 );
		accountType = Long.MAX_VALUE;		
		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( orderID, (byte)0 );
		Utils.fill( secondaryOrderID, (byte)0 );
		Utils.fill( secondaryClOrdID, (byte)0 );
		Utils.fill( settlDate, (byte)0 );
		quantity = Long.MAX_VALUE;		
		qtyType = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		marginExcess = Long.MAX_VALUE;		
		totalNetValue = Long.MAX_VALUE;		
		cashOutstanding = Long.MAX_VALUE;		
		side = Byte.MAX_VALUE;		
		price = Long.MAX_VALUE;		
		priceType = Long.MAX_VALUE;		
		accruedInterestAmt = Long.MAX_VALUE;		
		endAccruedInterestAmt = Long.MAX_VALUE;		
		startCash = Long.MAX_VALUE;		
		endCash = Long.MAX_VALUE;		
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		Utils.fill( settlSessID, (byte)0 );
		Utils.fill( settlSessSubID, (byte)0 );
		Utils.fill( clearingBusinessDate, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		parties.clear();
		execCollGrp.clear();
		trdCollGrp.clear();
		instrument.clear();
		financingDetails.clear();
		instrmtLegGrp.clear();
		undInstrmtCollGrp.clear();
		trdRegTimestamps.clear();
		miscFeesGrp.clear();
		spreadOrBenchmarkCurveData.clear();
		stipulations.clear();
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
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.COLLREQID_INT:
				collReqID = FixUtils.getTagStringValue(value, collReqID);
				break;

			case FixTags.COLLASGNREASON_INT:
				collAsgnReason = FixUtils.getTagIntValue( value );
				if (!CollAsgnReason.isValid(collAsgnReason) ) throw new FixSessionException(buf, "Invalid enumerated value(" + collAsgnReason + ") for tag: " + id );
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				break;

			case FixTags.EXPIRETIME_INT:
				expireTime = FixUtils.getTagStringValue(value, expireTime);
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.ACCOUNT_INT:
				account = FixUtils.getTagStringValue(value, account);
				break;

			case FixTags.ACCOUNTTYPE_INT:
				accountType = FixUtils.getTagIntValue( value );
				if (!AccountType.isValid(accountType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + accountType + ") for tag: " + id );
				break;

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(value, clOrdID);
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(value, orderID);
				break;

			case FixTags.SECONDARYORDERID_INT:
				secondaryOrderID = FixUtils.getTagStringValue(value, secondaryOrderID);
				break;

			case FixTags.SECONDARYCLORDID_INT:
				secondaryClOrdID = FixUtils.getTagStringValue(value, secondaryClOrdID);
				break;

			case FixTags.NOEXECS_INT:
				execCollGrp.noExecs = FixUtils.getTagIntValue( value );
				execCollGrp.getAll(execCollGrp.noExecs, value );
				break;

			case FixTags.NOTRADES_INT:
				trdCollGrp.noTrades = FixUtils.getTagIntValue( value );
				trdCollGrp.getAll(trdCollGrp.noTrades, value );
				break;

			case FixTags.SYMBOL_INT:
				instrument.getAll(FixTags.SYMBOL_INT, value );
				break;

			case FixTags.AGREEMENTDESC_INT:
				financingDetails.getAll(FixTags.AGREEMENTDESC_INT, value );
				break;

			case FixTags.SETTLDATE_INT:
				settlDate = FixUtils.getTagStringValue(value, settlDate);
				break;

			case FixTags.QUANTITY_INT:
				quantity = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.QTYTYPE_INT:
				qtyType = FixUtils.getTagIntValue( value );
				if (!QtyType.isValid(qtyType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + qtyType + ") for tag: " + id );
				break;

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(value, currency);
				break;

			case FixTags.NOLEGS_INT:
				instrmtLegGrp.noLegs = FixUtils.getTagIntValue( value );
				instrmtLegGrp.getAll(instrmtLegGrp.noLegs, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtCollGrp.noUnderlyings = FixUtils.getTagIntValue( value );
				undInstrmtCollGrp.getAll(undInstrmtCollGrp.noUnderlyings, value );
				break;

			case FixTags.MARGINEXCESS_INT:
				marginExcess = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.TOTALNETVALUE_INT:
				totalNetValue = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.CASHOUTSTANDING_INT:
				cashOutstanding = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.NOTRDREGTIMESTAMPS_INT:
				trdRegTimestamps.noTrdRegTimestamps = FixUtils.getTagIntValue( value );
				trdRegTimestamps.getAll(trdRegTimestamps.noTrdRegTimestamps, value );
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue( value );
				if (!Side.isValid(side) ) throw new FixSessionException(buf, "Invalid enumerated value(" + side + ") for tag: " + id );
				break;

			case FixTags.NOMISCFEES_INT:
				miscFeesGrp.noMiscFees = FixUtils.getTagIntValue( value );
				miscFeesGrp.getAll(miscFeesGrp.noMiscFees, value );
				break;

			case FixTags.PRICE_INT:
				price = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.PRICETYPE_INT:
				priceType = FixUtils.getTagIntValue( value );
				if (!PriceType.isValid(priceType) ) throw new FixSessionException(buf, "Invalid enumerated value(" + priceType + ") for tag: " + id );
				break;

			case FixTags.ACCRUEDINTERESTAMT_INT:
				accruedInterestAmt = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.ENDACCRUEDINTERESTAMT_INT:
				endAccruedInterestAmt = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.STARTCASH_INT:
				startCash = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.ENDCASH_INT:
				endCash = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.SPREAD_INT:
				spreadOrBenchmarkCurveData.getAll(FixTags.SPREAD_INT, value );
				break;

			case FixTags.NOSTIPULATIONS_INT:
				stipulations.noStipulations = FixUtils.getTagIntValue( value );
				stipulations.getAll(stipulations.noStipulations, value );
				break;

			case FixTags.TRADINGSESSIONID_INT:
				tradingSessionID = FixUtils.getTagStringValue(value, tradingSessionID);
				if (!TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionID + ") for tag: " + id );
				break;

			case FixTags.TRADINGSESSIONSUBID_INT:
				tradingSessionSubID = FixUtils.getTagStringValue(value, tradingSessionSubID);
				if (!TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + tradingSessionSubID + ") for tag: " + id );
				break;

			case FixTags.SETTLSESSID_INT:
				settlSessID = FixUtils.getTagStringValue(value, settlSessID);
				if (!SettlSessID.isValid(settlSessID) ) throw new FixSessionException(buf, "Invalid enumerated value(" + settlSessID + ") for tag: " + id );
				break;

			case FixTags.SETTLSESSSUBID_INT:
				settlSessSubID = FixUtils.getTagStringValue(value, settlSessSubID);
				break;

			case FixTags.CLEARINGBUSINESSDATE_INT:
				clearingBusinessDate = FixUtils.getTagStringValue(value, clearingBusinessDate);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(value, text);
				break;

			case FixTags.ENCODEDTEXTLEN_INT:
				encodedTextLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.ENCODEDTEXT_INT:
				encodedText = FixUtils.getTagStringValue(value, encodedText);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

				return;

			default:
				throw new FixSessionException(buf, "Unknown tag: " + id );

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
		if (! FixUtils.isSet(collReqID) ) return FixTags.COLLREQID_INT;
		if (! FixUtils.isSet(collAsgnReason) ) return FixTags.COLLASGNREASON_INT;
		if (! FixUtils.isSet(transactTime) ) return FixTags.TRANSACTTIME_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.COLLATERALREQUEST);

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

		FixUtils.putFixTag( out, FixTags.COLLREQID_INT, collReqID, 0, Utils.lastIndexTrim(collReqID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.COLLASGNREASON_INT, collAsgnReason);
		FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(expireTime)) FixUtils.putFixTag( out, FixTags.EXPIRETIME_INT, expireTime);
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(accountType)) FixUtils.putFixTag( out, FixTags.ACCOUNTTYPE_INT, accountType);
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(orderID)) FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		if (FixUtils.isSet(secondaryOrderID)) FixUtils.putFixTag( out, FixTags.SECONDARYORDERID_INT, secondaryOrderID, 0, Utils.lastIndexTrim(secondaryOrderID, (byte)0) );
		if (FixUtils.isSet(secondaryClOrdID)) FixUtils.putFixTag( out, FixTags.SECONDARYCLORDID_INT, secondaryClOrdID, 0, Utils.lastIndexTrim(secondaryClOrdID, (byte)0) );
		if (FixUtils.isSet(execCollGrp.noExecs)) execCollGrp.encode( out );
		if (FixUtils.isSet(trdCollGrp.noTrades)) trdCollGrp.encode( out );
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(financingDetails.agreementDesc)) financingDetails.encode( out );
		if (FixUtils.isSet(settlDate)) FixUtils.putFixTag( out, FixTags.SETTLDATE_INT, settlDate);
		if (FixUtils.isSet(quantity)) FixUtils.putFixFloatTag( out, FixTags.QUANTITY_INT, quantity);
		if (FixUtils.isSet(qtyType)) FixUtils.putFixTag( out, FixTags.QTYTYPE_INT, qtyType);
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(undInstrmtCollGrp.noUnderlyings)) undInstrmtCollGrp.encode( out );
		if (FixUtils.isSet(marginExcess)) FixUtils.putFixTag( out, FixTags.MARGINEXCESS_INT, marginExcess);
		if (FixUtils.isSet(totalNetValue)) FixUtils.putFixTag( out, FixTags.TOTALNETVALUE_INT, totalNetValue);
		if (FixUtils.isSet(cashOutstanding)) FixUtils.putFixTag( out, FixTags.CASHOUTSTANDING_INT, cashOutstanding);
		if (FixUtils.isSet(trdRegTimestamps.noTrdRegTimestamps)) trdRegTimestamps.encode( out );
		if (FixUtils.isSet(side)) FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		if (FixUtils.isSet(miscFeesGrp.noMiscFees)) miscFeesGrp.encode( out );
		if (FixUtils.isSet(price)) FixUtils.putFixFloatTag( out, FixTags.PRICE_INT, price);
		if (FixUtils.isSet(priceType)) FixUtils.putFixTag( out, FixTags.PRICETYPE_INT, priceType);
		if (FixUtils.isSet(accruedInterestAmt)) FixUtils.putFixTag( out, FixTags.ACCRUEDINTERESTAMT_INT, accruedInterestAmt);
		if (FixUtils.isSet(endAccruedInterestAmt)) FixUtils.putFixTag( out, FixTags.ENDACCRUEDINTERESTAMT_INT, endAccruedInterestAmt);
		if (FixUtils.isSet(startCash)) FixUtils.putFixTag( out, FixTags.STARTCASH_INT, startCash);
		if (FixUtils.isSet(endCash)) FixUtils.putFixTag( out, FixTags.ENDCASH_INT, endCash);
		if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) spreadOrBenchmarkCurveData.encode( out );
		if (FixUtils.isSet(stipulations.noStipulations)) stipulations.encode( out );
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(settlSessID)) FixUtils.putFixTag( out, FixTags.SETTLSESSID_INT, settlSessID, 0, Utils.lastIndexTrim(settlSessID, (byte)0) );
		if (FixUtils.isSet(settlSessSubID)) FixUtils.putFixTag( out, FixTags.SETTLSESSSUBID_INT, settlSessSubID, 0, Utils.lastIndexTrim(settlSessSubID, (byte)0) );
		if (FixUtils.isSet(clearingBusinessDate)) FixUtils.putFixTag( out, FixTags.CLEARINGBUSINESSDATE_INT, clearingBusinessDate);
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
		s += "MsgType(35)=" + new String(MsgTypes.COLLATERALREQUEST) + sep;

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

			 s += "CollReqID(894)=" + new String(collReqID) + sep;
			 s += "CollAsgnReason(895)=" + String.valueOf(collAsgnReason) + sep;
			 s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(expireTime)) s += "ExpireTime(126)=" + new String(expireTime) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(accountType)) s += "AccountType(581)=" + String.valueOf(accountType) + sep;
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(orderID)) s += "OrderID(37)=" + new String(orderID) + sep;
			if (FixUtils.isSet(secondaryOrderID)) s += "SecondaryOrderID(198)=" + new String(secondaryOrderID) + sep;
			if (FixUtils.isSet(secondaryClOrdID)) s += "SecondaryClOrdID(526)=" + new String(secondaryClOrdID) + sep;
			if (FixUtils.isSet(execCollGrp.noExecs)) s += execCollGrp.toString();
			if (FixUtils.isSet(trdCollGrp.noTrades)) s += trdCollGrp.toString();
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(financingDetails.agreementDesc)) s += financingDetails.toString();
			if (FixUtils.isSet(settlDate)) s += "SettlDate(64)=" + new String(settlDate) + sep;
			if (FixUtils.isSet(quantity)) s += "Quantity(53)=" + String.valueOf(quantity) + sep;
			if (FixUtils.isSet(qtyType)) s += "QtyType(854)=" + String.valueOf(qtyType) + sep;
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(undInstrmtCollGrp.noUnderlyings)) s += undInstrmtCollGrp.toString();
			if (FixUtils.isSet(marginExcess)) s += "MarginExcess(899)=" + String.valueOf(marginExcess) + sep;
			if (FixUtils.isSet(totalNetValue)) s += "TotalNetValue(900)=" + String.valueOf(totalNetValue) + sep;
			if (FixUtils.isSet(cashOutstanding)) s += "CashOutstanding(901)=" + String.valueOf(cashOutstanding) + sep;
			if (FixUtils.isSet(trdRegTimestamps.noTrdRegTimestamps)) s += trdRegTimestamps.toString();
			if (FixUtils.isSet(side)) s += "Side(54)=" + String.valueOf(side) + sep;
			if (FixUtils.isSet(miscFeesGrp.noMiscFees)) s += miscFeesGrp.toString();
			if (FixUtils.isSet(price)) s += "Price(44)=" + String.valueOf(price) + sep;
			if (FixUtils.isSet(priceType)) s += "PriceType(423)=" + String.valueOf(priceType) + sep;
			if (FixUtils.isSet(accruedInterestAmt)) s += "AccruedInterestAmt(159)=" + String.valueOf(accruedInterestAmt) + sep;
			if (FixUtils.isSet(endAccruedInterestAmt)) s += "EndAccruedInterestAmt(920)=" + String.valueOf(endAccruedInterestAmt) + sep;
			if (FixUtils.isSet(startCash)) s += "StartCash(921)=" + String.valueOf(startCash) + sep;
			if (FixUtils.isSet(endCash)) s += "EndCash(922)=" + String.valueOf(endCash) + sep;
			if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) s += spreadOrBenchmarkCurveData.toString();
			if (FixUtils.isSet(stipulations.noStipulations)) s += stipulations.toString();
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(settlSessID)) s += "SettlSessID(716)=" + new String(settlSessID) + sep;
			if (FixUtils.isSet(settlSessSubID)) s += "SettlSessSubID(717)=" + new String(settlSessSubID) + sep;
			if (FixUtils.isSet(clearingBusinessDate)) s += "ClearingBusinessDate(715)=" + new String(clearingBusinessDate) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCollateralRequest)) return false;

			FixCollateralRequest msg = (FixCollateralRequest) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( collReqID, msg.collReqID)) return false;

		if (!( collAsgnReason==msg.collAsgnReason)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( accountType==msg.accountType)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!Utils.equals( secondaryOrderID, msg.secondaryOrderID)) return false;

		if (!Utils.equals( secondaryClOrdID, msg.secondaryClOrdID)) return false;

		if (!execCollGrp.equals(msg.execCollGrp)) return false;

		if (!trdCollGrp.equals(msg.trdCollGrp)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!financingDetails.equals(msg.financingDetails)) return false;

		if (!( quantity==msg.quantity)) return false;

		if (!( qtyType==msg.qtyType)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!undInstrmtCollGrp.equals(msg.undInstrmtCollGrp)) return false;

		if (!( marginExcess==msg.marginExcess)) return false;

		if (!( totalNetValue==msg.totalNetValue)) return false;

		if (!( cashOutstanding==msg.cashOutstanding)) return false;

		if (!trdRegTimestamps.equals(msg.trdRegTimestamps)) return false;

		if (!( side==msg.side)) return false;

		if (!miscFeesGrp.equals(msg.miscFeesGrp)) return false;

		if (!( price==msg.price)) return false;

		if (!( priceType==msg.priceType)) return false;

		if (!( accruedInterestAmt==msg.accruedInterestAmt)) return false;

		if (!( endAccruedInterestAmt==msg.endAccruedInterestAmt)) return false;

		if (!( startCash==msg.startCash)) return false;

		if (!( endCash==msg.endCash)) return false;

		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;

		if (!stipulations.equals(msg.stipulations)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!Utils.equals( settlSessID, msg.settlSessID)) return false;

		if (!Utils.equals( settlSessSubID, msg.settlSessSubID)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		return true;
	}
}
