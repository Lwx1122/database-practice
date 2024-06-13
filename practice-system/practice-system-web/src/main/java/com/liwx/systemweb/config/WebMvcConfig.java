package com.liwx.systemweb.config;

/**
 * @ClassName WebMvcConfig
 * @Author Liwx
 */
//@Configuration
//@Order(100)
//public class WebMvcConfig implements WebMvcConfigurer {
//    //@Autowired
//    PatternsConfig mPatterns;
//
//    // @Autowired
//    MyFilter mMyFilter;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns(
//                        mPatterns.getDetail()
//                );
//    }
//
//    @Bean
//    FilterRegistrationBean<MyFilter> loginFilter() {
//        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(mMyFilter);
//        registrationBean.addUrlPatterns("/**");
//        if (!CollectionUtils.isEmpty(mPatterns.getDetail())) {
//            Map<String, String> collect = mPatterns.getDetail().stream()
//                    .collect(Collectors.toMap(e -> String.valueOf(new Random().nextInt()),
//                                              String::valueOf));
//            registrationBean.setInitParameters(collect);
//        }
//        return registrationBean;
//    }
//}
