package com.gimslab.springcloudstreamexam.factorial.factorialstream.dto

data class FResult(
		val seed: Int,
		val fac: Int
) {
	constructor() : this(0, 1)
}
