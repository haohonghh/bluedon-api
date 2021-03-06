package com.bluedon.common.aspect;

import com.bluedon.common.exception.BDException;
import com.bluedon.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019/12/9 11:23
 * @author: hhong
 * @description: 输入参数校验。结合实体上注解使用
 **/
@Slf4j
@Aspect
@Component
public class ValidatorAspect {

    @Before("execution(public * com.bluedon.modules.*.controller..*(..))")
    public void doBefore(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    List errors = new ArrayList<>();
                    for (ObjectError error : result.getAllErrors()) {
                        errors.add(error.getDefaultMessage());
                    }
                    throw new BDException(Result.error(errors));
                }
            }
        }
    }
}