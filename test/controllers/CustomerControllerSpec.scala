package controllers

import play.api.http.ContentTypes.JSON
import play.api.test._
import play.api.test.Helpers._

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.squeryl.PrimitiveTypeMode.inTransaction

import models.{AppDB, Customer}

class CustomerControllerSpec extends FlatSpec with ShouldMatchers {

  "A request to the persist action" should "respond" in {
    running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      val result = CustomerController.persist(
        FakeRequest().withFormUrlEncodedBody(
          "name" -> "Foo",
          "address" -> "bar"
        ))
      status(result) should equal (SEE_OTHER)
      redirectLocation(result) should equal (Some(routes.CustomerController.index.url))
    }
  }

}
