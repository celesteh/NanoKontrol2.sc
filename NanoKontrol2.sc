/*
	TODO for original nanoKontrol: 

		- implement scenes
		
		Done from pre-forked TODO:
			knobs.do({}) iterates through a collection of NKController s
			faders.do({}) iterates through a collection of NKController s
			
	TODO for nanoKontrol2:
	
		make buttons light up
		
*/


NanoKontrol2 : NanoKontrol {

	var sBts, mBts, rBts;
	
	*new{
		^super.new.initNanoKontrol;
	}
	
	initNanoKontrol{	
		
		faderDict = IdentityDictionary[
			\fader1 -> NKController.new(0),
			\fader2 -> NKController.new(1),
			\fader3 -> NKController.new(2),
			\fader4 -> NKController.new(3),
			\fader5 -> NKController.new(4),
			\fader6 -> NKController.new(5),
			\fader7 -> NKController.new(6),
			\fader8 -> NKController.new(7)
		];
		
		knobDict = IdentityDictionary[
			\knob1 -> NKController.new(16),
			\knob2 -> NKController.new(17),
			\knob3 -> NKController.new(18),
			\knob4 -> NKController.new(19),
			\knob5 -> NKController.new(20),
			\knob6 -> NKController.new(21),
			\knob7 -> NKController.new(22),
			\knob8 -> NKController.new(23)
		];
		
		sBts = IdentityDictionary[
			\sBt1 -> NKButton.new(32),
			\sBt2 -> NKButton.new(33),
			\sBt3 -> NKButton.new(34),
			\sBt4 -> NKButton.new(35),
			\sBt5 -> NKButton.new(36),
			\sBt6 -> NKButton.new(37),
			\sBt7 -> NKButton.new(38),
			\sBt8 -> NKButton.new(39)
		];

		mBts = IdentityDictionary[
			\mBt1 -> NKButton.new(48),
			\mBt2 -> NKButton.new(49),
			\mBt3 -> NKButton.new(50),
			\mBt4 -> NKButton.new(51),
			\mBt5 -> NKButton.new(52),
			\mBt6 -> NKButton.new(53),
			\mBt7 -> NKButton.new(54),
			\mBt8 -> NKButton.new(55)
		];


		rBts = IdentityDictionary[
			\rBt1 -> NKButton.new(64),
			\rBt2 -> NKButton.new(65),
			\rBt3 -> NKButton.new(66),
			\rBt4 -> NKButton.new(67),
			\rBt5 -> NKButton.new(68),
			\rBt6 -> NKButton.new(69),
			\rBt7 -> NKButton.new(70),
			\rBt8 -> NKButton.new(71),
		];

		
		transportBts= IdentityDictionary[
			\playBt   -> NKButton.new(41),
			\stopBt   -> NKButton.new(42),
			\recBt   -> NKButton.new(45),
			\rewindBt -> NKButton.new(43),
			\ffwBt    -> NKButton.new(44),
			\fwdTrackBt   -> NKButton.new(59),
			\bkTrackBt   -> NKButton.new(58),
			\cycleBt   -> NKButton.new(46),
			\setMarkerBt   -> NKButton.new(60),
			\bkMarkerBt   -> NKButton.new(61),
			\fwdMarkerBt   -> NKButton.new(62)


		];	
	
		controllers = IdentityDictionary.new;
		controllers.putAll(faderDict, knobDict, sBts, mBts, rBts, transportBts);

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
	
	faders {
		^faderDict.values;
	}
	
	knobs {
		^knobDict.values;
	}
	
}

NKController {
	
	var <num;
	var responder;
	
	*new{|n|
		^super.new.initNKController(n);
	}
	
	initNKController{|n|
		num = n;
	}
	
	// setter for responder
	onChanged_ { |action| 
		if (responder != nil, {responder.remove;}); // remove if already assigned

		responder = CCResponder({|src, chan, num, vel| 
			action.value(vel);  // to make explicit use of velocity, we pass it as a param
		}, num:num);

	}
	
	removeResponders{
		if (responder != nil, {responder.remove;}); // remove if already assigned
	}

}

NKButton : NKController {
	
	var pressResponder, releaseResponder;
	
	onPress_{|action|
		if (pressResponder != nil, {pressResponder.remove;}); // remove if already assigned

		pressResponder = CCResponder({|src, chan, num, vel| 
			if (vel == 127, {action.value()})
		}, num:num);
	}

	onRelease_{|action|
		if (releaseResponder != nil, {releaseResponder.remove;}); // remove if already assigned

		releaseResponder = CCResponder({|src, chan, num, vel| 
			if (vel == 0, {action.value()})
		}, num:num);
	}
	
	removeResponders{
		super.removeResponders();
		if (pressResponder != nil, {pressResponder.remove;}); // remove if already assigned
		if (releaseResponder != nil, {releaseResponder.remove;}); // remove if already assigned
	}
	
}