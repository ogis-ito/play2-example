package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

object Product {

  val product = {
    get[Long]("id") ~
    get[String]("name") ~
    get[Int]("price") map {
      case id ~ name ~ price =>
        Product(id, name, price)
    }
  }

  def persist(product: Product) {
    DB.withConnection { implicit c =>
      SQL("insert into T_PRODUCT (NAME, PRICE) values ({name}, {price})")
        .on(
          'name -> product.name,
          'price -> product.price)
        .executeUpdate()
    }
  }

  def remove(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from T_PRODUCT where id = {id}")
        .on(
          'id -> id)
        .executeUpdate()
    }
  }

  def findAll(): List[Product] = {
    DB.withConnection { implicit c =>
      SQL("select * from T_PRODUCT")
        .as(product *)
    }
  }
}

case class Product(
  id: Long,
  name: String,
  price: Int)
