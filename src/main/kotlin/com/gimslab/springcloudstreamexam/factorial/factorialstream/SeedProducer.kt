package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FactorialSeed
import org.springframework.messaging.MessageHeaders.CONTENT_TYPE
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON

@Service
class SeedProducer(
		val factorialStreams: FactorialStreams
) {

	fun start() {
		for (i in 0..5)
			produce(i);
	}

	fun produce(i: Int) {
		val seed = FactorialSeed(i)
		println("producing... " + seed)
		val message = MessageBuilder
				.withPayload(seed)
//				.setHeader(CONTENT_TYPE, APPLICATION_JSON)
				.build()
		factorialStreams.seedOut().send(message)
	}
}
