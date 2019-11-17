package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.GlobalTimer
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FResult
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class ResultHandler {

	@StreamListener(StreamBindings.BINDING_RESULT_IN)
	fun handleResult(@Payload result: FResult) {
		GlobalTimer.startIfNot()
		println("... $result elapsed=" + GlobalTimer.elapsedSec())
	}
}
