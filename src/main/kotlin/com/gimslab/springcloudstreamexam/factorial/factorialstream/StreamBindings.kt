package com.gimslab.springcloudstreamexam.factorial.factorialstream

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface StreamBindings {
	companion object {
		const val BINDING_SEED_OUT = "factorial-seed-out"
		const val BINDING_SEED_IN = "factorial-seed-in"
		const val BINDING_RESULT_OUT = "factorial-result-out"
		const val BINDING_RESULT_IN = "factorial-result-in"
		const val BINDING_SEED_TO_SPLIT_IN = "factorial-seed-to-split-in"
		const val BINDING_SPLITTED_RESULT_OUT = "factorial-splitted-result-out"
	}

	@Output(BINDING_SEED_OUT)
	fun outputSeed(): MessageChannel

	@Input(BINDING_SEED_IN)
	fun inputSeed(): SubscribableChannel

	@Output(BINDING_RESULT_OUT)
	fun outputResult(): MessageChannel

	@Input(BINDING_RESULT_IN)
	fun inputResult(): SubscribableChannel

	@Input(BINDING_SEED_TO_SPLIT_IN)
	fun inputSeedToSplit(): SubscribableChannel

	@Output(BINDING_SPLITTED_RESULT_OUT)
	fun outputSplittedResult(): MessageChannel
}