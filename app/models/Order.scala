package models

import java.util.Date

import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.annotations.Column
import org.squeryl.dsl._

object Order {

  def persist(order: Order): Order = {
    inTransaction {
      AppDB.orderTable.insert(order)
    }
  }

  def update(order: Order) {
    inTransaction {
      AppDB.orderTable.update(order)
    }
  }

  def remove(id: Long) {
    inTransaction {
      AppDB.orderTable.deleteWhere(o => o.id === id)
    }
  }

  def findAll(): List[Order] = {
    inTransaction {
      from(AppDB.orderTable)(o =>
        select(o)
      ).toList
    }
  }
}

case class Order(
  @Column("ORDER_DATE")
  orderDate: Date,
  @Column("CUSTOMER_ID")
  customerId: Long)
  extends EntityBase {

  lazy val customer: ManyToOne[Customer] =
    AppDB.customerToOrderRelation.right(this)

  lazy val details: OneToMany[OrderDetail] =
    AppDB.orderToDetailRelation.left(this)
}

case class OrderDetail(
  @Column("ORDER_ID")
  orderId: Long,
  @Column("PRODUCT_ID")
  productId: Long,
  quantity: Int)
  extends EntityBase {

  lazy val order: ManyToOne[Order] =
    AppDB.orderToDetailRelation.right(this)
}
