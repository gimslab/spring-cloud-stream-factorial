package com.gimslab.springcloudstreamexam.factorial.factorialstream

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest
import org.springframework.cloud.stream.endpoint.BindingsEndpoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration(proxyBeanMethods = false)
class ActuatorSecurityConfiguration(

		@Value("\${spring.security.user1.username}")
		val user1username: String,
		@Value("\${spring.security.user1.password}")
		val password: String

) : WebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity?) {
		if (http == null)
			return
		http.csrf().disable()
				.authorizeRequests()
				.requestMatchers(EndpointRequest.to(BindingsEndpoint::class.java))
				.hasRole("ADMIN")
				.and()
				.httpBasic()
	}

	@Bean
	override fun userDetailsService(): UserDetailsService {
		val user = User.withDefaultPasswordEncoder()
				.username(user1username)
				.password(password)
				.roles("ADMIN")
				.build()
		return InMemoryUserDetailsManager(user)
	}
}