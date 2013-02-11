package controllers

import play.api.test._
import play.api.test.Helpers._

import org.specs2.mutable._
import org.squeryl.PrimitiveTypeMode.inTransaction

import models.{AppDB, Customer}

class CustomerControllerSpec extends Specification {

  "Persist request" should {
    "respond" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val result = CustomerController.persist(
          FakeRequest().withFormUrlEncodedBody(
            "name" -> "Foo",
            "address" -> "bar"
          ))
        status(result) must equalTo(SEE_OTHER)
        redirectLocation(result) must
          beSome(routes.CustomerController.index.url)
      }
    }
  }
}
