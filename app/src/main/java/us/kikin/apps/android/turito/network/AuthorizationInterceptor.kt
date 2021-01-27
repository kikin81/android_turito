package us.kikin.apps.android.turito.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().signedRequest()
        return chain.proceed(request)
    }

    /**
     * Private extension function to sign the request
     */
    private fun Request.signedRequest(): Request {
        // TODO: never do this in production!!
        val apiKey =
            "a26i9O_QgtMUS7UMFVJsshYoGAudWrngTUirvjD021qSohvOWnSSNYlcZFQwarW3Y_oQo5XOWLBswEPXjqjQYTYW5QWmki4swjb5CcHr293ByS7woi1o12Wl_skRYHYx"
        return newBuilder()
            .header("Authorization", "Bearer $apiKey")
            .build()
    }
}
