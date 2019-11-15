package com.gimslab.springcloudstreamexam.factorial.factorialstream.dto

class FactorialSeed(val seed: Int?) {
	constructor() : this(0)

	override fun toString(): String {
		return "S" + seed
	}
}
