package org.marsstudio.learn.design;

public class SsoInterception implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        String ticket = request.substring(1, 8);
        return ticket.equals("success");
    }
}
