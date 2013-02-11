package models

import play.api.test._
import play.api.test.Helpers._

import org.specs2.mutable._

class ProductSpec extends Specification {

  "Product" should {
    "be findable" in {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val product = Product.find(201).get
        product.id must equalTo(201)
        product.price must equalTo(6400)
      }
    }
  }

}
