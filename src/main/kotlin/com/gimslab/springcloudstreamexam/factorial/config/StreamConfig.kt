package com.gimslab.springcloudstreamexam.factorial.config

import com.gimslab.springcloudstreamexam.factorial.factorialstream.FactorialStreams
import org.springframework.cloud.stream.annotation.EnableBinding

@EnableBinding(FactorialStreams::class)
class StreamConfig {
}