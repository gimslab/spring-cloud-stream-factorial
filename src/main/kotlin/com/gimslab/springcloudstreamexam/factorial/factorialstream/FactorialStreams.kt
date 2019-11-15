package com.gimslab.springcloudstreamexam.factorial.factorialstream

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface FactorialStreams {
	companion object {
		const val TOPIC_SEED = "factorial-seed"
		const val TOPIC_RESULT = "factorial-result"
	}

	@Output(TOPIC_SEED)
	fun seedOut(): MessageChannel

	@Input(TOPIC_RESULT)
	fun resultIn(): SubscribableChannel

	@Output(TOPIC_RESULT)
	fun resultOut(): MessageChannel
}