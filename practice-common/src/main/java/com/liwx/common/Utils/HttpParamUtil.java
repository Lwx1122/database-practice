package com.liwx.common.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HttpParamUtil {

    /**
     * Gets parameters from HttpServletRequest.
     * @param request The HttpServletRequest object.
     * @return A map of parameter names and values.
     */
    public static Map<String, String> getParamsFromRequest(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        request.getParameterMap().forEach((key, value) -> params.put(key, value.length > 0 ? value[0] : ""));
        return params;
    }

    /**
     * Gets a specific parameter from HttpServletRequest.
     * @param request The HttpServletRequest object.
     * @param paramName The name of the parameter to retrieve.
     * @return An Optional containing the parameter value if present.
     */
    public static Optional<String> getParamFromRequest(HttpServletRequest request, String paramName) {
        return Optional.ofNullable(request.getParameter(paramName));
    }

    /**
     * Gets parameters from a URL.
     * @param url The URL string.
     * @return A map of parameter names and values.
     */
    public static Map<String, String> getParamsFromUrl(String url) {
        Map<String, String> params = new HashMap<>();
        String[] urlParts = url.split("\\?");
        if (urlParts.length > 1) {
            String query = urlParts[1];
            for (String param : query.split("&")) {
                String[] pair = param.split("=");
                if (pair.length > 1) {
                    params.put(pair[0], pair[1]);
                } else {
                    params.put(pair[0], "");
                }
            }
        }
        return params;
    }
}
