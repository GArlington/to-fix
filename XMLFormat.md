## XML Specification ##


## Sample XML ##
```
<fix major="4" minor="2" servicepack="0" type="FIX" package="org.tomac.protocol.fix.messaging" flavour="Nordic INET">
  <header>
    <field name="BeginString" required="Y"/>
    <field name="BodyLength" required="Y"/>
<!-- -->
  <messages>
    <message name="AcceptedCancelReplace" msgcat="app" msgtype="8" msgsubtype="5">
      <field name="AvgPx" required="Y"/>
      <field name="ClOrdID" required="Y"/>
<!-- -->
  <trailer>
    <field name="CheckSum" required="Y"/>
<!-- -->
  <fields>
    <field name="PegDifference" number="211" type="PRICEOFFSET"/>
    <field name="HandlInst" number="21" type="CHAR">
      <value enum="1" description="AUTOMATED_EXECUTION_ORDER_PRIVATE_NO_BROKER_INTERVENTION"/>
    </field>
    <field name="TrdRptStatus" number="939" type="STRING">
      <value enum="98" description="UNANSWEREDA_ONESIDED_TRADE_REPORT_THAT_HAS_NOT_BEEN_LOCKEDIN"/>
      <value enum="95" description="A_TRADE_ENTERED_BY_ONE_PARTY_AS_A_TWOPARTY_LOCKEDIN_TRADE"/>
      <value enum="92" description="A_TRADE_LOCKEDIN_BY_THE_MATCHING_PROCESS"/>
    </field>
    <field name="BeginString" number="8" type="STRING" length="7"/>
    <field name="TradeReportID" number="571" type="STRING" length="20"/>

```