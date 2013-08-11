/*
	TODO for original nanoKontrol:

		- implement scenes

		- do something meaningul with Collections for Knobs and Faders
			knobs.do({})
			faders.do({})

	TODO for nanoKontrol2:

		make buttons light up

*/


NanoKontrol2 : NanoKontrol {

	var sBts, mBts, rBts, midi;

	*new{
		^super.new.initNanoKontrol;
	}

	initNanoKontrol{


		//MIDIClient.init;

		//MIDIClient.sources.do({|m, i|
			//m.postln;
			//m.name.postln;
			//m.name.contains("nanoKONTROL2").if({// check this
				//midi = MIDIOut(i);
				//midi.connect(0);
			//i .postln;
			//});
		//});

		//midi = MIDIIn.findPort("nano", "dunno"); // check this

		faderDict = IdentityDictionary[
			\fader1 -> NKController.new(0, midi),
			\fader2 -> NKController.new(1, midi),
			\fader3 -> NKController.new(2, midi),
			\fader4 -> NKController.new(3, midi),
			\fader5 -> NKController.new(4, midi),
			\fader6 -> NKController.new(5, midi),
			\fader7 -> NKController.new(6, midi),
			\fader8 -> NKController.new(7, midi)
		];

		knobDict = IdentityDictionary[
			\knob1 -> NKController.new(16, midi),
			\knob2 -> NKController.new(17, midi),
			\knob3 -> NKController.new(18, midi),
			\knob4 -> NKController.new(19, midi),
			\knob5 -> NKController.new(20, midi),
			\knob6 -> NKController.new(21, midi),
			\knob7 -> NKController.new(22, midi),
			\knob8 -> NKController.new(23, midi)
		];

		sBts = IdentityDictionary[
			\sBt1 -> NKButton.new(32, midi),
			\sBt2 -> NKButton.new(33, midi),
			\sBt3 -> NKButton.new(34, midi),
			\sBt4 -> NKButton.new(35, midi),
			\sBt5 -> NKButton.new(36, midi),
			\sBt6 -> NKButton.new(37, midi),
			\sBt7 -> NKButton.new(38, midi),
			\sBt8 -> NKButton.new(39, midi)
		];

		mBts = IdentityDictionary[
			\mBt1 -> NKButton.new(48, midi),
			\mBt2 -> NKButton.new(49, midi),
			\mBt3 -> NKButton.new(50, midi),
			\mBt4 -> NKButton.new(51, midi),
			\mBt5 -> NKButton.new(52, midi),
			\mBt6 -> NKButton.new(53, midi),
			\mBt7 -> NKButton.new(54, midi),
			\mBt8 -> NKButton.new(55, midi)
		];


		rBts = IdentityDictionary[
			\rBt1 -> NKButton.new(64, midi),
			\rBt2 -> NKButton.new(65, midi),
			\rBt3 -> NKButton.new(66, midi),
			\rBt4 -> NKButton.new(67, midi),
			\rBt5 -> NKButton.new(68, midi),
			\rBt6 -> NKButton.new(69, midi),
			\rBt7 -> NKButton.new(70, midi),
			\rBt8 -> NKButton.new(71, midi),
		];


		transportBts= IdentityDictionary[
			\playBt   -> NKButton.new(41, midi),
			\stopBt   -> NKButton.new(42, midi),
			\recBt   -> NKButton.new(45, midi),
			\rewindBt -> NKButton.new(43, midi),
			\ffwBt    -> NKButton.new(44, midi),
			\fwdTrackBt   -> NKButton.new(59, midi),
			\bkTrackBt   -> NKButton.new(58, midi),
			\cycleBt   -> NKButton.new(46, midi),
			\setMarkerBt   -> NKButton.new(60, midi),
			\bkMarkerBt   -> NKButton.new(61, midi),
			\fwdMarkerBt   -> NKButton.new(62, midi)


		];

		controllers = IdentityDictionary.new;
		controllers.putAll(faderDict, knobDict, sBts, mBts, rBts, transportBts);

	}

	at{ |sym|
		^controllers.at(sym);
	}



}


NanoKontrol {

	var faderDict, knobDict, topBts, bottomBts, transportBts;
	var <controllers;


	*new{
		^super.new.initNanoKontrol;
	}

	initNanoKontrol{

		faderDict = IdentityDictionary[
			\fader1 -> NKController.new(2),
			\fader2 -> NKController.new(3),
			\fader3 -> NKController.new(4),
			\fader4 -> NKController.new(5),
			\fader5 -> NKController.new(6),
			\fader6 -> NKController.new(8),
			\fader7 -> NKController.new(9),
			\fader8 -> NKController.new(12),
			\fader9 -> NKController.new(13)
		];

		knobDict = IdentityDictionary[
			\knob1 -> NKController.new(14),
			\knob2 -> NKController.new(15),
			\knob3 -> NKController.new(16),
			\knob4 -> NKController.new(17),
			\knob5 -> NKController.new(18),
			\knob6 -> NKController.new(19),
			\knob7 -> NKController.new(20),
			\knob8 -> NKController.new(21),
			\knob9 -> NKController.new(22)
		];

		topBts = IdentityDictionary[
			\topBt1 -> NKButton.new(23),
			\topBt2 -> NKButton.new(24),
			\topBt3 -> NKButton.new(25),
			\topBt4 -> NKButton.new(26),
			\topBt5 -> NKButton.new(27),
			\topBt6 -> NKButton.new(28),
			\topBt7 -> NKButton.new(29),
			\topBt8 -> NKButton.new(30),
			\topBt9 -> NKButton.new(31)
		];

		bottomBts = IdentityDictionary[
			\bottomBt1 -> NKButton.new(33),
			\bottomBt2 -> NKButton.new(34),
			\bottomBt3 -> NKButton.new(35),
			\bottomBt4 -> NKButton.new(36),
			\bottomBt5 -> NKButton.new(37),
			\bottomBt6 -> NKButton.new(38),
			\bottomBt7 -> NKButton.new(39),
			\bottomBt8 -> NKButton.new(40),
			\bottomBt9 -> NKButton.new(41)
		];

		transportBts= IdentityDictionary[
			\playBt   -> NKButton.new(45),
			\stopBt   -> NKButton.new(46),
			\recBt   -> NKButton.new(44),
			\rewindBt -> NKButton.new(47),
			\ffwBt    -> NKButton.new(48),
			\loopBt   -> NKButton.new(49)
		];

		controllers = IdentityDictionary.new;
		controllers.putAll(faderDict, knobDict, topBts, bottomBts, transportBts);

	}

	doesNotUnderstand { arg selector ... args;
		var controller = controllers.at(selector);
		^ controller ?? {super.doesNotUnderstand( selector, args)};
	}

	removeAllResponders {
		controllers.do({|cDict|
			cDict.do({|c|
				c.removeResponders;
			})
		});
	}

	// this is stupid

	faders {
		^faderDict.values;
	}

	knobs {
		^knobDict.values;
	}

	action_{|sym, act|

		^controllers.at(sym).action_(act);
	}

	setAction{|sym, act|
		^this.action_(sym, act)
	}

	at{ |sym|
		^controllers.at(sym);
	}


}

NKController {

	var <num;
	var responder;
	var <value;
	var uid;

	*new{|n, midi|
		^super.new.initNKController(n, midi);
	}

	initNKController{|n, midi|
		num = n;
		value = 0;
		midi.notNil.if({
			uid = midi.uid;
			uid.postln;
		});

		responder = CCResponder({|src, chan, num, vel|
			value = vel;
		}, uid, num:num);
	}

	// setter for responder
	onChanged_ { |act|
		if (responder != nil, {responder.remove;}); // remove if already assigned

		responder = CCResponder({|src, chan, num, vel|
			act.value(vel);  // to make explicit use of velocity, we pass it as a param
			value = vel;
		}, uid, num:num);

	}

	action_ {|act|
		^this.onChanged_(act);
	}


	removeResponders{
		if (responder != nil, {responder.remove;}); // remove if already assigned

		responder = CCResponder({|src, chan, num, vel|
			value = vel;
		}, uid, num:num);
	}

}

NKButton : NKController {

	var pressResponder, releaseResponder;

	onPress_{|action|
		if (pressResponder != nil, {pressResponder.remove;}); // remove if already assigned

		pressResponder = CCResponder({|src, chan, num, vel|
			if (vel == 127, {action.value()})
		}, uid, num:num);
	}

	onRelease_{|action|
		if (releaseResponder != nil, {releaseResponder.remove;}); // remove if already assigned

		releaseResponder = CCResponder({|src, chan, num, vel|
			if (vel == 0, {action.value()})
		}, uid, num:num);
	}

	removeResponders{
		super.removeResponders();
		if (pressResponder != nil, {pressResponder.remove;}); // remove if already assigned
		if (releaseResponder != nil, {releaseResponder.remove;}); // remove if already assigned
	}

}
