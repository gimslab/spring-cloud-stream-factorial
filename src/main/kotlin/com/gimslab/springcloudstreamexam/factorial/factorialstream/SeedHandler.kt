package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.GlobalTimer
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FResult
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FSeed
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component

@Component
class SeedHandler {

	@StreamListener(StreamBindings.BINDING_SEED_IN)
	@SendTo(StreamBindings.BINDING_RESULT_OUT)
	fun handleSeed(seed: FSeed): FResult {
		GlobalTimer.startIfNot()
		println("$seed ... calculating")
		return FCalculator.calc(seed)
	}
}
