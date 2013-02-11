package models

import org.squeryl.PrimitiveTypeMode._

object Customer {

  def persist(customer: Customer): Customer = {
    inTransaction {
      AppDB.customerTable.insert(customer)
    }
  }

  def update(customer: Customer) {
    inTransaction {
      AppDB.customerTable.update(customer)
    }
  }

  def remove(id: Long) {
    inTransaction {
      AppDB.customerTable.deleteWhere(c => c.id === id)
    }
  }

  def findAll(): List[Customer] = {
    inTransaction {
      from(AppDB.customerTable)(c =>
        select(c)
      ).toList
    }
  }
}

case class Customer(
  name: String,
  address: Option[String])
  extends EntityBase {
}
