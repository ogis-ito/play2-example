package models

import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._

object Customer {

  def findAll(): List[Customer] = {
    inTransaction {
      from(AppDB.customerTable)(c =>
        select(c)
      ).toList
    }
  }

  def persist(customer: Customer) {
    inTransaction {
      AppDB.customerTable.insert(customer)
    }
  }

  def remove(id: Long) {
    inTransaction {
      AppDB.customerTable.deleteWhere(t => t.id === id)
    }
  }

}

case class Customer(
  name: String,
  address: Option[String])
  extends KeyedEntity[Long] {

  val id: Long = 0

}
