package com.gimslab.springcloudstreamexam.factorial.factorialstream.dto

class FactorialResult(val seed: FactorialSeed?) {
	constructor() : this(null)

	override fun toString(): String {
		return "R(S" + seed?.seed + ")"
	}
}
