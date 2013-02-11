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

  def find(id: Long): Option[Order] = {
    inTransaction {
      AppDB.orderTable.where(o => o.id === id).headOption
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

  lazy val customer: Customer =
    AppDB.customerToOrderRelation.right(this).single

  lazy val details: Array[OrderDetail] =
    AppDB.orderToDetailRelation.left(this).toArray

  def totalAmount = {
    details.map(d => d.amount).reduce(_ + _)
  }
}

case class OrderDetail(
  @Column("ORDER_ID")
  orderId: Long,
  @Column("PRODUCT_ID")
  productId: Long,
  quantity: Int)
  extends EntityBase {

  lazy val order: Order =
    AppDB.orderToDetailRelation.right(this).single

  lazy val product: Product =
    Product.find(productId).get

  def amount = {
    product.price * quantity
  }
}
