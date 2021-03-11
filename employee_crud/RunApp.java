package employee_crud;

public class RunApp {

	public static void main(String[] args) {
		
        UserIO myIo = new UserIOConsoleImpl();
        EmployeeDisplay myDisplay=new EmployeeDisplay(myIo);
        EmployeeApp myDao = new EmployeeApp();
        EmployeeController controller= new EmployeeController(myDao, myDisplay);

        controller.run();
	}

}
