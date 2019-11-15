package com.gimslab.springcloudstreamexam.factorial

import com.gimslab.springcloudstreamexam.factorial.factorialstream.SeedProducer
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudStreamFactorialApplication(
		val seedProducer: SeedProducer) : CommandLineRunner {

	override fun run(vararg args: String?) {
		seedProducer.start()
	}
}

fun main(args: Array<String>) {
	runApplication<SpringCloudStreamFactorialApplication>(*args)
}

