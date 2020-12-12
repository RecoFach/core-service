package ml.recofach.core.filter

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.User
import ml.recofach.core.security.SecurityConstants
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.Date
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(authenticationManager: AuthenticationManager) : UsernamePasswordAuthenticationFilter() {
    private val authManager: AuthenticationManager

    init {
        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL)
        authManager = authenticationManager
    }

    override fun attemptAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse?
    ): Authentication {
        try {
            val creds = jacksonObjectMapper()
                .readValue<ml.recofach.core.request.UserR>(request.inputStream)


            return authManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    creds.username,
                    creds.password,
                    ArrayList()
                )
            )
        } catch (e: IOException) {
            throw AuthenticationServiceException(e.message)
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
        authentication: Authentication
    ) {

        val user = authentication.principal as User

        val signingKey = SecurityConstants.JWT_SECRET.toByteArray()
        // Default = 172800000ms = 2 Days
        val tokenLiveTime = 172800000

        val token = Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
            .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
            .setIssuer(SecurityConstants.TOKEN_ISSUER)
            .setAudience(SecurityConstants.TOKEN_AUDIENCE)
            .setSubject(user.username)
            .setExpiration(Date(System.currentTimeMillis() + tokenLiveTime))
            .compact()

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token)
    }
}