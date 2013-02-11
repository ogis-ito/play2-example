package models

import java.util.Date

import play.api.test._
import play.api.test.Helpers._

import org.specs2.mutable._
import org.squeryl.PrimitiveTypeMode.inTransaction

class OrderSpec extends Specification {

  "Order" should {
    "be persistable" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        inTransaction {
          val order = Order.persist(Order(new Date(), 101))
          order.id must be_>(0L)
        }
      }
    }
    "be findable" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        inTransaction {
          val order = Order.find(310).get
          order.id must equalTo(310)
          order.customerId must equalTo(101)
          
          val customer = order.customer
          customer.id must equalTo(101)
          customer.name must equalTo("鈴木 一郎")
          
          val details = order.details
          details.length must equalTo(2)
          
          details(0).id must equalTo(311)
          details(0).orderId must equalTo(order.id)
          details(0).productId must equalTo(201)
          details(0).quantity must equalTo(2)
          details(0).amount must equalTo(6400 * 2)
          
          details(1).id must equalTo(312)
          details(1).orderId must equalTo(order.id)
          details(1).productId must equalTo(202)
          details(1).quantity must equalTo(3)
          details(1).amount must equalTo(2400 * 3)
          
          order.totalAmount must equalTo(6400 * 2 + 2400 * 3)
        }
      }
    }
  }
}
