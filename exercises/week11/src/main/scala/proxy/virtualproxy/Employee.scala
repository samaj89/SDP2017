package proxy.virtualproxy

case class Employee(
  var employeeName: String,
  var employeeSalary: Double,
  var employeeDesignation: String
) {

  override def toString(): String = {
  "Employee name: " + employeeName + ", EmployeeDesignation: " +
    employeeDesignation + ", Employee Salary: " + employeeSalary
  }
}
