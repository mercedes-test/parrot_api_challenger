package com.mx.api.parrot.challenger.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@RefreshScope
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;


	@Value("${config.security.oauth.client.id}")
	private String clientId;

	@Value("${config.security.oauth.client.secret}")
	private String clientSecret;

	@Value("${config.security.oauth.jwt.key}")
	private String jwtKey;

	public static final String PASSWORD = "password";

	public static final String GRANT_TYPE_PASSWORD = "password";
	public static final String REFRESH_TOKEN = "refresh_token";

	public static final String SCOPE_READ = "read";
	public static final String SCOPE_WRITE = "write";

	public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	public static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 1 * 60 * 60;
	

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clientId).secret(clientSecret).scopes(SCOPE_READ, SCOPE_WRITE)
				.authorizedGrantTypes(PASSWORD, REFRESH_TOKEN).accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter()));

		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(accessTokenConverter()).tokenEnhancer(tokenEnhancerChain);
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(jwtKey);
		return tokenConverter;
	}
}
