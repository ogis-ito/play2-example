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

  def remove(id: Long) {
    
  }

}

case class Customer(
  name: String,
  address: Option[String])
  extends KeyedEntity[Long] {

  val id: Long = 0

}
