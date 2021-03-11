package employee_crud;

import java.util.ArrayList;

public class EmployeeController {

	private EmployeeDisplay display;
	private EmployeeApp dao;

	public EmployeeController(EmployeeApp dao, EmployeeDisplay display) {
		this.dao = dao;
		this.display = display;
	}

	private void fillListOfEmployees() {

		Employee e1 = new Employee(101, "Young", "Intern", 25000);
		Employee e2 = new Employee(223, "Elijah", "Senior Manager", 85000);
		Employee e3 = new Employee(201, "Gerald", "Software Engineer", 90000);
		Employee e4 = new Employee(150, "Jean", "CEO", 300000);

		ArrayList<Employee> initialData = new ArrayList<Employee>();
		initialData.add(e1);
		initialData.add(e2);
		initialData.add(e3);
		initialData.add(e4);

		dao.setEmps(initialData);
	}

	public void run() {

		fillListOfEmployees();
		boolean runEmployeeDB = true;
		int menuSelection = 0;

		while (runEmployeeDB) {
			menuSelection = getMenuSelection();

			switch (menuSelection) {
			case 1:
				addNewEmployee();
				break;
				
			case 2:
				searchEmployeeById();
				break;
				
			case 3:
				break;

			case 4:
				removeEmployeeById();
				break;
			
			case 5:
				displayAllEmployees();
				break;
				
			case 6:
				runEmployeeDB = false;
				break;
			default:

			}

		}
		exitMessage();

	}

	private int getMenuSelection() {
		return display.displayAndReturnMenuOptions();
	}

	private void exitMessage() {
		display.displayExitBanner();
	}

	
	// option 1 Add new Employee
	private void addNewEmployee() {
		display.displayAddNewEmployee();
		int newId = newId();
		Employee newEmployee = display.getNewEmployeeInfo(newId);
		dao.addEmp(newEmployee);
	}

	private int newId() {
		int lastId = 0;
		for (Employee e : dao.getEmps()) {
			if (e.getId() > lastId) {
				lastId = e.getId()+1;
			}
		}
		return lastId;
	}
	
	//option 2
	private void searchEmployeeById() {
		int id=display.searchEmployee();
		Employee e = dao.getEmp(id);
		display.displayEmployee(e);
	}
	
	//option 3 
	private void editEmployee() {
		int id = display.editEmployeeBanner();
		Employee e = dao.getEmp(id);
		
		boolean editting=true;
		int editMenu=0;
		
		while (editting) {
			editMenu = display.menuSelection();

			switch (menuSelection) {
			case 1:
				addNewEmployee();
				break;
				
			case 2:
				searchEmployeeById();
				break;
				
			case 3:
				break;

			case 4:
				removeEmployeeById();
				break;
			
			case 5:
				displayAllEmployees();
				break;
				
			case 6:
				runEmployeeDB = false;
				break;
			default:

			}

		}
		
	}
	
	//option 4
	private void removeEmployeeById() {
		int id= display.displayRemoveEmployee();
		if(dao.removeEmployee(id)) {
			display.succesfullyRemovedEmployee();
		}else {
			display.failedToRemoveEmployee();
		}
		
	}

	// option 5
	private void displayAllEmployees() {
		display.displayAllEmployees(dao.getEmps());
	}
}
