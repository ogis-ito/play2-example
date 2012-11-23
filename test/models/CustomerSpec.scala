package models

import play.api.test._
import play.api.test.Helpers._

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.squeryl.PrimitiveTypeMode.inTransaction

class CustomerSpec extends FlatSpec with ShouldMatchers {

  "A customer" should "be creatable" in {
    running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      inTransaction {
        var customer = AppDB.customerTable insert Customer("Foo", Some("Bar"))
        customer.id should not equal(0)
      }
    }
  }

}
