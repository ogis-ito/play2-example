package models

import play.api.test._
import play.api.test.Helpers._

import org.specs2.mutable._
import org.squeryl.PrimitiveTypeMode.inTransaction

class CustomerSpec extends Specification {

  "Customer" should {
    "be persistable" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        inTransaction {
          var customer = Customer.persist(Customer("Foo", Some("Bar")))
          customer.id must be_>(0L)
          customer.name must equalTo("Foo")
          customer.address must beSome("Bar")
        }
      }
    }
  }
}
