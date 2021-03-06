package com.github.scribejava.apis;

import com.github.scribejava.apis.facebook.FacebookAccessTokenJsonExtractor;
import com.github.scribejava.core.builder.api.ClientAuthenticationType;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.extractors.TokenExtractor;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Verb;

/**
 * Facebook v2.8 API
 */
public class FacebookApi extends DefaultApi20 {

    protected FacebookApi() {
    }

    private static class InstanceHolder {

        private static final FacebookApi INSTANCE = new FacebookApi();
    }

    public static FacebookApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.GET;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return "https://graph.facebook.com/v2.8/oauth/access_token";
    }

    @Override
    public String getRefreshTokenEndpoint() {
        throw new UnsupportedOperationException("Facebook doesn't support refershing tokens");
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        return "https://www.facebook.com/v2.8/dialog/oauth";
    }

    @Override
    public TokenExtractor<OAuth2AccessToken> getAccessTokenExtractor() {
        return FacebookAccessTokenJsonExtractor.instance();
    }

    @Override
    public ClientAuthenticationType getClientAuthenticationType() {
        return ClientAuthenticationType.REQUEST_BODY;
    }
}
