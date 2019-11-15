package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FactorialResult
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FactorialSeed
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Service

@Service
class SeedHandler {

	@StreamListener(FactorialStreams.TOPIC_SEED)
	@SendTo(FactorialStreams.TOPIC_RESULT)
	fun handleSeed(seed: FactorialSeed): FactorialResult {
		println("received... $seed ... producing result")
		return FactorialResult(seed)
	}
}
