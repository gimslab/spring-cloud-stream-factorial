package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.GlobalTimer
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FResult
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FSeed
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.integration.annotation.Splitter
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

	@Splitter(inputChannel = StreamBindings.BINDING_SEED_TO_SPLIT_IN,
			outputChannel = StreamBindings.BINDING_SPLITTED_RESULT_OUT)
	fun handleSeedWithSplitter(seed: FSeed): List<FResult> {
		GlobalTimer.startIfNot()
		println("$seed ... calculating with splitter")
		return listOf(
				FCalculator.calc(seed),
				FCalculator.calc(seed.plus(10)))
	}
}
