package top.guoshihua.blog.aspect;

import com.alibaba.fastjson.JSON;
import com.github.jarod.qqwry.IPZone;
import com.github.jarod.qqwry.QQWry;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.guoshihua.blog.util.IPAddressUtils;
import top.guoshihua.blog.util.IPSeeker;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName WebLogAspect
 * @Description: TODO
 * @Author guoshihua
 * @Date 2020/8/5 0005 上午 8:31
 * @Version V1.0
 * @See 版权声明
 **/
@Component
@Aspect
public class WebLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);
//    @Autowired
//    private QQWry qqWry;
//    @Autowired
//    private IPSeeker ipSeeker;
    @Autowired
    private IPAddressUtils ipAddressUtils;

    @Pointcut("execution(public * top.guoshihua.blog.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

//    @Pointcut("execution(public * top.guoshihua.blog.uiController..*.*(..))")//切入点描述，这个是uiController包的切入点
//    public void uiControllerLog(){}

//    @Before("controllerLog() || uiControllerLog()") //在切入点的方法run之前要干的
    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint) throws IOException {

        //这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        // 浏览器信息
        String userAgent = request.getHeader("User-Agent");
        // ip
        String remoteAddr = request.getRemoteAddr();
        String ip = getRemoteHost(request);
        System.out.println(ip);
//        IPZone ipzone = qqWry.findIP(ip);
//        String ipAddress = ipzone.getMainInfo(); // ip地址
//        String networkOperatorsName = ipzone.getSubInfo(); // 网络运营商名称

        String ipAddress = ipAddressUtils.getIPLocation(ip).getCountry();
        String networkOperatorsName = ipAddressUtils.getIPLocation(ip).getArea();

        // 请求url
        String requestUrl = request.getRequestURL().toString();
        // 跳转页面url
        String refererUrl = request.getHeader("Referer");
        // http 请求方式
        String method = request.getMethod();
        // 参数map
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        String args = Arrays.toString(joinPoint.getArgs());
        // controller包名+类名
        String packageClassName = joinPoint.getSignature().getDeclaringTypeName();
        // controller方法名
        String classMethodName = joinPoint.getSignature().getName();
        String referenceMethod = packageClassName + "." + classMethodName;
        LOGGER.info("{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}", ip, ipAddress, networkOperatorsName, "-", userAgent,
                requestUrl, refererUrl, method, args, referenceMethod);

        // 记录下请求内容
//        LOGGER.info("################URL : " + request.getRequestURL().toString());
//        LOGGER.info("################HTTP_METHOD : " + request.getMethod());
//        LOGGER.info("################IP : " + request.getRemoteAddr());
//        LOGGER.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
//        LOGGER.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("################THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

    }

    /**
     * 获取真实ip地址
     * @param request
     * @return
     */
    public String getRemoteHost(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || StringUtils.equalsIgnoreCase("unknown", ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || StringUtils.equalsIgnoreCase("unknown", ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || StringUtils.equalsIgnoreCase("unknown", ip)){
            //HTTP_CLIENT_IP：有些代理服务器
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || StringUtils.equalsIgnoreCase("unknown", ip)){
            //X-Real-IP：nginx服务代理
            ip = request.getHeader("X-Real-IP");
        }
        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ip != null && ip.length() != 0) {
            ip = ip.split(",")[0];
        }
        if(ip == null || ip.length() == 0 || StringUtils.equalsIgnoreCase("unknown", ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }
}
