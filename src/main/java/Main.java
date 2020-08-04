import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.EmployeeService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("model");
        context.scan("aspects");
        context.scan("services");
        context.scan("annotations");
        context.scan("config");
        context.refresh();

        EmployeeService service = context.getBean(EmployeeService.class);
        String name = "liangchen";
        String id = "123123";
        service.createEmployee(name, id);

        try {
        	service.throwException();
		}catch (Exception ex){
			System.out.println("Exception caught");
		}
    }
}
