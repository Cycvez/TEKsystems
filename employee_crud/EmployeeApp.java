package employee_crud;

import java.util.ArrayList;

public class EmployeeApp {

	private ArrayList<Employee> emps;

	public ArrayList<Employee> getEmps() {
		return emps;
	}

	public void setEmps(ArrayList<Employee> emps) {
		this.emps = emps;
	}

	public void addEmp(Employee emp) {
		emps.add(emp);
	}

	public void updateEmp(Employee emp) {
		// check if emp exist in DB already
		// if so, update existing emp info with new emp inf
		// if now, add emp to List
	}

	public Employee getEmp(int id) {
		for (Employee e : emps) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	public boolean removeEmployee(int id) {
		for (Employee e : emps) {
			if (e.getId() == id) {
				emps.remove(e);
				return true;
			}
		} return false;
	}

}
