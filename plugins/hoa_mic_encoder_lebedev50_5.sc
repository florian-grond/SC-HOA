FaustHOAEncLebedev505 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, in37, in38, in39, in40, in41, in42, in43, in44, in45, in46, in47, in48, in49, in50, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), mute_6(0.0), mute_7(0.0), mute_8(0.0), mute_9(0.0), mute_10(0.0), mute_11(0.0), mute_12(0.0), mute_13(0.0), mute_14(0.0), mute_15(0.0), mute_16(0.0), mute_17(0.0), mute_18(0.0), mute_19(0.0), mute_20(0.0), mute_21(0.0), mute_22(0.0), mute_23(0.0), mute_24(0.0), mute_25(0.0), mute_26(0.0), mute_27(0.0), mute_28(0.0), mute_29(0.0), mute_30(0.0), mute_31(0.0), mute_32(0.0), mute_33(0.0), mute_34(0.0), mute_35(0.0), mute_36(0.0), mute_37(0.0), mute_38(0.0), mute_39(0.0), mute_40(0.0), mute_41(0.0), gain_41(0.0) |
      ^this.multiNew('audio', in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, in37, in38, in39, in40, in41, in42, in43, in44, in45, in46, in47, in48, in49, in50, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, mute_6, mute_7, mute_8, mute_9, mute_10, mute_11, mute_12, mute_13, mute_14, mute_15, mute_16, mute_17, mute_18, mute_19, mute_20, mute_21, mute_22, mute_23, mute_24, mute_25, mute_26, mute_27, mute_28, mute_29, mute_30, mute_31, mute_32, mute_33, mute_34, mute_35, mute_36, mute_37, mute_38, mute_39, mute_40, mute_41, gain_41)
  }

  *kr { | in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, in37, in38, in39, in40, in41, in42, in43, in44, in45, in46, in47, in48, in49, in50, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), mute_6(0.0), mute_7(0.0), mute_8(0.0), mute_9(0.0), mute_10(0.0), mute_11(0.0), mute_12(0.0), mute_13(0.0), mute_14(0.0), mute_15(0.0), mute_16(0.0), mute_17(0.0), mute_18(0.0), mute_19(0.0), mute_20(0.0), mute_21(0.0), mute_22(0.0), mute_23(0.0), mute_24(0.0), mute_25(0.0), mute_26(0.0), mute_27(0.0), mute_28(0.0), mute_29(0.0), mute_30(0.0), mute_31(0.0), mute_32(0.0), mute_33(0.0), mute_34(0.0), mute_35(0.0), mute_36(0.0), mute_37(0.0), mute_38(0.0), mute_39(0.0), mute_40(0.0), mute_41(0.0), gain_41(0.0) |
      ^this.multiNew('control', in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, in37, in38, in39, in40, in41, in42, in43, in44, in45, in46, in47, in48, in49, in50, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, mute_6, mute_7, mute_8, mute_9, mute_10, mute_11, mute_12, mute_13, mute_14, mute_15, mute_16, mute_17, mute_18, mute_19, mute_20, mute_21, mute_22, mute_23, mute_24, mute_25, mute_26, mute_27, mute_28, mute_29, mute_30, mute_31, mute_32, mute_33, mute_34, mute_35, mute_36, mute_37, mute_38, mute_39, mute_40, mute_41, gain_41)
  } 

  checkInputs {
    if (rate == 'audio', {
      50.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(36, rate)
  }

  name { ^"FaustHOAEncLebedev505" }
}

