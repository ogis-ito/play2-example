package controllers

import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

import models.Product

object ProductController extends Controller {

  val productForm = Form(
    tuple(
      "name" -> nonEmptyText,
      "price" -> number
    )
  )

  def index = Action {
    Ok(views.html.product(Product.findAll(), productForm))
  }

  def persist = Action { implicit request =>
    productForm.bindFromRequest.fold(
      errors =>
        BadRequest(views.html.product(Product.findAll(), errors)),
      values => {
        Product.persist(Product(0, values._1, values._2))
        Redirect(routes.ProductController.index)
      }
    )
  }

  def remove(id: Long) = Action {
    Product.remove(id)
    Redirect(routes.ProductController.index)
  }

}
