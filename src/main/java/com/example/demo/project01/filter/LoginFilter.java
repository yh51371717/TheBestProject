package com.example.demo.project01.filter;

import com.example.demo.project01.dao.UserDao;
import com.example.demo.project01.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Autowired
    private UserDao userDao;

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");


        // 获取请求头中的参数
        HttpServletRequest request= (HttpServletRequest) req;
        String token = request.getHeader("token");

        String redisToken = token == null? "":token;
        //查询Redis中的剩余时间是否大于0
        Long expire = redisTemplate.getExpire(redisToken);

        if (expire>0){
            //如果用户已登录 但是浏览时间过长 为了避免Token失效 我们在用户登录后重置他的Token时长

            redisTemplate.expire(token,30L, TimeUnit.MINUTES);  //key  时长 单位
            chain.doFilter(req, resp);
        }else {

            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect("/templates/Welcome.html");
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        System.out.println("仅用于查看是否过滤");
    }

}
