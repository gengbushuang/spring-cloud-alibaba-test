package com.dubbo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @DubboComponentScan
 * 先根据这个注解里面@Import(DubboComponentScanRegistrar.class)这个类注册2个类
 * ServiceAnnotationBeanPostProcessor.class-->注册者
 * ReferenceAnnotationBeanPostProcessor.calss-->调用者
 *
 * ServiceAnnotationBeanPostProcessor.class
 *      ServiceAnnotationBeanPostProcessor实现了BeanDefinitionRegistryPostProcessor的接口
 *      这个接口会在springboot启动的时候执行postProcessBeanDefinitionRegistry的方法
 *
 *      ServiceAnnotationBeanPostProcessor.postProcessBeanDefinitionRegistry
 *          //对要扫描的包进行检查
 *          Set<String> resolvedPackagesToScan = resolvePackagesToScan(packagesToScan);
 *          //找寻@Service注解的bean进行注册
 *          registerServiceBeans(resolvedPackagesToScan, registry);
 *              //包扫描类
 *              DubboClassPathBeanDefinitionScanner scanner = new DubboClassPathBeanDefinitionScanner(registry, environment, resourceLoader);
 *              //beanName生成器
 *              BeanNameGenerator beanNameGenerator = resolveBeanNameGenerator(registry);
 *              //把beanName生成器规则设置给扫描包类
 *              scanner.setBeanNameGenerator(beanNameGenerator);
 *              //找寻注解规则设置给扫描包类
 *              scanner.addIncludeFilter(new AnnotationTypeFilter(Service.class));
 *              //开始对包进行寻找
 *              scanner.scan(packageToScan);
 *                  doScan(basePackages);
 *                      //里面有用到AnnotationTypeFilter规则寻找
 *                      Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
 *                      //找到后把这个BeanDefinition注册到BeanDefinitionRegistry这个类里面
 *
 *              //对BeanDefinition进行装饰
 *              Set<BeanDefinitionHolder> beanDefinitionHolders =findServiceBeanDefinitionHolders(scanner, packageToScan, registry, beanNameGenerator);
 *
 *              //开始对有注解@Service进行ServiceBean注册
 *              registerServiceBean(beanDefinitionHolder, registry, scanner);
 *
 *
 *
 */

@SpringBootApplication
@DubboComponentScan
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
