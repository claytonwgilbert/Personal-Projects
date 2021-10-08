export default {
 //Used to configure Okta for security
    oidc: {
        clientId: '0oa242hpneoIzfWon5d7',
        issuer: 'https://dev-22845289.okta.com/oauth2/default', //communicated with to receive security tokens
        redirectUri: 'http://localhost:4200/login/callback', //after login, redirect here
        scopes: ['openid', 'profile', 'email']

    }
}
