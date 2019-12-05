package com.gimslab.springcloudstreamexam.factorial.factorialstream.dto

data class FSeed(val number: Int) {

	constructor() : this(0)

	fun plus(i: Int): FSeed {
		return FSeed(number + i)
	}
}
