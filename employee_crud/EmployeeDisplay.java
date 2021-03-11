package employee_crud;

import java.util.ArrayList;

public class EmployeeDisplay {

	private UserIO io;

	public EmployeeDisplay(UserIO io) {
		this.io = io;
	}

	public int displayAndReturnMenuOptions() {

		io.print("===Employee ArrayList DataBase===\n");
		io.print("1. Add an employee to the database");
		io.print("2. Access an employee info from the database");
		io.print("3. Update an employee info in the database");
		io.print("4. Remove an employee from the database");
		io.print("5. Display all employee info");
		io.print("6. EXIT");

		return io.readInt("Please Select from the above choices", 1, 6);
	}

	// option 1 Add new Employee
	public void displayAddNewEmployee() {
		io.print("==ADD New Employee==");
	}

	public Employee getNewEmployeeInfo(int id) {
		String name = io.readString("Type New Employees Name");
		String title = io.readString("Type Employees Title");
		double salary = io.readDouble("type in the employees Salary");
		Employee emp = new Employee(id, name, title, salary);
		return emp;
	}

	// option 2
	public int searchEmployee() {
		io.print("===Search Employee===");
		return io.readInt("Please enter an Employee Id");
	}
	
	public void displayEmployee(Employee e) {
		if (e != null) {
			double salary = e.getSalary();
			String dSalary = String.format("%.2f", salary);
			System.out.printf("%-10s %-10s %-20s %-10s\n", "Id", "Name", "Title", "Salary");
			String empInfo = String.format("%-10d %-10s %-20s %-10s", e.getId(), e.getName(), e.getTitle(), dSalary);

			io.print(empInfo);

		} else {
			io.print("No Employee by that ID, sorry.");
		}
		io.readString("Please hit enter to continue.");
	}
	
	//option 3
	public int editEmployeeBanner() {
		io.print("===Edit Employee===");
		return io.readInt("Please enter an Employee Id");
	}
	
	public int editMenu(){
		io.print("===Employee Edit===\n");
		io.print("1. Edit Name");
		io.print("2. Edit Title");
		io.print("3. Edit Salary");
		io.print("4. Remove an employee from the database");
		io.print("5. Display all employee info");
		io.print("6. EXIT");

		return io.readInt("Please Select from the above choices", 1, 6);
	}
	
//	public Employee editEmployee() {
//		
//	}
	
	//option 4
	public int displayRemoveEmployee() {
		io.print("===Remove Employee===");
		return io.readInt("Please enter an Employee Id");
	}
	
	public void succesfullyRemovedEmployee() {
		io.print("Successfully Removed Employee");
	}
	public void failedToRemoveEmployee() {
		io.print("That Employee does not exist");
	}
	
	

	// option 5
	public void displayAllEmployees(ArrayList<Employee> emps) {
		System.out.printf("%-10s %-10s %-20s %-10s\n", "Id", "Name", "Title", "Salary");
		for (Employee e : emps) {
			double salary = e.getSalary();
			String dSalary = String.format("%.2f", salary);
			String empInfo = String.format("%-10d %-10s %-20s %-10s", e.getId(), e.getName(), e.getTitle(), dSalary);

			io.print(empInfo);
		}
		io.readString("Please hit enter to continue.");
	}

	// option 6
	public void displayExitBanner() {
		io.print("Exiting Employee DataBase");
	}
}
