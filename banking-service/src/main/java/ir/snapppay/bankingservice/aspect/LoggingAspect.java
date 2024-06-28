package ir.snapppay.bankingservice.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.snapppay.bankingservice.domain.RequestResponseLogEntity;
import ir.snapppay.bankingservice.repository.RequestResponseLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {

    private final ObjectMapper objectMapper;
    private final RequestResponseLogRepository requestResponseLogRepository;

    @Pointcut("execution(* ir.snapppay.bankingservice.controller.BankingServicesController.*(..))")
    private void interceptRequiredControllerMethods() {
    }

    @Around("interceptRequiredControllerMethods()")
    public Object logAroundControllerMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Object[] args = proceedingJoinPoint.getArgs();

        Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("new request received for uri :" + request.getRequestURI());

        // proceed with method execution in here
        Object proceedResult = proceedingJoinPoint.proceed();

        requestResponseLogRepository.save(RequestResponseLogEntity.builder()
                .clientId(principal.getSubject())
//                .clientId("get from JWT") // in test environment when we dont want to have A@A with oAuth2
                .requestParamsJson(objectMapper.writeValueAsString(args))
                .requestCompilationTime(LocalDateTime.now())
                .requestUri(request.getRequestURI())
                .responseParamsJson(objectMapper.writeValueAsString(proceedResult))
                .build());

        log.info(request.getRequestURI() + " request completed!");
        return proceedResult;
    }
}
