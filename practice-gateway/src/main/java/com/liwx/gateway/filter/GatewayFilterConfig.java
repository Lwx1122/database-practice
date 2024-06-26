package com.liwx.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

//@Component
//@Slf4j
//public class GatewayFilterConfig implements GlobalFilter, Ordered {
//
//
//    @Autowired
//    private TokenStore tokenStore;
//
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String requestUrl = exchange.getRequest().getPath().value();
//        AntPathMatcher pathMatcher = new AntPathMatcher();
//        //1 uaa服务所有放行
//        if (pathMatcher.match("/oauth/**", requestUrl)) {
//            return chain.filter(exchange);
//        }
//        //2 检查token是否存在
//        String token = getToken(exchange);
//        if (StringUtils.isBlank(token)) {
//            return noTokenMono(exchange);
//        }
//        //3 判断是否是有效的token
//        OAuth2AccessToken oAuth2AccessToken;
//        try {
//            oAuth2AccessToken = tokenStore.readAccessToken(token);
//            Map<String, Object> additionalInformation = oAuth2AccessToken.getAdditionalInformation();
////            //取出用户身份信息
////            String principal = MapUtils.getString(additionalInformation, "user_name");
////            //获取用户权限
////            List<String> authorities = (List<String>) additionalInformation.get("authorities");
////            JSONObject jsonObject=new JSONObject();
////            jsonObject.put("principal",principal);
////            jsonObject.put("authorities",authorities);
////            //给header里面添加值
////            String base64 = EncryptUtil.encodeUTF8StringBase64(jsonObject.toJSONString());
////            ServerHttpRequest tokenRequest = exchange.getRequest().mutate().header("json-token", base64).build();
//            ServerWebExchange build = exchange.mutate().request(tokenRequest).build();
//            return chain.filter(build);
//        } catch (InvalidTokenException e) {
//            log.info("无效的token: {}", token);
//            return invalidTokenMono(exchange);
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }
//
//
//    /**
//     * 获取token
//     */
//    private String getToken(ServerWebExchange exchange) {
//        String tokenStr = exchange.getRequest().getHeaders().getFirst("Authorization");
//        if (StringUtils.isBlank(tokenStr)) {
//            return null;
//        }
//        String token = tokenStr.split(" ")[1];
//        if (StringUtils.isBlank(token)) {
//            return null;
//        }
//        return token;
//    }
//
//
//    /**
//     * 无效的token
//     */
//    private Mono<Void> invalidTokenMono(ServerWebExchange exchange) {
//        JSONObject json = new JSONObject();
//        json.put("status", HttpStatus.UNAUTHORIZED.value());
//        json.put("data", "无效的token");
//        return buildReturnMono(json, exchange);
//    }
//
//    private Mono<Void> noTokenMono(ServerWebExchange exchange) {
//        JSONObject json = new JSONObject();
//        try {
//            json.put("status", HttpStatus.UNAUTHORIZED.value());
//            json.put("data", "没有token");
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//
//        return buildReturnMono(json, exchange);
//    }
//
//
//    private Mono<Void> buildReturnMono(JSONObject json, ServerWebExchange exchange) {
//        ServerHttpResponse response = exchange.getResponse();
//        byte[] bits = json.toJSONString().getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = response.bufferFactory().wrap(bits);
//        response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        //指定编码，否则在浏览器中会中文乱码
//        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
//        return response.writeWith(Mono.just(buffer));
//    }
//
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}