package com.gimslab.springcloudstreamexam.factorial

import com.gimslab.springcloudstreamexam.factorial.factorialstream.StreamBindings
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FSeed
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.messaging.support.MessageBuilder
import java.lang.System.currentTimeMillis

@SpringBootApplication
@EnableBinding(StreamBindings::class)
class SpringCloudStreamFactorialApplication(
		val streamBindings: StreamBindings
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		if (args.size > 0 && "seed".equals(args[0]))
			produceSeeds();
	}

	private fun produceSeeds() {
		for (i in 1..12) {
			streamBindings.outputSeed().send(
					MessageBuilder.withPayload(FSeed(i)).build())
		}
	}
}

object GlobalTimer {

	private var startedAt = -1L

	fun startIfNot() {
		if (startedAt > 0)
			return
		startedAt = currentTimeMillis()
		println("TIMER startedAt: $startedAt")
	}

	fun elapsedSec(): Long {
		return (currentTimeMillis() - startedAt) / 1000L
	}
}

fun main(args: Array<String>) {
	runApplication<SpringCloudStreamFactorialApplication>(*args)
}

