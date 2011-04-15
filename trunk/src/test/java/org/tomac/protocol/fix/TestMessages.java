package org.tomac.protocol.fix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.tomac.protocol.fix.messaging.FixExecutionReport;
import org.tomac.protocol.fix.messaging.FixIOI;
import org.tomac.protocol.fix.messaging.FixLogon;
import org.tomac.protocol.fix.messaging.FixMarketDataSnapshotFullRefresh;
import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixMessageListenerImpl;
import org.tomac.protocol.fix.messaging.FixMessageParser;
import org.tomac.protocol.fix.messaging.FixMessagePool;
import org.tomac.protocol.fix.messaging.FixNewOrderSingle;
import org.tomac.protocol.fix.messaging.FixNews;

public class TestMessages {
	TestFixMessageListener listener = new TestFixMessageListener();
	FixValidationError err = new FixValidationError();
	FixMessageParser parser;
	ByteBuffer out = ByteBuffer.allocate(1024);
	
	@Before
	public void setUp() {
		parser = new FixMessageParser();
		FixUtils.validateChecksum = false;
		FixUtils.validateSendingTime = false;
		FixUtils.validateSession = false;
	}

	@After
	public void tearDown() {
		out.clear();
		err.clear();
	}
	
	@Ignore
    @Test
    public void testRepeatingField() throws Exception {
        String data = "8=FIXT.1.1\0019=65\00135=D\00134=2\00149=TW\00156=ISLD\00111=ID\00121=1\00140=1\00154=1\00140=2\00138=200\00155=INTC\00110=160\001";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf, err, listener);
        assertTrue(err.hasError());
        assertEquals(52, err.refTagID);
    }

    @Test
    public void testTrailerFieldOrdering() throws Exception {
        final FixNewOrderSingle order = createNewOrderSingle();

        order.standardTrailer.setSignature("FOO");
        order.standardTrailer.setSignatureLength(3);

        order.encode(out);
        assertTrue(new String(out.array()).contains("93=3\00189=FOO\001"));
    }

    private FixNewOrderSingle createNewOrderSingle() {
    	FixNewOrderSingle msg = FixMessagePool.pool.getFixNewOrderSingle();
    	msg.setClOrdID("CLIENT".getBytes());
    	msg.setHandlInst(FixMessageInfo.HandlInst.AUTOMATED_EXECUTION_ORDER_PRIVATE_NO_BROKER_INTERVENTION);
    	msg.instrument.setSymbol("ORCL");
    	msg.setSide(FixMessageInfo.Side.BUY);
    	msg.setTransactTime(FixUtils.utcTimeOnlyConverter.convert(new Date(0)));
    	msg.setOrdType(FixMessageInfo.OrdType.LIMIT);
    	return msg;
    }

    @Test
    public void testHeaderGroupParsing() throws Exception {
        ByteBuffer buf = ByteBuffer.wrap("8=FIX.4.2\0019=40\00135=A\001627=2\001628=FOO\001628=BAR\00198=0\001384=2\001372=D\001385=R\001372=8\001385=S\00110=228\001".getBytes());
    	parser.parse(buf, err, new FixMessageListenerImpl() {
    		@Override
    		public void onFixLogon(FixLogon msg) {
    	        assertEquals("FOO".getBytes(), msg.standardHeader.hopGrp[0].getHopCompID());
    	        assertEquals("BAR".getBytes(), msg.standardHeader.hopGrp[1].getHopCompID());
    		}
    	});
    }
    
    private FixExecutionReport createExecutionReport() {
    	FixExecutionReport msg = FixMessagePool.pool.getFixExecutionReport();
    	msg.setOrderID("ORDER".getBytes());
    	msg.setExecID("EXEC".getBytes());
    	msg.setSide(FixMessageInfo.Side.BUY);
    	msg.setExecType(FixMessageInfo.ExecType.TRADE_PARTIAL_FILL_OR_FILL);
    	msg.setOrdStatus(FixMessageInfo.OrdStatus.FILLED);
    	msg.setLeavesQty(100);
    	msg.setCumQty(100);
    	msg.setAvgPx(50);
    	return msg;
    }

    @Ignore // TODO encoded not supported yet..
    @Test
    public void testEmbeddedMessage() throws Exception {
        final FixNewOrderSingle order = createNewOrderSingle();
        final FixExecutionReport report = createExecutionReport();
        
        report.setEncodedTextLen(order.toString().length());
        report.setEncodedText(order.toString());

        report.encode(out);
        
    	parser.parse(out, err, new FixMessageListenerImpl() {
    		@Override
    		public void onFixExecutionReport(FixExecutionReport msg) {
    	        assertEquals(order.toString(), msg.getEncodedText());
    		}
    	});
    }

    @Test
    public void testParsing() throws Exception {
        ByteBuffer buf = ByteBuffer.wrap("8=FIX.4.2\0019=40\00135=A\00198=0\001384=2\001372=D\001385=R\001372=8\001385=S\00110=96\001".getBytes());
    	parser.parse(buf, err, new FixMessageListenerImpl() {
    		@Override
    		public void onFixLogon(FixLogon msg) {
    	        assertEquals("FIX.4.2".getBytes(), msg.standardHeader.getBeginString());
    	        assertEquals(40, msg.standardHeader.getBodyLength());
    	        assertEquals("A".getBytes(), msg.standardHeader.getMsgType());
    	        assertEquals(0L, msg.getEncryptMethod());
    	        assertEquals("96".getBytes(), msg.standardTrailer.getCheckSum());
    	        assertTrue(msg.msgTypeGrp[0].hasGroup());
    	        assertEquals("D".getBytes(), msg.msgTypeGrp[0].getRefMsgType());
    	        assertEquals("R".getBytes(), msg.msgTypeGrp[0].getMsgDirection());
    	        assertTrue(msg.msgTypeGrp[1].hasGroup());
    	        assertEquals("8".getBytes(), msg.msgTypeGrp[1].getRefMsgType());
    	        assertEquals("S".getBytes(), msg.msgTypeGrp[1].getMsgDirection());
    		}
    	});

    }

    @Test
    public void testParsing2() throws Exception {
        // checksum is not verified in these tests
        String data = "8=FIX.4.2\0019=76\001";
        data += "35=6\001";
        data += "23=IDENTIFIER\001";
        data += "28=N\001";
        data += "55=MSFT\001";
        data += "54=1\001";
        data += "711=2\001";
        data += "311=DELL\001";
        data += "318=USD\001";
        data += "311=IBM\001";
        data += "318=CAD\001";
        data += "10=037\001";

        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf, err, new FixMessageListenerImpl() {
    		@Override
    		public void onFixIOI(FixIOI msg) {
    	        assertEquals("FIX.4.2".getBytes(), msg.standardHeader.getBeginString());
    	        assertEquals(76L, msg.standardHeader.getBodyLength());
    	        assertEquals(FixMessageInfo.MsgType.IOI, msg.standardHeader.getMsgType());
    	        assertEquals("IDENTIFIER".getBytes(), msg.getIOIID());
    	        assertEquals("96".getBytes(), msg.standardTrailer.getCheckSum());
    	        assertTrue(msg.undInstrmtGrp[0].hasGroup());
    	        assertEquals("DELL".getBytes(), msg.undInstrmtGrp[0].underlyingInstrument.getUnderlyingSymbol());
    	        assertEquals("USD".getBytes(), msg.undInstrmtGrp[0].underlyingInstrument.getUnderlyingCurrency());
    	        assertTrue(msg.undInstrmtGrp[1].hasGroup());
    	        assertEquals("IBM".getBytes(), msg.undInstrmtGrp[1].underlyingInstrument.getUnderlyingSymbol());
    	        assertEquals("CAD".getBytes(), msg.undInstrmtGrp[1].underlyingInstrument.getUnderlyingCurrency());
    		}
    	});
    }

    @Test
    public void testParseEmptyString() throws Exception {
        final String data = "";

        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf, err, new FixMessageListenerImpl() {
    		@Override
    		public void onUnknownMessageType(ByteBuffer msg, int msgType) {
    	        assertEquals(-1, msgType);
    		}
    	});
    }

    @Ignore
    @Test
    public void testValidation() throws Exception {
        final String data = "8=FIXT.1.19=30935=849=ASX56=CL1_FIX4434=452=20060324-01:05:58"
                + "17=X-B-WOW-1494E9A0:58BD3F9D-1109150=D39=011=18427138=200198=1494E9A0:58BD3F9D"
                + "526=432437=B-WOW-1494E9A0:58BD3F9D55=WOW54=1151=20014=040=244=1559=16=0"
                + "453=3448=AAA35791447=D452=3448=8447=D452=4448=FIX11447=D452=36"
                + "60=20060320-03:34:2910=169";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixExecutionReport msg = new FixExecutionReport();
        msg.setBuffer(buf, err);
        assertFalse(err.toString(), err.hasError());
    }

    @Ignore
    @Test 
    public void testValidationWithHops() throws Exception {
        String data = "8=FIXT.1.19=30935=849=ASX56=CL1_FIX4434=452=20060324-01:05:58"
                + "17=X-B-WOW-1494E9A0:58BD3F9D-1109150=D39=011=18427138=200198=1494E9A0:58BD3F9D"
                + "526=432437=B-WOW-1494E9A0:58BD3F9D55=WOW54=1151=20014=040=244=1559=16=0"
                + "453=3448=AAA35791447=D452=3448=8447=D452=4448=FIX11447=D452=36"
                + "60=20060320-03:34:2910=169";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixExecutionReport msg = new FixExecutionReport();
        msg.setBuffer(buf, err);
        assertFalse(err.toString(), err.hasError());
    }

    @Ignore
    @Test
    public void testAppMessageValidation() throws Exception {
        final String data = "8=FIXT.1.19=23435=W34=249=ABFX52=20080722-16:37:11.23456=X2RV1"
                + "55=EUR/USD262=CAP0000011268=2269=0270=1.5784415=EUR271=500000272=20080724"
                + "269=1270=1.5786915=EUR271=500000272=2008072410=097";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixMarketDataSnapshotFullRefresh msg = new FixMarketDataSnapshotFullRefresh();
        msg.setBuffer(buf, err);
        assertFalse(err.toString(), err.hasError());
    }

    @Ignore
    @Test
    public void testAdminMessageValidation() throws Exception {
        final String data = "8=FIXT.1.19=8435=A49=EXEC56=BANZAI34=152=20080811-13:26:12.409108=1"
                + "141=Y98=01137=710=102";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
        final FixLogon msg = new FixLogon();
        msg.setBuffer(buf, err);
        assertFalse(err.toString(), err.hasError());
    }

    @Test
    public void testGroupDelimOrdering() throws Exception {
        final FixNewOrderSingle order = new FixNewOrderSingle();
        order.parties[0].setPartyID("TraderName");
        order.parties[0].setPartyIDSource(
                FixMessageInfo.PartyIDSource.GENERALLY_ACCEPTED_MARKET_PARTICIPANT_IDENTIFIER_EG_NASD_MNEMONI);
        order.parties[0].setPartyRole(11);
        order.encode(out); 
        assertTrue(new String(out.array()).indexOf("453=1\001448=TraderName") != -1);
    }

    @Test
    public void testComponentGroupExtraction() throws Exception {
        final FixNewOrderSingle order = new FixNewOrderSingle();
        order.parties[0].setPartyID("PARTY_ID_1");
        order.parties[1].setPartyID("PARTY_ID_2");
        assertEquals(2, FixUtils.getNoInGroup(order.parties));
    }

    @Test
    public void testHeaderDataField() throws Exception {
    	String data = "8=FIX.4.2\0019=53\00135=A\00190=4\00191=ABCD\001"
                + "98=0\001384=2\001372=D\001385=R\001372=8\001385=S\00110=241\001";
        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf, err, new FixMessageListenerImpl() {
    		@Override
    		public void onFixLogon(FixLogon msg) {
    	        assertEquals("ABCD", msg.standardHeader.getSecureData());
    		}
    	});
        
    }

    @Test
    public void testInvalidFirstFieldInGroup() throws Exception {
        final FixNews news = new FixNews();
        news.setHeadline("Test");
        news.instrmtGrp[0].instrument.setSecurityID("SECID");
        news.instrmtGrp[0].instrument.setSecurityIDSource("SECID_SOURCE");

        news.encode(out);
        // TODO we send whatever, nothing is stopping us now!
    }

    @Test
    public void testRequiredGroupValidation() throws Exception {
        final FixNews news = new FixNews();
        news.setHeadline("Test");
        news.encode(out);
        // TODO we send whatever, nothing is stopping us now!
    }

    /**
     *  Test for data fields with SOH. This test is based on report from a user on
     *  the QuickFIX mailing list. The problem was the user's configuration but this
     *  seems like a good unit test to keep in the suite.
     */
    @Test
    public void testDataFieldParsing() throws Exception {
        final String dl = "10001=Canonical.1.00\00110002=001058\00125001=01\00110003=SAPI_ADMRESP\00110004=SUBSCRIBE_RESP\001"
                + "10009=705\00110012=01\00110005=SPGW\00110006=SAPI\00110007=0\00110010=16:25:11.537\001"
                + "10045=SDQADL:01:/SDB/ENT/@/@/STKSDLL:7\00110955=Y\00110963=043\00110961=03\00111285=N\001"
                + "11339=823,980\00110919=N\00111111=86795696\00110898=043\00110920=~\00110938=N\00111340=5-  9.99\001"
                + "11343=0.20\00111344=~\00111341=~\00111342=0.15\00111345=10- 14.99\00111348=0.25\00111349=~\00111346=~\001"
                + "11347=0.15\00111350=15- 19.99\00111353=0.30\00111354=~\00111351=~\00111352=0.20\00111338=23SEP05\001"
                + "10981=0\00110485=N\00110761=0\00111220=~\00111224=N\00110808=N\00110921=~\00110960=N\00110957=N\00111329=N\001"
                + "11286=0\00111214=USA\00110917=Y\00111288=0\00110906=N\00110737=0.01\00110956=~\00110967=~\00110965=~\00110809=0\001"
                + "10762=N\00110763=N\00110712=1\00110905=09:30:00\00110918=YA0101\00110951=Y\00110469=1\00110949=1\00110487=Q\00110950=Y\001"
                + "10899=N\00110380=N\00110696=03\00111082=18.41\00110217=12\00110954=N\00110708=E\00110958=N\00111213=US \00111334=N\001"
                + "11332=N\00111331=N\00111330=N\00111335=N\00111333=N\00110767=3\00110974=~\00110980=AIRTRAN HOLDINGS                \00111289=N\001"
                + "10912=4\00110915=0501\00110914=0501\00110975=N\00110913=SLK\00110698=055\00110666=AAI\00110903=S\00111328=N\001"
                + "10624=L\00111287=0\00110699=0\00110962=L\00111227=SUB1\00111229=5\00111228=1\00111236=16:24:41.521\00111277=16:25:11.630\001";

		String data = "8=FIX.4.4\0019=1144\00135=A\001" + "98=0\001384=2\001372=D\001385=R\001372=8\001385=S\00195=1092\001" + "96=" + dl + "\00110=5\001";
		ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
		parser.parse(buf, err, new FixMessageListenerImpl() {
			@Override
			public void onFixLogon(FixLogon msg) {
				assertEquals(1144L, msg.standardHeader.getBodyLength());
			}
		});
    }


    @Test
    public void testFieldOrdering() throws Exception {
        final String data = "8=FIX.4.49=17135=D49=SenderCompId56=TargetCompId11=183339"
                + "22=838=140=244=1248=BHP54=255=BHP59=160=20060223-22:38:33526=3620453=2448=8"
                + "447=D452=4448=AAA35354447=D452=310=168";

        ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
    	parser.parse(buf, err, new FixMessageListenerImpl() {
    	});

    	assertTrue(err.hasError());
    	//assertEquals(xxx, err.refTagID);
    }

    @Test
	public void testHeaderFieldsMissing() throws Exception {
		final String data = "1=FIX.4.2";

		ByteBuffer buf = ByteBuffer.wrap(data.getBytes());
		parser.parse(buf, err, new FixMessageListenerImpl() {
		});

		assertTrue(err.hasError());
		// assertEquals(xxx, err.refTagID);
	}
    
    /*
     * TODO port all the rest of the test cases 
     * 
    @Test
    public void testCalculateStringWithNestedGroups() throws Exception {
        final NewOrderCross noc = new NewOrderCross();
        noc.getHeader().setString(BeginString.FIELD, FixVersions.BEGINSTRING_FIX44);
        noc.getHeader().setInt(MsgSeqNum.FIELD, 5);
        noc.getHeader().setString(SenderCompID.FIELD, "sender");
        noc.getHeader().setString(TargetCompID.FIELD, "target");
        noc.getHeader().setString(SendingTime.FIELD, "20060319-09:08:20.881");

        noc.setString(SecurityIDSource.FIELD, SecurityIDSource.EXCHANGE_SYMBOL);
        noc.setChar(OrdType.FIELD, OrdType.LIMIT);
        noc.setDouble(Price.FIELD, 9.00);
        noc.setString(SecurityID.FIELD, "ABC");
        noc.setString(Symbol.FIELD, "ABC");
        noc.setString(TransactTime.FIELD, "20060319-09:08:19");
        noc.setString(CrossID.FIELD, "184214");
        noc.setInt(CrossType.FIELD,
                CrossType.CROSS_TRADE_WHICH_IS_EXECUTED_PARTIALLY_AND_THE_REST_IS_CANCELLED);
        noc.setInt(CrossPrioritization.FIELD, CrossPrioritization.NONE);

        final NewOrderCross.NoSides side = new NewOrderCross.NoSides();
        side.setChar(Side.FIELD, Side.BUY);
        side.setDouble(OrderQty.FIELD, 9);

        final NewOrderCross.NoSides.NoPartyIDs party = new NewOrderCross.NoSides.NoPartyIDs();
        party.setString(PartyID.FIELD, "8");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLEARING_FIRM);

        side.addGroup(party);

        party.setString(PartyID.FIELD, "AAA35777");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLIENT_ID);

        side.addGroup(party);

        noc.addGroup(side);

        side.clear();
        side.setChar(Side.FIELD, Side.SELL);
        side.setDouble(OrderQty.FIELD, 9);

        party.clear();
        party.setString(PartyID.FIELD, "8");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLEARING_FIRM);
        side.addGroup(party);

        party.clear();
        party.setString(PartyID.FIELD, "aaa");
        party.setChar(PartyIDSource.FIELD, PartyIDSource.PROPRIETARY_CUSTOM_CODE);
        party.setInt(PartyRole.FIELD, PartyRole.CLIENT_ID);
        side.addGroup(party);

        noc.addGroup(side);

        final String expectedMessage = "8=FIX.4.49=24735=s34=549=sender52=20060319-09:08:20.881"
                + "56=target22=840=244=948=ABC55=ABC60=20060319-09:08:19548=184214549=2"
                + "550=0552=254=1453=2448=8447=D452=4448=AAA35777447=D452=338=954=2"
                + "453=2448=8447=D452=4448=aaa447=D452=338=910=056";
        assertEquals("wrong message", expectedMessage, noc.toString());

    }


    @Test
    public void testHeaderFieldInBody() throws Exception {
        final Message message = new Message("8=FIX.4.2\0019=40\00135=A\001"
                + "98=0\001212=4\001384=2\001372=D\001385=R\001372=8\001385=S\00110=103\001",
                DataDictionaryTest.getDictionary());

        assertFalse(message.hasValidStructure());

        assertTrue(message.getHeader().isSetField(212));

        assertEquals(SessionRejectReason.TAG_SPECIFIED_OUT_OF_REQUIRED_ORDER, message
                .getException().getSessionRejectReason());
        assertEquals(212, message.getException().getField());
    }

   @Test
   public void testTrailerFieldInBody() throws Exception {
        final Message message = new Message("8=FIX.4.2\0019=40\00135=A\001"
                + "98=0\00193=5\001384=2\001372=D\001385=R\001372=8\001385=S\00110=63\001",
                DataDictionaryTest.getDictionary());

        assertFalse(message.hasValidStructure());

        final SignatureLength signatureLength = new SignatureLength();
        message.getTrailer().getField(signatureLength);
        assertEquals(5, signatureLength.getValue());
    }

    @Test
    public void testMessageFromString() {
        Message message = null;

        boolean badMessage = false;
        try {
            message = new Message("8=FIX.4.2\0019=12\00135=A\001108=30\00110=036\001");
        } catch (final InvalidMessage e) {
            badMessage = true;
        }
        assertTrue("Message should be invalid", badMessage);

        try {
            message = new Message("8=FIX.4.2\0019=12\00135=A\001108=30\00110=026\001");
        } catch (final InvalidMessage e) {
            assertTrue("Message should be valid (" + e.getMessage() + ")", false);
        }
        assertEquals("8=FIX.4.2\0019=12\00135=A\001108=30\00110=026\001", message.toString());
    }

    @Test
    public void testMessageGroups() {
        final Message message = new Message();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        assertGroupContent(message, numAllocs);
    }

    @Test
    public void testMessageGroupCountValidation() throws Exception {
        final String data = "8=FIX.4.49=22235=D49=SenderCompId56=TargetCompId34=3752=20070223-22:28:33"
                + "11=18333922=838=140=244=1248=BHP54=255=BHP59=1"
                + "60=20060223-22:38:33526=362078=379=AllocACC180=1010.1"
                + "79=AllocACC280=2020.2453=2448=8447=D452=4448=AAA35354447=D452=310=082";
        final Message message = new Message();
        final DataDictionary dd = DataDictionaryTest.getDictionary();
        message.fromString(data, dd, true);
        try {
            dd.validate(message);
            fail("No exception thrown");
        } catch (final FieldException e) {
            final String emsg = e.getMessage();
            assertNotNull("No exception message", emsg);
            assertTrue(emsg.startsWith("Incorrect NumInGroup"));
        }

    }

    @Test
    public void testMessageCloneWithGroups() {
        final Message message = new Message();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        final Message clonedMessage = (Message) message.clone();
        assertGroupContent(clonedMessage, numAllocs);
    }

    @Test
    public void testFieldOrderAfterClone() {
        final Message message = new quickfix.fix44.NewOrderSingle();
        final quickfix.fix44.NewOrderSingle.NoPartyIDs partyIdGroup = new quickfix.fix44.NewOrderSingle.NoPartyIDs();
        partyIdGroup.set(new PartyID("PARTY_1"));
        partyIdGroup.set(new PartyIDSource(PartyIDSource.DIRECTED_BROKER));
        partyIdGroup.set(new PartyRole(PartyRole.INTRODUCING_FIRM));
        message.addGroup(partyIdGroup);
        final Message clonedMessage = (Message) message.clone();
        assertEquals("wrong field order",
                "8=FIX.4.49=3535=D453=1448=PARTY_1447=I452=610=040", clonedMessage
                        .toString());
    }

    @Test
    public void testMessageGroupRemovalUsingGroupObject() {
        final Message message = new Message();
        final int length = message.calculateLength();
        final int messageFieldWithZeroLengthGroup = length + "79=0\001".length();

        NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        // Remove all

        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(numAllocs);

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());

        // Remove one at a time

        numAllocs = setUpGroups(message);
        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(2, numAllocs);

        assertEquals("wrong # of group members", 1, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(1, numAllocs);

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
    }

    private void assertZeroLengthField(Message message) {
        assertTrue("Incorrect length in message.toString()", message.toString()
                .contains("\00178=0"));
    }

    @Test
    public void testMessageGroupRemovalUsingGroupFieldTag() {
        final Message message = new Message();
        final int length = message.calculateLength();
        final int messageFieldWithZeroLengthGroup = length + "79=0\001".length();
        final int expectedTotalWithZeroLengthGroup = new IntField(78, 0).getTotal();

        NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        // Remove all

        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(numAllocs.getFieldTag());

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
        assertEquals("wrong total", expectedTotalWithZeroLengthGroup, message.calculateTotal());

        // Remove one at a time

        numAllocs = setUpGroups(message);

        assertEquals("wrong # of group members", 2, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(2, numAllocs.getFieldTag());

        assertEquals("wrong # of group members", 1, message.getGroupCount(numAllocs.getFieldTag()));

        message.removeGroup(1, numAllocs.getFieldTag());

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
        assertEquals("wrong total", expectedTotalWithZeroLengthGroup, message.calculateTotal());
    }

    @Test
    public void testMessageGroupRemovalFromEmptyGroup() {
        final Message message = new Message();
        final int length = message.calculateLength();
        final int messageFieldWithZeroLengthGroup = length + "79=0\001".length();
        final int expectedTotalWithZeroLengthGroup = new IntField(78, 0).getTotal();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);
        message.removeGroup(numAllocs);

        // ensure no exception when groups are empty
        message.removeGroup(1, numAllocs);

        assertEquals("wrong # of group members", 0, message.getGroupCount(numAllocs.getFieldTag()));
        assertZeroLengthField(message);
        assertEquals("wrong message length", messageFieldWithZeroLengthGroup, message
                .calculateLength());
        assertEquals("wrong total", expectedTotalWithZeroLengthGroup, message.calculateTotal());
    }

    @Test
    public void testHasGroup() {
        final Message message = new Message();
        final NewOrderSingle.NoAllocs numAllocs = setUpGroups(message);

        assertFalse("wrong value", message.hasGroup(654));
        assertTrue("wrong value", message.hasGroup(numAllocs.getFieldTag()));
        assertTrue("wrong value", message.hasGroup(numAllocs));
        assertTrue("wrong value", message.hasGroup(1, numAllocs));
        assertTrue("wrong value", message.hasGroup(1, numAllocs.getFieldTag()));
        assertTrue("wrong value", message.hasGroup(2, numAllocs));
        assertTrue("wrong value", message.hasGroup(2, numAllocs.getFieldTag()));
        assertFalse("wrong value", message.hasGroup(3, numAllocs));
        assertFalse("wrong value", message.hasGroup(3, numAllocs.getFieldTag()));
    }

    @Test
    public void testIsEmpty() {
        final Message message = new Message();
        assertTrue("Message should be empty on construction", message.isEmpty());
        message.getHeader().setField(new BeginString("FIX.4.2"));
        assertFalse("Header should contain a field", message.isEmpty());
        message.clear();
        assertTrue("Message should be empty after clear", message.isEmpty());
        message.setField(new Symbol("MSFT"));
        assertFalse("Body should contain a field", message.isEmpty());
        message.clear();
        assertTrue("Message should be empty after clear", message.isEmpty());
        message.getTrailer().setField(new CheckSum("10"));
        assertFalse("Trailer should contain a field", message.isEmpty());
        message.clear();
        assertTrue("Message should be empty after clear", message.isEmpty());
    }

    @Test
    public void testMessageSetGetString() {
        final Message message = new Message();

        try {
            message.getString(5);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setString(5, "string5");

        try {
            assertEquals("string5", message.getString(5));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }

        try {
            message.setString(100, null);
            assertTrue("exception not thrown", false);
        } catch (final NullPointerException e) {
        }
    }

    @Test
    public void testMessagesetGetBoolean() {
        final Message message = new Message();

        try {
            message.getBoolean(7);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setBoolean(7, true);

        try {
            assertEquals(true, message.getBoolean(7));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

   @Test
   public void testMessageSetGetChar() {
        final Message message = new Message();

        try {
            message.getChar(12);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setChar(12, 'a');

        try {
            assertEquals('a', message.getChar(12));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testMessageSetGetInt() {
        final Message message = new Message();

        try {
            message.getInt(56);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setInt(56, 23);

        try {
            assertEquals(23, message.getInt(56));
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testMessageSetGetDouble() {
        final Message message = new Message();

        try {
            message.getDouble(9812);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        message.setDouble(9812, 12.3443);

        try {
            assertEquals(12.3443, message.getDouble(9812), 1e-10);
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testMessageSetGetUtcTimeStamp() {
        final Message message = new Message();

        try {
            message.getUtcTimeStamp(8);
            assertTrue("exception not thrown", false);
        } catch (final FieldNotFound e) {
        }

        final TimeZone timezone = TimeZone.getTimeZone("GMT+0");
        final Calendar calendar = Calendar.getInstance(timezone);
        calendar.set(2002, 8, 6, 12, 34, 56);
        calendar.set(Calendar.MILLISECOND, 0);

        final Date time = calendar.getTime();
        message.setUtcTimeStamp(8, time);

        try {
            assertEquals(message.getUtcTimeStamp(8).getTime(), time.getTime());
        } catch (final FieldNotFound e) {
            assertTrue("exception thrown", false);
        }
    }

    @Test
    public void testRemoveField() {
        final Message message = new Message();
        message.setField(new StringField(12, "value"));
        assertTrue(message.isSetField(12));
        message.removeField(12);
        assertTrue(!message.isSetField(12));
    }

    @Test
    public void testMessageIterator() {
        Message message = new Message();
        java.util.Iterator<Field<?>> i = message.iterator();
        assertEquals(false, i.hasNext());
        try {
            assertNull(i.next());
            fail("exception not thrown");
        } catch (final java.util.NoSuchElementException e) {
        }

        try {
            message = new Message("8=FIX.4.2\0019=12\00135=A\001108=30\00110=026\001");
            i = message.iterator();
            assertTrue(i.hasNext());
            StringField field = (StringField) i.next();
            assertEquals(108, field.getField());
            assertEquals("30", field.getValue());

            assertEquals(false, i.hasNext());
            try {
                assertNull(i.next());
                fail("exception not thrown");
            } catch (final java.util.NoSuchElementException e) {
            }

            final java.util.Iterator<Field<?>> j = message.getHeader().iterator();
            assertTrue(j.hasNext());
            field = (StringField) j.next();
            assertEquals(8, field.getField());
            assertEquals("FIX.4.2", field.getValue());
            field = (StringField) j.next();
            assertEquals(9, field.getField());
            assertEquals("12", field.getValue());
            field = (StringField) j.next();
            assertEquals(35, field.getField());
            assertEquals("A", field.getValue());

            assertEquals(false, j.hasNext());
            try {
                assertNull(j.next());
                fail("exception not thrown");
            } catch (final java.util.NoSuchElementException e) {
            }

        } catch (final InvalidMessage e) {
            fail("exception thrown");
        }
    }

    @Test
    public void testIsAdmin() {
        final Message message = new Message();

        message.getHeader().setString(MsgType.FIELD, MsgType.HEARTBEAT);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.LOGON);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.LOGOUT);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.SEQUENCE_RESET);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.RESEND_REQUEST);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.TEST_REQUEST);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.REJECT);
        assertTrue(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.ORDER_SINGLE);
        assertFalse(message.isAdmin());

        message.getHeader().setString(MsgType.FIELD, MsgType.QUOTE_RESPONSE);
        assertFalse(message.isAdmin());
    }

    @Test
    public void testComponent() throws Exception {
        final Instrument instrument = new Instrument();
        instrument.set(new Symbol("DELL"));
        instrument.set(new CountryOfIssue("USA"));
        instrument.set(new SecurityType(SecurityType.COMMON_STOCK));

        final quickfix.fix44.NewOrderSingle newOrderSingle = new quickfix.fix44.NewOrderSingle();
        newOrderSingle.set(instrument);
        newOrderSingle.set(new OrderQty(100));
        newOrderSingle.set(new Price(45));

        assertEquals(new Symbol("DELL"), newOrderSingle.getSymbol());
        assertEquals(new CountryOfIssue("USA"), newOrderSingle.getCountryOfIssue());
        assertEquals(new SecurityType(SecurityType.COMMON_STOCK), newOrderSingle.getSecurityType());

        newOrderSingle.set(new ClOrdID("CLIENT_ORDER_ID"));
        final Instrument instrument2 = newOrderSingle.getInstrument();
        assertEquals(new Symbol("DELL"), instrument2.getSymbol());
        assertEquals(new CountryOfIssue("USA"), instrument2.getCountryOfIssue());
        assertEquals(new SecurityType(SecurityType.COMMON_STOCK), instrument2.getSecurityType());
        try {
            instrument2.getField(new ClOrdID());
            fail("should have thrown exception");
        } catch (final FieldNotFound e) {
            // expected
        }

    }

    @Test
    public void testReplaceGroup() throws Exception {
        final Message message = new Message();
        message.setField(new ListID("1"));
        message.setField(new BidType(0));
        message.setField(new TotNoOrders(3));

        final NewOrderList.NoOrders group = new NewOrderList.NoOrders();
        group.set(new ClOrdID("A"));
        group.set(new ListSeqNo(1));
        group.set(new Symbol("DELL"));
        group.set(new Side('1'));
        message.addGroup(group);

        group.set(new ClOrdID("B"));
        group.set(new ListSeqNo(2));
        group.set(new Symbol("LNUX"));
        group.set(new Side('2'));
        message.addGroup(group);

        group.set(new ClOrdID("C"));
        group.set(new ListSeqNo(3));
        group.set(new Symbol("RHAT"));
        group.set(new Side('3'));
        message.addGroup(group);

        group.set(new ClOrdID("D"));
        group.set(new ListSeqNo(4));
        group.set(new Symbol("AAPL"));
        group.set(new Side('4'));
        message.replaceGroup(2, group);

        final NoOrders noOrders = new NoOrders();

        assertTrue(message.hasGroup(1, group));
        assertTrue(message.hasGroup(2, group));
        assertTrue(message.hasGroup(3, group));
        assertEquals(3, message.getGroupCount(NoOrders.FIELD));
        message.getField(noOrders);
        assertEquals(3, noOrders.getValue());

        final ClOrdID clOrdID = new ClOrdID();
        message.getGroup(1, group);
        assertEquals("A", group.getField(clOrdID).getValue());
        message.getGroup(2, group);
        assertEquals("D", group.getField(clOrdID).getValue());
        message.getGroup(3, group);
        assertEquals("C", group.getField(clOrdID).getValue());
    }

    @Test
    public void testFalseMessageStructureException() {
        try {
            final DataDictionary dd = DataDictionaryTest.getDictionary();
            // duplicated tag 98
            // QFJ-65
            new Message("8=FIX.4.4\0019=22\00135=A\00198=0\00198=0\001108=30\00110=223\001", dd,
                    true);
            // For now, this will not cause an exception if the length and checksum are correct
        } catch (final Exception e) {
            final String text = e.getMessage();
            assertTrue("Wrong exception message: " + text, text.indexOf("Actual body length") == -1);
        }
    }

    @Test
    public void testComponentInGroup() {
        try {
            final DataDictionary dd = DataDictionaryTest.getDictionary();
            // duplicated tag 98
            // QFJ-65
            // 8=FIX.4.4\0019=941\00135=AE\00149=ICE\00134=63\00152=20091117-18:59:04.780\00156=XXXX\00157=X\001571=219449\001487=0\001856=0\001828=0\001150=F\00117=44750544433\00139=2\001570=N\00155=480120\00148=WBS FMG0010-BRN FMG0010\00122=8\001461=FXXXXX\001916=20100201\001917=20100228\00132=1.0\00131=0.69\0019018=1\0019022=1\00175=20091117\00160=20091117-18:59:04.775\001552=1\00154=2\00137=41296064\00111=557859232\001453=7\001448=trader\001447=D\001452=11\001448=Trading Corp\001447=D\001452=13\001448=2757\001447=D\001452=56\001448=805\001447=D\001452=4\001448=11122556\001447=D\001452=51\001448=FCM\001447=D\001452=60\001448=U\001447=D\001452=5 458=41293051\001555=2\001600=460130\001602=WBS FMG0010!\001603=8\001608=FXXXXX\001624=2\001637=80.78\001687=1.0\001654=41296074\0019019=1\0019023=1\0019020=20100201\0019021=20100228\001539=4\001524=805\001525=D\001538=4\001524=11122556\001525=D\001538=51\001524=FCM\001525=D\001538=60 524=U\001525=D\001538=54\001600=217927\001602=BRN FMG0010! 63=8 608-FXXXXX 624=1 637=80.09 687=1.0 654=41296073 9019=1 9023=1 9020=20100201 9021=20100228 539=4 524=805\001525=D\001538=4\001524=11122556 525=D\001538=51 524=Newedge 525=D 538=60 524=U 525=D 538=54 10=112
            new Message(
                    "8=FIX.4.4\0019=941\00135=AE\00149=ICE\00134=63\00152=20091117-18:59:04.780\00156=XXXX\00157=X\001571=219449\001487=0\001856=0\001828=0\001150=F\00117=44750544433\00139=2\001570=N\00155=480120\00148=WBS FMG0010-BRN FMG0010\00122=8\001461=FXXXXX\001916=20100201\001917=20100228\00132=1.0\00131=0.69\0019018=1\0019022=1\00175=20091117\00160=20091117-18:59:04.775\001552=1\00154=2\00137=41296064\00111=557859232\001453=7\001448=trader\001447=D\001452=11\001448=Trading Corp\001447=D\001452=13\001448=2757\001447=D\001452=56\001448=805\001447=D\001452=4\001448=11122556\001447=D\001452=51\001448=FCM\001447=D\001452=60\001448=U\001447=D\001452=5 458=41293051\001555=2\001600=460130\001602=WBS FMG0010!\001603=8\001608=FXXXXX\001624=2\001637=80.78\001687=1.0\001654=41296074\0019019=1\0019023=1\0019020=20100201\0019021=20100228\001539=4\001524=805\001525=D\001538=4\001524=11122556\001525=D\001538=51\001524=FCM\001525=D\001538=60 524=U\001525=D\001538=54\001600=217927\001602=BRN FMG0010!\00163=8 608-FXXXXX\001624=1\001637=80.09\001687=1.0\001654=41296073\0019019=1\0019023=1\0019020=20100201\001021=20100228\001539=4\001524=805\001525=D\001538=4\001524=11122556\001525=D\001538=51\001524=FCM\001525=D\001538=60 524=U\001525=D\001538=54\001600=217927\001602=BRN FMG0010!\00163=8 608-FXXXXX\001624=1\001637=80.09\001687=1.0\001654=41296073\0019019=1\0019023=1\0019020=20100201\001021=20100228\001",
                    dd, true);
            // For now, this will not cause an exception if the length and checksum are correct
        } catch (final Exception e) {
            final String text = e.getMessage();
            assertTrue("Wrong exception message: " + text, text.indexOf("Actual body length") == -1);
        }
    }

    @Test
    public void testFalseMessageStructureException2() {
        try {
            final DataDictionary dd = DataDictionaryTest.getDictionary();
            // duplicated raw data length 
            // QFJ-121
            new Message("8=FIX.4.4\0019=22\00135=A\00196=X\001108=30\00110=223\001", dd, true);
        } catch (final Exception e) {
            final String text = e.getMessage();
            assertTrue("Wrong exception message: " + text, text != null
                    && text.indexOf("Actual body length") == -1);
        }
    }

    @Test
    public void testEmptyMessageToString() throws Exception {
        final Message msg = new quickfix.Message();
        assertNotNull(msg.toString());
        assertTrue("empty message contains no checksum", msg.toString().length() > 0);
    }

    @Test
    public void testMessageBytesField() throws Exception {
        final Logon logon = new Logon();
        final String data = "rawdata";
        logon.set(new RawDataLength(data.length()));
        logon.setField(new BytesField(RawData.FIELD, data.getBytes()));
        //logon.set(new RawData(data));
        assertEquals("8=FIX.4.49=2135=A95=796=rawdata10=086", logon.toString());
    }

    private void assertGroupContent(Message message, NewOrderSingle.NoAllocs numAllocs) {
        StringField field = null;
        final java.util.Iterator<Field<?>> i = numAllocs.iterator();
        assertTrue(i.hasNext());
        field = (StringField) i.next();
        assertEquals("AllocACC2", field.getValue());
        assertTrue(i.hasNext());
        field = (StringField) i.next();
        assertEquals("2020.20", field.getValue());
        assertTrue(!i.hasNext());

        try {
            final String accountId = numAllocs.getField(new AllocAccount()).getValue();
            final Object shares = numAllocs.getField(new AllocShares()).getObject();
            message.getGroup(1, numAllocs);
            assertAllocation(accountId, shares);
            message.getGroup(2, numAllocs);
            assertEquals("AllocACC2", accountId);
            assertAllocation(accountId, shares);
        } catch (final FieldNotFound e) {
            fail("no exception should be thrown");
        }

        try {
            message.getGroup(3, numAllocs);
            fail("exception should be thrown");
        } catch (final FieldNotFound ignored) {
        }
    }

    private void assertAllocation(String accountId, Object shares) {
        if (accountId.equals("AllocACC1")) {
            assertEquals("got shares: " + shares, 0, new BigDecimal("1010.10")
                    .compareTo(new BigDecimal(shares.toString())));
        } else if (accountId.equals("AllocACC2")) {
            assertEquals("got shares: " + shares, 0, new BigDecimal("2020.20")
                    .compareTo(new BigDecimal(shares.toString())));
        } else {
            fail("Unknown account");
        }
    }

    private FixAllocGrp setUpGroups(FixInMessage message) {
        final NewOrderSingle.NoAllocs numAllocs = new NewOrderSingle.NoAllocs();
        numAllocs.set(new AllocAccount("AllocACC1"));
        numAllocs.setField(new StringField(AllocShares.FIELD, "1010.10"));
        message.addGroup(numAllocs);
        numAllocs.setField(new AllocAccount("AllocACC2"));
        numAllocs.setField(new StringField(AllocShares.FIELD, "2020.20"));
        message.addGroup(numAllocs);
        return numAllocs;
    }
    
    */

}