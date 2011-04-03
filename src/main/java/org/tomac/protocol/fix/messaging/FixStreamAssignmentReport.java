package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixStreamAssignmentReport extends FixInMessage {
	private short hasStreamAsgnRptID;
	byte[] streamAsgnRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStreamAsgnReqType;
	long streamAsgnReqType = 0;		
	private short hasStreamAsgnReqID;
	byte[] streamAsgnReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixStrmAsgnRptGrp[] strmAsgnRptGrp;
	
	public FixStreamAssignmentReport() {
		super(FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORT);


		hasStreamAsgnRptID = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnRptID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStreamAsgnReqType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStreamAsgnReqID = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		strmAsgnRptGrp = new FixStrmAsgnRptGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strmAsgnRptGrp[i] = new FixStrmAsgnRptGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.STREAMASGNRPTID_INT:		
            		hasStreamAsgnRptID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STREAMASGNREQTYPE_INT:		
            		hasStreamAsgnReqType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.STREAMASGNREQID_INT:		
            		hasStreamAsgnReqID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixMessage.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOASGNREQS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !strmAsgnRptGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return;
        					}
        					count++;
        					repeatingGroupTag = strmAsgnRptGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //Ugha
					}

			}

        		if (err.hasError()) return;

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; 

		if (!hasStreamAsgnRptID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag StreamAsgnRptID missing", FixTags.STREAMASGNRPTID_INT, FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORT);
			return false;
		}
		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; 

		return true;
	}
	@Override		
	public void getAll() {		
		/* not needed, just for the inet dudes recognition */		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		// if this is the standardHeader for an out-bound message wee need to set default tags
		if (buf == null) {
			super.standardHeader.setBeginString(FixMessageInfo.BEGINSTRING_VALUE);
		}

		super.standardHeader.encode(out);
		if (hasStreamAsgnRptID()) {		
			out.put(FixTags.STREAMASGNRPTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,streamAsgnRptID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStreamAsgnReqType()) {		
			out.put(FixTags.STREAMASGNREQTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)streamAsgnReqType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStreamAsgnReqID()) {		
			out.put(FixTags.STREAMASGNREQID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,streamAsgnReqID); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(strmAsgnRptGrp)>0) {
			out.put(FixTags.NOASGNREQS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(strmAsgnRptGrp));

			out.put(FixUtils.SOH);

		}
		for (FixStrmAsgnRptGrp fixStrmAsgnRptGrp : strmAsgnRptGrp) if (fixStrmAsgnRptGrp.hasGroup()) fixStrmAsgnRptGrp.encode(out);
		
		// set body length

		int endPos = out.position();

		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);

		out.position(startPos + FixUtils.FIX_HEADER);

		if (super.standardHeader.getBodyLength()>999) {
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else if (super.standardHeader.getBodyLength()>99) {
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else {
			FixUtils.put(out, 0);
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		}
		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);
		super.standardTrailer.setCheckSum(tmpCheckSum);

		out.position(endPos);

		super.standardTrailer.encode(out);
		out.limit(out.position());
		out.flip();

		return (int) super.standardHeader.getBodyLength();

	}			
			
			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		int startPos = out.position();		
					
		super.standardHeader.encode(out);		
		
		if (hasStreamAsgnRptID()) {		
			FixUtils.put(out,streamAsgnRptID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStreamAsgnReqType()) {		
			FixUtils.put(out, (long)streamAsgnReqType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStreamAsgnReqID()) {		
			FixUtils.put(out,streamAsgnReqID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackStreamAsgnRptID() {		
		getStreamAsgnRptID();		
	}		
			
	public byte[] getStreamAsgnRptID() { 		
		if ( hasStreamAsgnRptID()) {		
			if (hasStreamAsgnRptID == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnRptID; 		
			} else {

				buf.position(hasStreamAsgnRptID);

			FixMessage.getTagStringValue(buf, streamAsgnRptID, 0, streamAsgnRptID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasStreamAsgnRptID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return streamAsgnRptID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStreamAsgnRptID() { return hasStreamAsgnRptID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStreamAsgnRptID(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnRptID()) FixUtils.fillSpace(streamAsgnRptID);		
		FixUtils.copy(streamAsgnRptID, src); 		
		hasStreamAsgnRptID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnRptID(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnRptID()) FixUtils.fillSpace(streamAsgnRptID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(streamAsgnRptID, src); 		
		hasStreamAsgnRptID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStreamAsgnReqType() {		
		getStreamAsgnReqType();		
	}		
			
	public long getStreamAsgnReqType() { 		
		if ( hasStreamAsgnReqType()) {		
			if (hasStreamAsgnReqType == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnReqType; 		
			} else {

				buf.position(hasStreamAsgnReqType);

			streamAsgnReqType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStreamAsgnReqType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return streamAsgnReqType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStreamAsgnReqType() { return hasStreamAsgnReqType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStreamAsgnReqType(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnReqType()) streamAsgnReqType = FixUtils.TAG_HAS_NO_VALUE;		
		streamAsgnReqType = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnReqType(long src) {		
		streamAsgnReqType = src;
		hasStreamAsgnReqType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnReqType(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnReqType()) streamAsgnReqType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		streamAsgnReqType = FixUtils.longValueOf(src, 0, src.length);
		hasStreamAsgnReqType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStreamAsgnReqID() {		
		getStreamAsgnReqID();		
	}		
			
	public byte[] getStreamAsgnReqID() { 		
		if ( hasStreamAsgnReqID()) {		
			if (hasStreamAsgnReqID == FixUtils.TAG_HAS_VALUE) {		
				return streamAsgnReqID; 		
			} else {

				buf.position(hasStreamAsgnReqID);

			FixMessage.getTagStringValue(buf, streamAsgnReqID, 0, streamAsgnReqID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasStreamAsgnReqID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return streamAsgnReqID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStreamAsgnReqID() { return hasStreamAsgnReqID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStreamAsgnReqID(byte[] src) {		
		if (src == null ) return;
		if (hasStreamAsgnReqID()) FixUtils.fillSpace(streamAsgnReqID);		
		FixUtils.copy(streamAsgnReqID, src); 		
		hasStreamAsgnReqID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStreamAsgnReqID(String str) {		
		if (str == null ) return;
		if (hasStreamAsgnReqID()) FixUtils.fillSpace(streamAsgnReqID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(streamAsgnReqID, src); 		
		hasStreamAsgnReqID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		try {
					if (standardHeader.hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(standardHeader.getBeginString()) ) + "\n" ; 
		if (standardHeader.hasBodyLength()) s += "BodyLength(9)= " + standardHeader.getBodyLength() + "\n" ; 
		if (standardHeader.hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(standardHeader.getMsgType()) ) + "\n" ; 
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasSecureDataLen()) s += "SecureDataLen(90)= " + standardHeader.getSecureDataLen() + "\n" ; 
		if (standardHeader.hasSecureData()) s += "SecureData(91)= " + new String( FixUtils.trim(standardHeader.getSecureData()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSenderLocationID()) s += "SenderLocationID(142)= " + new String( FixUtils.trim(standardHeader.getSenderLocationID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasTargetLocationID()) s += "TargetLocationID(143)= " + new String( FixUtils.trim(standardHeader.getTargetLocationID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfLocationID()) s += "OnBehalfOfLocationID(144)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfLocationID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToLocationID()) s += "DeliverToLocationID(145)= " + new String( FixUtils.trim(standardHeader.getDeliverToLocationID()) ) + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasXmlDataLen()) s += "XmlDataLen(212)= " + standardHeader.getXmlDataLen() + "\n" ; 
		if (standardHeader.hasXmlData()) s += "XmlData(213)= " + new String( FixUtils.trim(standardHeader.getXmlData()) ) + "\n" ; 
		if (standardHeader.hasMessageEncoding()) s += "MessageEncoding(347)= " + new String( FixUtils.trim(standardHeader.getMessageEncoding()) ) + "\n" ; 
		if (standardHeader.hasLastMsgSeqNumProcessed()) s += "LastMsgSeqNumProcessed(369)= " + standardHeader.getLastMsgSeqNumProcessed() + "\n" ; 

					if (hasStreamAsgnRptID()) s += "StreamAsgnRptID(1501)= " + new String( FixUtils.trim(getStreamAsgnRptID()) ) + "\n" ; 
		if (hasStreamAsgnReqType()) s += "StreamAsgnReqType(1498)= " + getStreamAsgnReqType() + "\n" ; 
		if (hasStreamAsgnReqID()) s += "StreamAsgnReqID(1497)= " + new String( FixUtils.trim(getStreamAsgnReqID()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStreamAssignmentReport)) return false;

		FixStreamAssignmentReport msg = (FixStreamAssignmentReport) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasStreamAsgnRptID() && !msg.hasStreamAsgnRptID()) || (!hasStreamAsgnRptID() && msg.hasStreamAsgnRptID())) return false;
		if (!(!hasStreamAsgnRptID() && !msg.hasStreamAsgnRptID()) && !FixUtils.equals(getStreamAsgnRptID(), msg.getStreamAsgnRptID())) return false;
		if ((hasStreamAsgnReqType() && !msg.hasStreamAsgnReqType()) || (!hasStreamAsgnReqType() && msg.hasStreamAsgnReqType())) return false;
		if (!(!hasStreamAsgnReqType() && !msg.hasStreamAsgnReqType()) && !(getStreamAsgnReqType()==msg.getStreamAsgnReqType())) return false;
		if ((hasStreamAsgnReqID() && !msg.hasStreamAsgnReqID()) || (!hasStreamAsgnReqID() && msg.hasStreamAsgnReqID())) return false;
		if (!(!hasStreamAsgnReqID() && !msg.hasStreamAsgnReqID()) && !FixUtils.equals(getStreamAsgnReqID(), msg.getStreamAsgnReqID())) return false;
		return true;
	}
	@Override
	public FixStreamAssignmentReport clone () {
		FixStreamAssignmentReport out = new FixStreamAssignmentReport();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixStreamAssignmentReport clone ( FixStreamAssignmentReport out ) {
		if ( hasStreamAsgnRptID())
			out.setStreamAsgnRptID(getStreamAsgnRptID());
		if ( hasStreamAsgnReqType())
			out.setStreamAsgnReqType(getStreamAsgnReqType());
		if ( hasStreamAsgnReqID())
			out.setStreamAsgnReqID(getStreamAsgnReqID());
		int count = 0;
		count = 0;
		for (FixStrmAsgnRptGrp fixStrmAsgnRptGrp : strmAsgnRptGrp) {
			if (!fixStrmAsgnRptGrp.hasGroup()) continue;
			out.strmAsgnRptGrp[count] = fixStrmAsgnRptGrp.clone( out.strmAsgnRptGrp[count] );
			count++;
		}
		return out;
	}

}