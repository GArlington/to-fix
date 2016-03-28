# FIX Protocol Message Containers - Lightweight  low latency message encoder/decoder #

## Summary ##
The to-fix project is a low latency high performance FIX message containers written in Java. The message containers are generated based on an extended QuickFIX XML specification. The to-fix containers supports all FIX versions, 4.2,4.3, 4.4, 5.0, 5.0Sp1, 5.0,sp2, FIXT including adaptations like FIX 4.2 INET Nordic.

A user should modify the XML specification and generate containers for the particular FIX dialect used on the target exchange.

## Performance ##
Fix message encoding and decoding latency for a arbitrary message set; comparison of to-fix with quickFixj on a Intel Core i7 3.07GHz

<img src='http://tomac.org/images/QuickFixToFixPerformanceComparison.png' />


# Developers Guide #
  1. **Create Customized XML** specification based fixprotocol.org FIX repository or by manually editing existing templates.
  1. **Generate Message Containers** using the to-fix FixMessageGenerator.

## Create Customized XML ##
Message java code is generated based on an XML specification following the format that extends the QuickFix XML format.

If the exchange provide a standerd FIX Repository the XML specification may be generated using the [fix-repository-to-quickfix-xml](http://code.google.com/p/fix-repository-to-quickfix-xml/).
Else the specification need to be manually created.  See [extended QuickFix XML Format](XMLFormat.md) for details.

Sample of extended QuickFix XML specifications.
  * [Bats Europe](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX42BatsEurope.xml)
  * [Chi-East](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX42ChiEast.xml)
  * [Chi-X Europe](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX42ChiXEurope.xml)
  * [Chi-X Japan](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX42ChiXJapan.xml)
  * [Nasdaq OMX Nordic Equities](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX42Nordic.xml)
  * [Nasdaq OMX Nordic Derivatives](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX44Nordic.xml)
  * [LSE order](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX50LSE-order.xml)
  * [LSE trade](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX50LSE-trade.xml)
  * [Sigma MTF](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX42SigmaMTF.xml)
  * [5.0 SP2](http://code.google.com/p/to-fix/source/browse/trunk/repository/FIX50SP2.xml)

## Generate Message Containers ##

_Prerequisites_
Download the latest to-fix-FixMessageGenerator jar file from [Downloads](http://code.google.com/p/to-fix/downloads/list)

Run the message generator:
```
java -jar to-fix-FixMessageGenerator-x.x.jar <my_xml_spec> <my_code>
# example
# java -jar to-fix-FixMessageGenerator.jar C:\Users\seto\Desktop\src\to-fix\repository\FIX42Nordic.xml 
# C:\Users\seto\Desktop\src\to-fix\src\main\java
```


# Usage #
For users of the to-fix FIX message containers.

#### Prerequisites ####
Create or download the protocol dialect jar at [Downloads](http://code.google.com/p/to-fix/downloads/list).

#### Simple Code Example ####
Simple example directly allocating the FIX message objects.
```
// allocate your out bound message
FixLogon logon = new FixLogon();
// populate the fields
logon.heartBtInt = 10;
// ...
// to get field values
long heartBtInt = logon.heartBtInt;

// In-bound message from raw fix message ByteBuffer in buf
ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=82\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u00011137=9\u000110=102\u0001").getBytes());
// In-bound message from raw fix message byte buffer

try {
	// Get the message type 
	FixMessage.crackMsgType(buf);
	// based on message type pares the message
	FixLogon logon = new FixLogon();

	// decode the message
	logon.setBuffer(buf);
	logon.getAll();

	// get field values
	long bodyLength = logon.bodyLength;
	// ...
} catch (FixGarbledException e) {
        // this message is garbled 
} catch (FixSessionException e) {
	// this message contins static fix session error(s)
        // like tag value, enumerated values, required tags.
}

```

#### Proper Example Message Listener ####
A proper example, using a message listener for inbound messages.
```
// create a listener, parser and error holder for in-bound FIX messages
MyFixMessageListener listener = new MyFixMessageListener();
FixMessageParser parser = new FixMessageParser();

ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=82\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u00011137=9\u000110=102\u0001").getBytes());
// the buf ByteBuffer contains the raw fix message
try {
	parser.parse(buf, listener);
} catch (FixSessionException e) {
        // this message is garbled
} catch (FixGarbledException e) {
	// this message contins static fix session error(s)
}
```

#### Validator ####
The FIX message parser exposes a validator, enabling dynamic session validation (like MsgSeqNum, SendingTime, validity of CompIDs).
Implement the interface FixSessionValidator, and set it.
The FixSessionValidator interface has one method;
```
public boolean validate(FixMessage msg)  throws FixSessionException {return true;}
```
If session validation fails the implementation should throw a FixSessionException.
On successful session validation (e.g. no Exception thrown), the validator boolean return value indicates if the listener was called or not. If the validate returns false, the parser did not call the listener - typically this would happen if the buffer sent to the passer contained an incomplete raw FIX message passed. If the parser returns true the listener was be called.






