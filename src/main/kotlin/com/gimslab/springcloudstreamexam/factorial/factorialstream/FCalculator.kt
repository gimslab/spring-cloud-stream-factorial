package com.gimslab.springcloudstreamexam.factorial.factorialstream

import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FResult
import com.gimslab.springcloudstreamexam.factorial.factorialstream.dto.FSeed

object FCalculator {
	fun calc(seed: FSeed): FResult {
		return FResult(seed.number, factorial(seed.number))
	}

	fun factorial(seed: Int): Int {
		if (seed < 0)
			throw IllegalArgumentException()
		if (seed == 0)
			return 1
		var sum = 1
		for (n in 1..seed) {
			sum *= n
			Thread.sleep(n * 5L)
		}
		return sum;
	}
}
