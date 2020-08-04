package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
    @Before(value = "execution(* services.EmployeeService.createEmployee(..)) and args(name,empId)")
    public void beforeAdvice(JoinPoint joinPoint, String name, String empId){
        System.out.println("Before method:" + joinPoint.getSignature());

        System.out.println("Creating Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(* services.EmployeeService.createEmployee(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        System.out.println("After method:" + joinPoint.getSignature());

        System.out.println("Successfully created Employee with name - " + name + " and id - " + empId);
    }

    @AfterReturning(pointcut = "execution(* services.EmployeeService.createEmployee(..))", returning = "retVal"	)
    public void afterReturning(Object retVal){
		System.out.println("Return value is " + retVal);
    }

    @AfterThrowing(pointcut = "execution(* services.EmployeeService.throwException(..))", throwing = "ex")
	public void afterException(Exception ex){
		System.out.println("Get exception");
	}
}
