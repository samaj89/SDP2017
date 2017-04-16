package proxy.virtualproxy

import scala.collection.mutable.ListBuffer

class ContactListProxyImpl extends ContactList {

  private var contactList: ContactList = _

  override def employeeList: ListBuffer[Employee] = {
    println("Creating contact list and fetching list of employees...")
    contactList = new ContactListImpl
    contactList.employeeList
  }

}
