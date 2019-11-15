package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FactorialResult
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.stereotype.Service

@Service
class ResultHandler {

	@StreamListener(FactorialStreams.TOPIC_RESULT)
	fun handleResult(result: FactorialResult) {
		println("------------- received. $result");
		Thread.sleep(100)
	}
}
