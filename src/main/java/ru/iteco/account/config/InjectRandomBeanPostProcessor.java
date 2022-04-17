package ru.iteco.account.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.iteco.account.model.annotation.InjectRandom;

import java.lang.reflect.Field;

@Component
public class InjectRandomBeanPostProcessor implements BeanPostProcessor {
    private static int getRandom(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beanName:" + beanName + "; beanClass: " + bean.getClass().getSimpleName());
        for (Field declaredField : bean.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(InjectRandom.class)) {
                declaredField.setAccessible(true);
                InjectRandom annotation = declaredField.getAnnotation(InjectRandom.class);
                int random = getRandom(annotation.min(), annotation.max());
                System.out.println("Set random value in " + declaredField.getName() + "; Value:" + random);
                ReflectionUtils.setField(declaredField, bean, random);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
