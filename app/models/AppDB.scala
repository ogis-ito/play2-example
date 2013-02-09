package models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema

object AppDB extends Schema {

  val customerTable = table[Customer]("T_CUSTOMER")
  val orderTable = table[Order]("T_ORDER")
  val orderDetailTable = table[OrderDetail]("T_ORDER_DETAIL")

  val customerToOrderRelation =
    oneToManyRelation(customerTable, orderTable).
    via((c, o) => c.id === o.customerId)
  val orderToDetailRelation =
    oneToManyRelation(orderTable, orderDetailTable).
    via((o, d) => o.id === d.orderId)
}
